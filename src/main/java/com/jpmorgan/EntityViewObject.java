package main.java.com.jpmorgan;

import java.math.BigDecimal;
import java.util.Objects;

import org.joda.time.LocalDate;

public class EntityViewObject {
    private String tradeName;
    private BigDecimal incomingAmountInUsd;
    private BigDecimal outgoingAmountInUsd;
    private LocalDate instructionDate;
    private LocalDate settlementDate;    

    public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public BigDecimal getIncomingAmountInUsd() {
        return incomingAmountInUsd;
    }

    public void setIncomingAmountInUsd(BigDecimal incomingAmountInUsd) {
        this.incomingAmountInUsd = incomingAmountInUsd;
    }

    public BigDecimal getOutgoingAmountInUsd() {
        return outgoingAmountInUsd;
    }

    public void setOutgoingAmountInUsd(BigDecimal outgoingAmountInUsd) {
        this.outgoingAmountInUsd = outgoingAmountInUsd;
    }

    public LocalDate getInstructionDate() {
        return instructionDate;
    }

    public void setInstructionDate(LocalDate instructionDate) {
        this.instructionDate = instructionDate;
    }

    public LocalDate getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(LocalDate settlementDate) {
        this.settlementDate = settlementDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityViewObject that = (EntityViewObject) o;
        return Objects.equals(getIncomingAmountInUsd(), that.getIncomingAmountInUsd()) &&
               Objects.equals(getOutgoingAmountInUsd(), that.getOutgoingAmountInUsd()) &&
               Objects.equals(getTradeName(), that.getTradeName()) &&
               Objects.equals(getInstructionDate(), that.getInstructionDate()) &&
               Objects.equals(getSettlementDate(), that.getSettlementDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIncomingAmountInUsd(),getOutgoingAmountInUsd(),getTradeName(), getInstructionDate(),getSettlementDate());
    }

    @Override
    public String toString() {
        return new StringBuilder()
            .append("tradeName:" +  tradeName)
            .append("incomingAmountInUsd:" + incomingAmountInUsd)
            .append("outgoingAmountInUsd:" + outgoingAmountInUsd)
            .append("instructionDate:" + instructionDate)
            .append("settlementDate:" + settlementDate)
            .toString();
    }
}
