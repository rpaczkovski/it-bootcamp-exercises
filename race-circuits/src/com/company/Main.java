package com.company;

import java.util.*;

public class Main {

    public static String calculatePrice(String typeCircuit, int age) {
        String priceCircuit = "";

        switch (typeCircuit) {
            case "pequeno": {
                if(age < 18) {
                    priceCircuit = "R$ 1.300";
                } else {
                    priceCircuit = "R$ 1.500";
                }
                break;
            } case "medio": {
                if (age < 18) {
                    priceCircuit = "R$ 2.000";
                } else {
                    priceCircuit = "R$ 2.300";
                }
                break;
            } default: {
                priceCircuit = "R$ 2.8000";
            }
        }

        return  priceCircuit;
    }

    public static People createPeople(Scanner scanner) {
        People p = new People();
        System.out.println("Digite nome: ");
        p.setName(scanner.next());
        System.out.println("Digite o sobrenome: ");
        p.setLastName(scanner.next());
        System.out.println("Digite a idade: ");
        p.setAge(scanner.nextInt());
        System.out.println("Digite o celular: ");
        p.setPhoneNumber(scanner.next());
        System.out.println("Digite o celular de emergencia: ");
        p.setEmergencyPhoneNumber(scanner.next());
        System.out.println("Digite o tipo sanguineo: ");
        p.setBloodType(scanner.next());
        System.out.println("Digite o circuito [pequeno, medio, avancado]: ");
        p.setCircuit(scanner.next());

        if(p.getAge() < 18 && p.getCircuit().equals("avancado")) {
            System.out.println("Voce nao pode participar dessa modalidade, por favor tente novamente!");
        }

        String priceCircuit = calculatePrice(p.getCircuit(), p.getAge());
        p.setPriceCircuit(priceCircuit);

        return p;
    }

    public static int menu(Scanner scanner) {
        int select;

        System.out.println("---- MENU PRINCIPAL ----");
        System.out.println("1: Cadastrar uma pessoa.");
        System.out.println("2: Listar competidores.");
        System.out.println("3: Remover competidor.");
        System.out.println("0: Sair");

        select = scanner.nextInt();
        return select;
    }


    public static void main(String[] args) {
        int globaKey = 0;
        HashMap<Integer, People> listPeoples = new HashMap<Integer, People>();
        Scanner scanner = new Scanner(System.in);
        int control = 0;

        do {
            control = menu(scanner);
            switch (control) {
                case 1 : {
                    People people = createPeople(scanner);
                    
                    if(people == null) {
                        break;
                    }
                    listPeoples.put(globaKey, people);
                    globaKey++;
                    break;
               }
                case 2: {
                    listPeoples.entrySet().forEach(entry -> {
                        People p = entry.getValue();
                        System.out.println("O competidor " + p.getName() + " " + p.getLastName() + " vai participar do circuito " + p.getCircuit() + " eh o valor dessa modalidade e de " + p.getPriceCircuit());
                    });
                    break;
                }
                case 3: {
                    System.out.println("Digite o codigo do participante: ");
                    int key = scanner.nextInt();
                    People p = listPeoples.remove(key);

                    if(p == null) {
                        System.out.println("Participante ja foi removido.");
                    } else {
                        System.out.println("Participante removido com sucesso!");
                    }
                    break;
                }
                case 0: {
                    System.out.println("Bye. Obrigado por utilizar o sistema.");
                    break;
                }
            }
        } while (control != 0);



    }
}
