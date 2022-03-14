package application;

import application.entities.*;

public class Main {

    public static void main(String[] args) {

        People people = new People("Anna", "Soares", 18);
        Curriculum curriculum = new Curriculum(people);
        curriculum.addSkill("Programadora");

        PrintableDocument.print(curriculum);

        PdfBook pdfBook = new PdfBook(200, "Rafa Mendes", "Como programar em Java", "TI");
        PrintableDocument.print(pdfBook);

        Reports reports = new Reports("Lorem ipsum", 190, "Rogerio", "Gabriela");
        PrintableDocument.print(reports);


    }
}
