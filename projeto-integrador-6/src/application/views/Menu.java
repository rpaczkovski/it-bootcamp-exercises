package application.views;

import java.util.Scanner;

public class Menu {

    public static Menu getInstance() {
        return new Menu();
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);

        int option;
        do {

            System.out.print("##-- MENU DO PROGRAMA --##\n\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("| 1 - CLIENTES                |\n");
            System.out.print("| 2 - PRODUTO                 |\n");
            System.out.print("| 3 - VENDAS                  |\n");
            System.out.print("|                             |\n");
            System.out.print("| 0 - SAIR                    |\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("Digite uma opção: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    ClientMenu.execute();
                    break;
                case 2:
                    ItemMenu.execute();
                 break;
                case 3:
                    InvoiceMenu.execute();
                 break;
                case 0:
                    System.out.println("Obrigado!");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        } while (option != 0);
    }

}
