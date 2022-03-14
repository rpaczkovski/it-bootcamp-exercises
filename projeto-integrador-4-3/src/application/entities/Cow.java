package application.entities;

import application.entities.intefaces.Herbivore;

public class Cow extends Animal implements Herbivore {

    public Cow(String name, Integer age) {
        super(name, age);
    }

    @Override
    public void sound() {
        System.out.println("mu");
    }

    @Override
    public void eatPasture() {
        System.out.println(getName() + " esta se alimento...");
    }
}
