package application.models.entities;

import java.math.BigDecimal;

public class Item {

    private String code;
    private String name;
    private Integer quantity;
    private BigDecimal unitCoast;

    public Item(String code, String name, Integer quantity, BigDecimal unitCoast) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.unitCoast = unitCoast;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitCoast() {
        return unitCoast;
    }

    public void setUnitCoast(BigDecimal unitCoast) {
        this.unitCoast = unitCoast;
    }

    @Override
    public String toString() {
        return "\n" +
                "Produto dados: " +
                "codigo='" + code + '\'' +
                ", nome='" + name + '\'' +
                ", quantidade=" + quantity +
                ", custo unitatrio=" + unitCoast;
    }
}
