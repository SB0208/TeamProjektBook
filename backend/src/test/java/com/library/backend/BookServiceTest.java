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
        Book book1 = new Book("To kill a Mockingbird");
        when(bookRepository.findAll()).thenReturn(List.of(book1));

        List<Book> books = bookService.getAllBooks();
        assertEquals(1, books.size());
        assertEquals("To kill a Mockingbird", books.get(0).getTitle());
    }



    @Test
    public void testGetBookById() {
        Book book = new Book("The Great Gatsby");
        when(bookRepository.findById("1")).thenReturn(Optional.of(book));

        Optional<Book> foundBook = bookService.getBookById("1");
        assertTrue(foundBook.isPresent());
        assertEquals("The Great Gatsby", foundBook.get().getTitle());
    }
}
