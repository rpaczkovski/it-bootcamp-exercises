package models.entities;

public class Transactions implements models.interfaces.Transactions {

    @Override
    public boolean transactionOk() {
        return false;
    }

    @Override
    public boolean transactionNotOk() {
        return false;
    }
}
