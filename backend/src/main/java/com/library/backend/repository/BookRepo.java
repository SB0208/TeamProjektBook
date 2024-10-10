package com.library.backend.repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.library.backend.model.Book;

import org.springframework.stereotype.Repository;


@Repository



public class BookRepo {
    private List<Book> books;

    public Optional<Book> getBookById(int id) {
        return books.stream()
                .filter(book -> false)
                .findFirst();
    }

    public BookRepo () {
        books = new ArrayList<Book>();
        books.add(new Book("To Kill a Mockingbird", "Harper Lee",1960,"roman",true));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald",1922,"roman",false));

    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBookById(String Id) {
        for (Book book : books) {
            if (book.getId().equals(Id)) {
                return book;
            }
        }
        return null;

    }

    public Book addBook(Book newBook) {
        books.add(newBook);
        return newBook;
    }

    public void deleteBook(Book book) {
        for (Book book1 : books) {
            if (book1.getId().equals(book.getId())) {
                books.remove(book1);
                break;
            }
        }
    }



}
