package application;

import application.entities.Cat;
import application.entities.Cow;
import application.entities.Dog;

public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat("Felix", 6);
        cat.sound();
        cat.eatMeat();

        Dog dog = new Dog("Rex", 3);
        dog.sound();
        dog.eatMeat();

        Cow cow = new Cow("Mimosa", 4);
        cow.sound();
        cow.eatPasture();
    }
}
