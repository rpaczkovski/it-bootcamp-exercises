package com.exercise1;

public class Main {



    public static void resultGreater(boolean isOfGreater) {
        if (isOfGreater) {
            System.out.println("Voce eh maior de idade.");
        } else {
            System.out.println("Voce eh menor de idade");
        }
    }

    public static void main(String[] args) {
        People rafael = new People();
        People ana = new People("2", "Ana", 28);
        People rodrigo = new People("3", "Rodrigo", 21, 69, 1.69);

        System.out.println(rodrigo);

    }
}