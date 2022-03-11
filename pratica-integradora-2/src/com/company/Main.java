package com.company;

import java.math.BigDecimal;
import java.util.*;

public class Main {

    public static Integer calculatePrice(String typeCircuit, int age) {
        Integer priceCircuit;

        switch (typeCircuit) {
            case "PEQUENO": {
                if(age < 18) {
                    priceCircuit = 1300;
                } else {
                    priceCircuit = 1500;
                }
                break;
            } case "MEDIO": {
                if (age < 18) {
                    priceCircuit = 2000;
                } else {
                    priceCircuit = 2300;
                }
                break;
            } default: {
                priceCircuit = 28000;
            }
        }

        return  priceCircuit;
    }

    public static Participant createPeople(Scanner scanner) {
        Participant p = new Participant();
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
        p.setCircuit(TypeCircuit.valueOf(scanner.next().toUpperCase(Locale.ROOT)));

        if(p.getAge() < 18 && p.getCircuit().equals("avancado")) {
            System.out.println("Voce nao pode participar dessa modalidade, por favor tente novamente!");
        }

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
        HashMap<Integer, Participant> listParcipants = new HashMap<Integer, Participant>();
        Scanner scanner = new Scanner(System.in);
        int control = 0;

        do {
            control = menu(scanner);
            switch (control) {
                case 1 : {
                    Participant participant = createPeople(scanner);
                    
                    if(participant == null) {
                        break;
                    }
                    listParcipants.put(globaKey, participant);
                    globaKey++;
                    break;
               }
                case 2: {
                    listParcipants.entrySet().forEach(entry -> {
                        Participant p = entry.getValue();
                        Integer price = calculatePrice(String.valueOf(p.getCircuit()), p.getAge());
                        System.out.println("O participante " + p.getName() + " " + p.getLastName() + " vai participar do circuito " + p.getCircuit() + " eh o valor dessa modalidade e de " + price);
                    });
                    break;
                }
                case 3: {
                    System.out.println("Digite o codigo do participante: ");
                    int key = scanner.nextInt();
                    Participant p = listParcipants.remove(key);

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
