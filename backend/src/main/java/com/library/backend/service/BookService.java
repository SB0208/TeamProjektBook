package com.library.backend.service;

import com.library.backend.model.Book;

import com.library.backend.repository.BookRepo;
import com.library.backend.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service

public class BookService {




    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(String id) {
        return bookRepository.findById(id);
    }


    public Book updateBook(String id, Book book) {
        if (bookRepository.existsById(id)) {
            book.setId(id);
            return bookRepository.save(book);
        }
        return null;
    }

    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

}
