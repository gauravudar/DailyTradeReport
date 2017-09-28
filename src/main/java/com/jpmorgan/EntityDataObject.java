package main.java.com.jpmorgan;

import java.math.BigDecimal;
import java.util.Objects;

import org.joda.time.LocalDate;

public class EntityDataObject {
    private String entityName;
    private EntityDirection direction;
    private BigDecimal agreedFx;
    private String currency;
    private LocalDate instructionDate;
    private LocalDate settlementDate;
    private Long units;
    private BigDecimal pricePerUnit;

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public EntityDirection getDirection() {
        return direction;
    }

    public void setDirection(EntityDirection direction) {
        this.direction = direction;
    }

    public BigDecimal getAgreedFx() {
        return agreedFx;
    }

    public void setAgreedFx(BigDecimal agreedFx) {
        this.agreedFx = agreedFx;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public Long getUnits() {
        return units;
    }

    public void setUnits(Long units) {
        this.units = units;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityDataObject that = (EntityDataObject) o;
        return Objects.equals(getEntityName(), that.getEntityName()) &&
               Objects.equals(getDirection(), that.getDirection()) &&
               Objects.equals(getAgreedFx(), that.getAgreedFx()) &&
               Objects.equals(getCurrency(), that.getCurrency()) &&
               Objects.equals(getInstructionDate(), that.getInstructionDate()) &&
               Objects.equals(getSettlementDate(), that.getSettlementDate()) &&
               Objects.equals(getUnits(), that.getUnits());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEntityName(),getDirection(),getAgreedFx(),getCurrency(),getInstructionDate(),getSettlementDate(),getUnits());
    }

    @Override
    public String toString() {
        return new StringBuilder()
            .append("entityName:" + entityName)
            .append("direction:" + direction)
            .append("agreedFx" + agreedFx)
            .append("currency" + currency)
            .append("instructionDate" + instructionDate)
            .append("settlementDate" + settlementDate)
            .append("units" + units)
            .toString();
    }
}
