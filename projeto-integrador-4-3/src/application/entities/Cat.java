package application.entities;

import application.entities.intefaces.Carnivore;

public class Cat extends Animal implements Carnivore {


    public Cat(String name, Integer age) {
        super(name, age);
    }

    @Override
    public void sound() {
        System.out.println("miau");
    }

    @Override
    public void eatMeat() {
        System.out.println(getName() + " esta se alimento...");
    }
}
