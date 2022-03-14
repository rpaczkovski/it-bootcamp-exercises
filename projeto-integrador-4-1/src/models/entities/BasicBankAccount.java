package models.entities;

import models.interfaces.Transactions;

import java.math.BigDecimal;

public class BasicBankAccount extends BankAccount  {

    public BasicBankAccount(BigDecimal balance, String name) {
        super(balance, name);
    }



    public void paymentService() {
        System.out.println("Realizando pagamento de servico...");
        transactionNotOk();
    }


}
