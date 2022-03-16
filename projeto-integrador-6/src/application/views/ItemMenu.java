package application.views;

import application.controllers.ItemController;
import application.models.entities.Item;
import application.repositories.ItemRepository;

import java.math.BigDecimal;
import java.util.Scanner;

public class ItemMenu {

    public static void execute() {
        Scanner scanner = new Scanner(System.in);

        ItemRepository itemRepository = new ItemRepository();
        ItemController itemController = new ItemController(itemRepository);

        String productCode;
        int option;
        do {
            System.out.print("##-- MENU DE PRODUTOS --##\n\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("| 1 - Adicionar produto       |\n");
            System.out.print("| 2 - Listar produtos         |\n");
            System.out.print("| 3 - Buscar produto          |\n");
            System.out.print("| 4 - Remover produto         |\n");
            System.out.print("| 0 - Voltar                  |\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("Digite uma opção: ");


            option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Digite o codigo do produto: ");
                    productCode = scanner.next();

                    Item item = itemController.findById(productCode);

                    if(item != null) {
                        System.out.println("Codigo invalido, digite outro codigo.");
                        break;
                    }

                    System.out.print("Digite o nome do produto: ");
                    String name = scanner.next();
                    System.out.print("Digite a quantidade: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Digite o custo unitario: ");
                    BigDecimal unitCoast = scanner.nextBigDecimal();

                    itemController.create(new Item(productCode, name, quantity, unitCoast));

                    break;
                case 2:
                    System.out.println("Lista de produtos: ");
                    itemController.findAll().forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Digite o codigo do produto: ");
                    productCode = scanner.next();
                    Item itemFetched = itemController.findById(productCode);

                    if(itemFetched == null) {
                        System.out.println("Produto nao encontrado.");
                        break;
                    }
                    System.out.println(itemFetched);
                    break;
                case 4:
                    System.out.print("Digite o codigo do produto: ");
                    productCode = scanner.next();
                    itemRepository.deleteById(productCode);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        } while (option != 0);

    }
}
