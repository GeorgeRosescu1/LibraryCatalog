package model;

import exception.NotInStockException;
import exception.OutOfBudgetException;
import exception.OutOfStockException;

import java.util.ArrayList;

public class BooksStock<E> {

    public ArrayList<Book> bookStock = new ArrayList<>();

    public void add(Book book) {
        bookStock.add(book);
    }

    public int size() {
        return bookStock.size();
    }

    public Book get(int index) throws OutOfStockException, NotInStockException {
        if (index >= bookStock.size()) {
            index = 0;
            throw new NotInStockException();
        }
        if (bookStock.size() <= 0)
            throw new OutOfStockException();
        return bookStock.get(index);
    }

    public int firstApparitionOfBook(Book book) {
        int index;
        for (index = 0; index < bookStock.size(); index++)
            if (bookStock.get(index).equals(book))
                return index;
        return -1;
    }

    public void deleteBookByIndex(int index) throws OutOfStockException {
        if (bookStock.size() <= 0)
            throw new OutOfStockException();
        else
            bookStock.remove(index);
    }

    public void deleteBookByName(Book book) throws OutOfStockException {
        int index = firstApparitionOfBook(book);
        if (bookStock.size() <= 0)
            throw new OutOfStockException();
        else
            bookStock.remove(index);
    }

    public boolean isEmpty() {
        return bookStock.isEmpty();
    }

    public int indexOf(Book book) {
        return bookStock.indexOf(book);
    }

    public void set(int index, Book book) {
        bookStock.set(index, book);
    }

    public void remove(Book book) throws OutOfStockException {
        if (bookStock.size() <= 0)
            throw new OutOfStockException();
        int index;
        for (index = 0; index < bookStock.size(); index++)
            if (bookStock.get(index).equals(book))
                bookStock.remove(index);
    }

    public double buyBook(Book book, double budget) throws OutOfBudgetException, NotInStockException {
        boolean isBookInStock = false;
        int index;
        if (budget <= 0)
            throw new OutOfBudgetException();
        for (index = 0; index < bookStock.size(); index++)
            if (bookStock.get(index).equals(book)) {
                isBookInStock = true;
                Book bookToBuy = bookStock.get(index);
                if (budget - bookToBuy.getPrice() < 0)
                    throw new OutOfBudgetException();
                else {
                    budget -= bookToBuy.getPrice();
                    remove(bookToBuy);
                }
            }
        if (!isBookInStock)
            throw new NotInStockException();
        else
            return budget;

    }
}
