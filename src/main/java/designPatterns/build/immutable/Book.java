package designPatterns.build.immutable;

import java.util.Date;

public class Book {

    private final String code;
    private final String Title;
    private final String genre;
    private final String author;
    private final Date publishingYear;
    private final String description;

    private final int pages;

    public Book(String code, String title, String genre, String author, Date publishingYear, String description,int pages) {
        this.code = code;
        Title = title;
        this.genre = genre;
        this.author = author;
        this.publishingYear = publishingYear;
        this.description = description;
        this.pages =pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "code='" + code + '\'' +
                ", Title='" + Title + '\'' +
                ", genre='" + genre + '\'' +
                ", author='" + author + '\'' +
                ", publishingYear=" + publishingYear +
                ", description='" + description + '\'' +
                ", age=" + pages +
                '}';
    }

}
