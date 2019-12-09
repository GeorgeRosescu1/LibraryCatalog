package service;

import model.Book;
import model.BooksStock;
import model.Magazine;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    private BookService bookService;
    private BooksStock<Book> booksStock = new BooksStock();

    @BeforeEach
    public void setUp() {
        bookService = new BookService();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Clean up");
    }

    @Test
    public void populateResource() {
        booksStock = BookService.populateResource();
        Book actualBook = new Book();
        Magazine expectedBook = new Magazine();
        actualBook = booksStock.get(0);
        expectedBook.setNameBook("Gazeta Sporturilor");
        expectedBook.setAuthorName("ProSport");
        expectedBook.setNrPages(56);
        expectedBook.setPriceInEuros(5.4);
        expectedBook.setDepartmentToFound(2);
        expectedBook.setMagazineEdition(16);
        assertEquals(actualBook, expectedBook);

    }

    @Test
    void addBook() {
    }

    @Test
    void getBookByID() {
    }

    @Test
    void getBookByName() {
    }

    @Test
    void updateBook() {
    }

    @Test
    void deleteBook() {
    }
}