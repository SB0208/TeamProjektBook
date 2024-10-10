package com.library.backend.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document( collection = "books")

public class Book {

    @Id
    private String id;
    private String title;
    private String author;
    private String description;
    private int year;
    private boolean isRead = true;

    public Book(String title, String author, int year, String description, boolean isRead) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.description = description;
        this.isRead = isRead;


    }

    public void addNewBook () {

  }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setYear(int year) {
        this.year = year;
    }

    public Book() {
        this.title = "";
        this.author = "";
        this.year = 0;
        this.description = "";
        this.isRead = true;


    }

    public static Book newBook (String title, String author, String description, boolean isRead, int year) {
        return new Book();
    }

    // Getter und Setter
    public String getId()
    { return id; }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getYear() {
            return year;

    }


    public void setYear() {
        this.year = year;

    }
    public boolean isRead() { return isRead; }
    public void setRead(boolean isRead) { this.isRead = isRead; }


}
