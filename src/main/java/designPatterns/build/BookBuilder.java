package designPatterns.build;

import designPatterns.build.immutable.Book;

import java.util.Date;

public class BookBuilder {

    private String code;
    private String title;
    private String genre;
    private String author;
    private Date publishingYear;
    private String description;

    private int pages;

    public BookBuilder setCode(String code) {
        this.code = code;
        return this;
    }

    public BookBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public BookBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }

    public BookBuilder setPublishingYear(Date publishingYear) {
        this.publishingYear = publishingYear;
        return this;
    }

    public BookBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public BookBuilder setAge(int pages){
        this.pages = pages;
        return this;
    }

    public Book build(){
        return new Book(code,title,genre,author,publishingYear,description, pages);
    }

}
