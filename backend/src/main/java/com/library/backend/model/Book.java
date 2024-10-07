package com.library.backend.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("books")

public class Book {

    @Id
    private String id;
    private String title;
    private String author;
    private int year;

    public Book(String toKillAMockingbird, String harperLee, int year) {
        this.year = year;
    }

    public Book(String title, String author, String description, int year) {
        this.title = title;
        this.author = author;
        this.year = year;

    }

    // Getter und Setter
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getYear() {
            return year;
    }
    public void setYear(int year) { this.year = year; }

}
