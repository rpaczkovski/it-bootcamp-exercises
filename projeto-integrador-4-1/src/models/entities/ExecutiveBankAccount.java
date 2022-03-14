package models.entities;

import java.math.BigDecimal;

public class ExecutiveBankAccount extends BankAccount {
    public ExecutiveBankAccount(BigDecimal balance, String name) {
        super(balance, name);
    }

    public void deposit() {
        System.out.println("Realizando o deposito...");
        transactionOk();
    }

    public void transfer() {
        System.out.println("Realizanod a transferencia...");
        transactionOk();
    }
}
