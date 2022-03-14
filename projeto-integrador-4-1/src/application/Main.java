package application;

import models.entities.BasicBankAccount;
import models.entities.CollaboratorBankAccount;
import models.entities.ExecutiveBankAccount;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        BasicBankAccount basicAccount = new BasicBankAccount(BigDecimal.valueOf(1000), "Rodrigo");
        ExecutiveBankAccount executiveAccount = new ExecutiveBankAccount(BigDecimal.valueOf(1000), "Anna");
        CollaboratorBankAccount collaboratorAccount = new CollaboratorBankAccount(BigDecimal.valueOf(1000), "Anna");

        System.out.println("Iniciando o sistema!");
        System.out.println("CONTA BASICA: ");
        basicAccount.getBalance();
        basicAccount.paymentService();
        System.out.println("CONTA EXECUTIVA: ");
        executiveAccount.deposit();
        executiveAccount.transfer();
        System.out.println("CONTA COLABORADOR: ");
        collaboratorAccount.getBalance();
        collaboratorAccount.withdraw();
        ;


    }
}
