package models.entities;

import java.math.BigDecimal;

public class CollaboratorBankAccount extends BankAccount {

    public CollaboratorBankAccount(BigDecimal balance, String name) {
        super(balance, name);
    }

    public void withdraw() {
        System.out.println("Realizando o saque...");
        super.transactionOk();
    }

}
