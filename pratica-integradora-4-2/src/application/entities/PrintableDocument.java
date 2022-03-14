package application.entities;

import application.entities.interfaces.Printable;

public class PrintableDocument {
    public static void print(Printable printable) {
        printable.print();
    }
}
