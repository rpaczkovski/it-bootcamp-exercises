package models.entities;

import java.math.BigDecimal;

public abstract class BankAccount extends Transactions {

    private BigDecimal balance;
    private String name;

    public BankAccount(BigDecimal balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void withdraw() {
        System.out.println("Realizando o saque da conta...");
        transactionOk();
    }

    @Override
    public boolean transactionOk() {
        System.out.println("O status da transacao eh FALSO");
        return false;
    }

    @Override
    public boolean transactionNotOk() {
        System.out.println("O stattus da transacao eh VERDADEIRO");
        return false;
    }

}
