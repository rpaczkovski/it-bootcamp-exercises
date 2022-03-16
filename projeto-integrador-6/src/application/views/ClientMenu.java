package application.views;

import application.controllers.ClientController;
import application.controllers.InvoiceController;
import application.models.entities.Client;
import application.models.entities.Invoice;
import application.repositories.ClientRepository;
import application.repositories.InvoiceRepository;

import java.util.Scanner;

public class ClientMenu {

    public static void execute() {
        Scanner scanner = new Scanner(System.in);

        ClientRepository repository = new ClientRepository();
        InvoiceRepository invoiceRepository = new InvoiceRepository();
        ClientController clientController = new ClientController(repository);
        InvoiceController invoiceController = new InvoiceController(invoiceRepository);

        int globalClientId = 0;
        int clientId;
        int option = 0;
        do {
            System.out.print("##-- MENU DO CLIENTE --##\n\n");
            System.out.print("|-----------------------------------|\n");
            System.out.print("| 1 - Adicionar cliente             |\n");
            System.out.print("| 2 - Listar cliente                |\n");
            System.out.print("| 3 - Buscar cliente                |\n");
            System.out.print("| 4 - Calcular compras de cliente   |\n");
            System.out.print("| 5 - Remover cliente               |\n");
            System.out.print("| 0 - Voltar                        |\n");
            System.out.print("|-----------------------------------|\n");
            System.out.print("Digite uma opção: ");

            option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String name = scanner.next();
                    System.out.print("Digite o sobrenome: ");
                    String surname = scanner.next();

                    clientController.create(new Client(globalClientId++, name, surname));
                    break;
                case 2:
                    System.out.println("Lista de clientes: ");
                    clientController.findAll().forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Digite o ID do cliente: ");
                    clientId = scanner.nextInt();
                    Client client = clientController.findById(clientId);

                    if(client == null) {
                        System.out.println("Cliente nao encontrado.");
                        break;
                    }

                    System.out.println(client);
                    break;
                case 4:
                    System.out.print("Digite o ID do cliente: ");
                    clientId = scanner.nextInt();

                    Invoice invoice = invoiceController.findByClientId(clientId);
                    System.out.println();
                    System.out.println("--------------------- #####");
                    invoice.getItems().forEach(System.out::println);
                    System.out.println("--------------------- TOTAL: R$" + invoice.getTotalPrice());
                    System.out.println();

                    break;
                case 5:
                    System.out.print("Digite o ID do cliente: ");
                    clientId = scanner.nextInt();
                    clientController.deleteById(clientId);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        } while (option != 0);


    }
}
