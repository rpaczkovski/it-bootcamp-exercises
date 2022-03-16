package application.models.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Invoice {

    private Integer ID;
    private Client client;
    private final List<Item> items = new ArrayList<>();
    private BigDecimal totalPrice;

    public Invoice(Integer id, Client client) {
        this.client = client;
        totalPrice = BigDecimal.valueOf(0);
        this.ID = id;
    }

    public BigDecimal getTotalPrice() {
        return sumItems();
    }

    public Client getClient() {
        return client;
    }

    public List<Item> getItems() {
        return items;
    }

    public Integer getID() {
        return ID;
    }


    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    private BigDecimal sumItems() {
        totalPrice = items.stream()
                .map(x -> x.getUnitCoast().multiply(BigDecimal.valueOf(x.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return this.totalPrice;
    }

    @Override
    public String toString() {
        return "\n" +
                "Recibo dados: " +
                "ID=" + ID +
                ", cliente=" + client +
                ", Produtos=" + items;
    }
}
