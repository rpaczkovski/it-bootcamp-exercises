package com.exercise1;

public class People {
    private String ID;
    private String name;
    private int age;
    private double weight;
    private double height;

    public People() {
    }

    public People(String ID, String name, int age) {
        this.ID = ID;
        this.name = name;
        this.age = age;
    }

    public People(String ID, String name, int age, double weight, double height) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

     private int calculateIMC() {
        double result = weight / Math.pow(height, 2);

        if (result < 20) {
            return -1;
        } else if (result >= 20 && result <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    public String resultIMC() {
        int imc = calculateIMC();

        switch (imc) {
            case -1:
                return "Abaixo do peso.";
            case 0:
                return "Peso Saudavel.";
            case 1:
                return "Sobrepeso";
            default:
                return  null;
         }
    }

    private boolean isOfGreate() {
        return age < 18 ? false : true;
    }

    public String getOfGreate() {
        return isOfGreate()  ? "eh maior de idade." : "eh menor de idade.";
    }

    @Override
    public String toString() {
        return "People{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", IMC=" + resultIMC() +
                ", legalAge=" + getOfGreate() +
                '}';
    }
}
