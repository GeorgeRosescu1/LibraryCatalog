package com.company;

public class Book implements Comparable {
    private int nrPages;
    private String nameBook;
    private double priceInEuros;
    private String authorName;
    private int departmentToFound;

    public int getDepartmentToFound() {
        return departmentToFound;
    }

    public void setDepartmentToFound(int departmentToFound) {
        this.departmentToFound = departmentToFound;
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

    @Override
    public int compareTo(Object o) {
        if (o instanceof Book) {
            if (((Book) o).getNameBook().compareTo(this.getNameBook()) < 0)
                return -1;
            else if (((Book) o).getNameBook().compareTo(this.getNameBook()) > 0)
                return 1;
            else return 0;
        } else
            System.err.print("Try to compare with object that is not of type Book!!");
        return 2;
    }
}
