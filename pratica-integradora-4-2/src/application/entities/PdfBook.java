package application.entities;

import application.entities.interfaces.Printable;

public class PdfBook implements Printable {

    private Integer numberPages;
    private String author;
    private String title;
    private String genre;

    public PdfBook(Integer numberPages, String author, String title, String genre) {
        this.numberPages = numberPages;
        this.author = author;
        this.title = title;
        this.genre = genre;
    }

    @Override
    public void print() {
        System.out.println("PdfBook{" +
                "numberPages=" + numberPages +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                '}');
    }
}
