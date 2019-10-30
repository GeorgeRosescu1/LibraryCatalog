package com.company;

public class Book {
    private int nrPages;
    private String nameBook;
    private double priceInEuros;
    private String authorName;
    private int departmentToFound;
    private int shelf;

    public int getDepartmentToFound() {
        return departmentToFound;
    }

    public void setDepartmentToFound(int departmentToFound) {
        this.departmentToFound = departmentToFound;
    }

    public int getShelf() {
        return shelf;
    }

    public void setShelf(int shelf) {
        this.shelf = shelf;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setPriceInEuros(double priceInEuros) {
        this.priceInEuros = priceInEuros;
    }

    //this method returns the price in euros
    public double getPrice() {
        return this.priceInEuros;
    }


    public int getNrPages() {
        return nrPages;
    }

    public void setNrPages(int nrPages) {
        this.nrPages = nrPages;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String listBookName() {
        return this.nameBook;
    }

    public boolean compareBooks(Book secondBook) {
        if (this.nameBook.equals(secondBook.nameBook) && this.authorName.equals(secondBook.authorName)) {
            return true;
        }
        return false;

    }
}
