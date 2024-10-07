package com.library.backend;

import com.library.backend.model.Book;
import com.library.backend.repository.BookRepository;
import com.library.backend.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    public BookServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllBooks() {
        Book book = new Book("To Kill a Mockingbird", "Harper Lee",1960);
        when(bookRepository.findAll()).thenReturn(List.of(book));

        List<Book> books = bookService.getAllBooks();
        assertEquals(1, books.size());
        assertEquals("To Kill a Mockingbird", books.get(0).getTitle());
    }

   /* @Test
    public void testAddBook() {
        Book book = new Book("The Secret Garden", " Charles Robinson",1911);
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        Book savedBook = bookService.addBook(book);
        assertEquals("The Secret Garden", savedBook.getTitle());
    }*/

    @Test
    public void testGetBookById() {
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald",1922 );
        when(bookRepository.findById("1")).thenReturn(Optional.of(book));

        Optional<Book> foundBook = bookService.getBookById("1");
        assertTrue(foundBook.isPresent());
        assertEquals("The Great Gatsby", foundBook.get().getTitle());
    }
}
