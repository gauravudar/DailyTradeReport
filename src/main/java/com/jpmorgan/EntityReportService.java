package main.java.com.jpmorgan;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.LocalDate;

public class EntityReportService {
    private BusinessDateProvider businessDateProvider;

    /**
     * Generates and Prints daily  trade report for each day
     * @param instructions in the form of Entity Data Object
    */
    public void generateAndPrintTradeReport(List<EntityDataObject> entityDataObjects){
        try {
            List<EntityViewObject> entityForReportDates = entityDataObjects.stream()
                                                                           .map(entity -> covertToEntityViewObject(entity))
                                                                           .collect(Collectors.toList());
            Comparator<EntityViewObject> incomingTradeAmtComparator = (e1, e2)->e1.getIncomingAmountInUsd().compareTo(e2.getIncomingAmountInUsd());
            List<EntityViewObject> incomingTradeSettledAmt = entityForReportDates.stream()
            		                                                             .filter(entity->!entity.getIncomingAmountInUsd().equals(BigDecimal.ZERO))
            		                                                             .collect(Collectors.toList());
            incomingTradeSettledAmt.sort(incomingTradeAmtComparator.reversed());
            
            Comparator<EntityViewObject> outgoingTradeAmtComparator = (e1, e2)->e1.getOutgoingAmountInUsd().compareTo(e2.getOutgoingAmountInUsd());
            List<EntityViewObject> outgoingTradeSettledAmt = entityForReportDates.stream()
            		                                                             .filter(entity->!entity.getOutgoingAmountInUsd().equals(BigDecimal.ZERO))
            		                                                             .collect(Collectors.toList());
            outgoingTradeSettledAmt.sort(outgoingTradeAmtComparator.reversed());
            
            System.out.println("Trade Name | Incoming Settled Amount | Outgoing Settled Amount | Ranking | Settlement Date \n");
            for(int i=0;i<incomingTradeSettledAmt.size();i++){
            	int rank = i+1;
                System.out.println(incomingTradeSettledAmt.get(i).getTradeName()+"     |    "+incomingTradeSettledAmt.get(i).getIncomingAmountInUsd()+"     |    "+incomingTradeSettledAmt.get(i).getOutgoingAmountInUsd()+"      |     " + rank + "      |     " + incomingTradeSettledAmt.get(i).getSettlementDate() + "\n");
            }
            for(int i=0;i<outgoingTradeSettledAmt.size();i++){
            	int rank = i+1;
                System.out.println(outgoingTradeSettledAmt.get(i).getTradeName()+"     |    "+outgoingTradeSettledAmt.get(i).getIncomingAmountInUsd()+"     |    "+outgoingTradeSettledAmt.get(i).getOutgoingAmountInUsd()+"      |     " + rank + "      |     " + outgoingTradeSettledAmt.get(i).getSettlementDate() +"\n");
            }

        } catch (Exception e){
            System.out.println(String.format("Error in generating trade report",e));
        }
    }

    private EntityViewObject covertToEntityViewObject(EntityDataObject entityDataObject){
        LocalDate settlementDate = businessDateProvider.validateBusinessDateForWeekend(entityDataObject.getCurrency(),entityDataObject.getSettlementDate());
        entityDataObject.setSettlementDate(settlementDate);

        return performCalculations(entityDataObject, settlementDate);

    }

    private EntityViewObject performCalculations(EntityDataObject entityDataObject,
                                     LocalDate settlementDate) {

        EntityViewObject viewObject = new EntityViewObject();
        BigDecimal amountOfTradeInUsd = getAmountOfTradeInUsd(entityDataObject.getPricePerUnit(), entityDataObject.getUnits(), entityDataObject.getAgreedFx());
        viewObject.setSettlementDate(settlementDate);
        viewObject.setInstructionDate(entityDataObject.getInstructionDate());
        viewObject.setTradeName(entityDataObject.getEntityName());

        if(entityDataObject.getDirection() == EntityDirection.BUY) {
            viewObject.setIncomingAmountInUsd(BigDecimal.ZERO);
            viewObject.setOutgoingAmountInUsd(amountOfTradeInUsd);
        }
        if(entityDataObject.getDirection()==EntityDirection.SELL) {
            viewObject.setIncomingAmountInUsd(amountOfTradeInUsd);
            viewObject.setOutgoingAmountInUsd(BigDecimal.ZERO);
        }
        return viewObject;
    }

    private BigDecimal getAmountOfTradeInUsd(BigDecimal pricePerUnit,Long units, BigDecimal agreedFx) {
        return pricePerUnit.multiply(BigDecimal.valueOf(units)).multiply(agreedFx);
    }

    public void setBusinessDateProvider(BusinessDateProvider businessDateProvider) {
        this.businessDateProvider = businessDateProvider;
    }
}
