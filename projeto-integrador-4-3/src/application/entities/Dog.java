package application.entities;

import application.entities.intefaces.Carnivore;

public class Dog extends Animal implements Carnivore {


    public Dog(String name, Integer age) {
        super(name, age);
    }

    @Override
    public void sound() {
        System.out.println("Auau");
    }

    @Override
    public void eatMeat() {
        System.out.println(getName() + " esta se alimento...");
    }
}
