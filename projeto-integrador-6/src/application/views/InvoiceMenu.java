package application.views;

import application.controllers.ClientController;
import application.controllers.InvoiceController;
import application.controllers.ItemController;
import application.models.entities.Client;
import application.models.entities.Invoice;
import application.models.entities.Item;
import application.repositories.ClientRepository;
import application.repositories.InvoiceRepository;
import application.repositories.ItemRepository;

import java.math.BigDecimal;
import java.util.Scanner;

public class InvoiceMenu {

    public static void execute() {
        Scanner scanner = new Scanner(System.in);

        ClientRepository clientRepository = new ClientRepository();
        InvoiceRepository invoiceRepository = new InvoiceRepository();
        ClientController clientController = new ClientController(clientRepository);
        InvoiceController invoiceController = new InvoiceController(invoiceRepository);
        ItemRepository itemRepository = new ItemRepository();
        ItemController itemController = new ItemController(itemRepository);

        int globalInvoiceId = 0;
        int clientId;
        String productCode;
        int invoiceId;
        int option;
        do {
            System.out.print("##-- MENU DO VENDAS --##\n\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("| 1 - Realizar venda          |\n");
            System.out.print("| 2 - Listar vendas           |\n");
            System.out.print("| 3 - Buscar  venda           |\n");
            System.out.print("| 4 - Deletar venda           |\n");
            System.out.print("| 0 - Voltar                  |\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("Digite uma opção: ");

            option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Digite o ID do cliente: ");
                    clientId = scanner.nextInt();
                    Client client = clientController.findById(clientId);

                    if(client == null) {
                        System.out.println("Cadastrar novo cliente");

                        System.out.print("Digite o nome: ");
                        String name = scanner.next();
                        System.out.print("Digite o sobrenome: ");
                        String surname = scanner.next();

                        clientController.create(new Client(clientId, name, surname));
                    }

                    System.out.print("Digite o codigo do produto: ");
                    productCode = scanner.next();

                    Item item = itemController.findById(productCode);

                    if(item == null) {
                        System.out.println("Produto nao encontrado. Deseja um produto com esse codigo? (y/n): ");
                        char response = scanner.next().charAt(0);

                        if(response == 'y') {
                            System.out.print("Digite o nome do produto: ");
                            String name = scanner.next();
                            System.out.print("Digite a quantidade: ");
                            int quantity = scanner.nextInt();
                            System.out.print("Digite o custo unitario: ");
                            BigDecimal unitCoast = scanner.nextBigDecimal();

                            item = itemController.create(new Item(productCode, name, quantity, unitCoast));

                        } else {
                            break;
                        }
                    }

                    Invoice invoice = new Invoice(globalInvoiceId++, client);
                    invoice.addItem(item);
                    invoiceController.create(invoice);

                    System.out.println("Venda realizada!");
                    System.out.println();

                    break;
                case 2:
                    System.out.println("Lista de recibos: ");
                    invoiceController.findAll().forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Digite o ID do recibo: ");
                    invoiceId = scanner.nextInt();
                    Invoice invoiceFetched = invoiceRepository.findById(invoiceId);

                    if(invoiceFetched == null) {
                        System.out.println("Recibo nao encontrado.");
                        break;
                    }
                    System.out.println(invoiceFetched);
                    break;
                case 4:
                    System.out.print("Digite o ID do recibo: ");
                    invoiceId = scanner.nextInt();
                    invoiceRepository.deleteById(invoiceId);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        } while (option != 0);

    }
}
