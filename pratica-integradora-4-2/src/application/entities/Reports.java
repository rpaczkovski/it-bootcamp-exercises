package application.entities;

import application.entities.interfaces.Printable;

public class Reports implements Printable {

    private String text;
    private Integer numberPages;
    private String author;
    private String reviewer;

    public Reports(String text, Integer numberPages, String author, String reviewer) {
        this.text = text;
        this.numberPages = numberPages;
        this.author = author;
        this.reviewer = reviewer;
    }

    @Override
    public void print() {
        System.out.println("Reports{" +
                "text='" + text + '\'' +
                ", numberPages=" + numberPages +
                ", author='" + author + '\'' +
                ", reviewer='" + reviewer + '\'' +
                '}');
    }
}
