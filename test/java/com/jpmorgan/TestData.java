package test.java.com.jpmorgan;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import main.java.com.jpmorgan.EntityDataObject;
import main.java.com.jpmorgan.EntityDirection;

import org.joda.time.LocalDate;

public class TestData {
	
	public static List<EntityDataObject> getTestEntityDataObjects(){
		List<EntityDataObject> entityDataObjects = new ArrayList<>();
		EntityDataObject dataObject1 = new EntityDataObject();
		dataObject1.setEntityName("Instrument1");
		dataObject1.setDirection(EntityDirection.fromCode("B"));
		dataObject1.setAgreedFx(new BigDecimal("0.50"));
		dataObject1.setCurrency("SGP");
		dataObject1.setInstructionDate(new LocalDate(2017,9,25));
		dataObject1.setSettlementDate(new LocalDate(2017,9,30));
		dataObject1.setUnits(200L);
		dataObject1.setPricePerUnit(new BigDecimal("100.25"));
		entityDataObjects.add(dataObject1);
		
		EntityDataObject dataObject2 = new EntityDataObject();
		dataObject2.setEntityName("Instrument2");
		dataObject2.setDirection(EntityDirection.fromCode("S"));
		dataObject2.setAgreedFx(new BigDecimal("0.22"));
		dataObject2.setCurrency("AED");
		dataObject2.setInstructionDate(new LocalDate(2017,9,23));
		dataObject2.setSettlementDate(new LocalDate(2017,9,25));
		dataObject2.setUnits(450L);
		dataObject2.setPricePerUnit(new BigDecimal("150.5"));
		entityDataObjects.add(dataObject2);
		
		EntityDataObject dataObject3 = new EntityDataObject();
		dataObject3.setEntityName("Instrument3");
		dataObject3.setDirection(EntityDirection.fromCode("S"));
		dataObject3.setAgreedFx(new BigDecimal("0.27"));
		dataObject3.setCurrency("SAR");
		dataObject3.setInstructionDate(new LocalDate(2017,9,27));
		dataObject3.setSettlementDate(new LocalDate(2017,9,29));
		dataObject3.setUnits(150L);
		dataObject3.setPricePerUnit(new BigDecimal("120.35"));
		entityDataObjects.add(dataObject3);
		
		EntityDataObject dataObject4 = new EntityDataObject();
		dataObject4.setEntityName("Instrument4");
		dataObject4.setDirection(EntityDirection.fromCode("B"));
		dataObject4.setAgreedFx(new BigDecimal("1.00"));
		dataObject4.setCurrency("USD");
		dataObject4.setInstructionDate(new LocalDate(2017,9,27));
		dataObject4.setSettlementDate(new LocalDate(2017,10,2));
		dataObject4.setUnits(100L);
		dataObject4.setPricePerUnit(new BigDecimal("98.245"));
		entityDataObjects.add(dataObject4);
		
		EntityDataObject dataObject5 = new EntityDataObject();
		dataObject5.setEntityName("Instrument5");
		dataObject5.setDirection(EntityDirection.fromCode("B"));
		dataObject5.setAgreedFx(new BigDecimal("1.20"));
		dataObject5.setCurrency("EUR");
		dataObject5.setInstructionDate(new LocalDate(2017,9,27));
		dataObject5.setSettlementDate(new LocalDate(2017,10,7));
		dataObject5.setUnits(170L);
		dataObject5.setPricePerUnit(new BigDecimal("135.24"));
		entityDataObjects.add(dataObject5);
		
		EntityDataObject dataObject6 = new EntityDataObject();
		dataObject6.setEntityName("Instrument6");
		dataObject6.setDirection(EntityDirection.fromCode("B"));
		dataObject6.setAgreedFx(new BigDecimal("1.20"));
		dataObject6.setCurrency("EUR");
		dataObject6.setInstructionDate(new LocalDate(2017,9,27));
		dataObject6.setSettlementDate(new LocalDate(2017,10,8));
		dataObject6.setUnits(110L);
		dataObject6.setPricePerUnit(new BigDecimal("180.75"));
		entityDataObjects.add(dataObject6);
		
		return entityDataObjects;
		
	}
	
	public static List<EntityDataObject> getTestEntityDataObjectsWithWrongData(){
		List<EntityDataObject> entityDataObjects = new ArrayList<>();
		EntityDataObject dataObject1 = new EntityDataObject();
		dataObject1.setEntityName("Instrument1");
		dataObject1.setDirection(EntityDirection.fromCode("B"));
		dataObject1.setAgreedFx(new BigDecimal("0.50"));
		dataObject1.setCurrency("SGP");
		dataObject1.setInstructionDate(new LocalDate(2017,9,25));
		dataObject1.setSettlementDate(new LocalDate(2017,9,30));
		dataObject1.setUnits(200L);
		dataObject1.setPricePerUnit(null);
		entityDataObjects.add(dataObject1);
		
		EntityDataObject dataObject2 = new EntityDataObject();
		dataObject2.setEntityName("Instrument2");
		dataObject2.setDirection(EntityDirection.fromCode("S"));
		dataObject2.setAgreedFx(new BigDecimal("0.22"));
		dataObject2.setCurrency("AED");
		dataObject2.setInstructionDate(new LocalDate(2017,9,23));
		dataObject2.setSettlementDate(new LocalDate(2017,9,25));
		dataObject2.setUnits(null);
		dataObject2.setPricePerUnit(new BigDecimal("150.5"));
		entityDataObjects.add(dataObject2);
		
		return entityDataObjects;
		
	}

}
