package com.library.backend.controller;


import com.library.backend.model.Book;
import com.library.backend.service.BookService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;


@RequestMapping("/api/books")
@RequiredArgsConstructor

@RestController
public class BookController {

    @Autowired
    private BookService bookService;




    @GetMapping
    public List<Book> getAllBooks()
    {
        List<Book> allBooks = bookService.getAllBooks();
        return allBooks;
    }


    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable String id)
    {
        Optional<Book> bookById = bookService.getBookById(id);
        return bookById;
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable String id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
    }

    @PostMapping()
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }






}
