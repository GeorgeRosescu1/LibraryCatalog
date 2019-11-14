package com.company.util;

import com.company.ArtCatalog;
import com.company.Book;
import com.company.Magazine;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static int findBookInArray(List<Book> books, String book) {
        int index;
        int firstApparitionIndex;
        for (index = 0; index < books.size(); index++) {
            if (books.get(index).getNameBook().equals(book)) {
                firstApparitionIndex = index;
                return firstApparitionIndex;
            }
        }
        return -1;
    }

    public static double convertDolarsInEuros(double dolars) {
        return dolars * 0.90;
    }

    public static void printBooksNice(List<Book> bookList) {
        int index;
        for (index = 0; index < bookList.size(); index++) {
            if (!(bookList.get(index) instanceof Magazine)) { //this object is not a Magazine
                if (bookList.get(index) instanceof ArtCatalog)
                    System.out.println(index+1 + ". " + bookList.get(index).getNameBook() + " written by " + bookList.get(index).getAuthorName() + //better to save that list item in a Book object? Helps memory?
                            " at " + bookList.get(index).getPrice() + " Euros.");
                else
                    System.out.println(index+1 + ". " + bookList.get(index).getNameBook() + " written" + bookList.get(index).getAuthorName() +
                            " at " + bookList.get(index).getPrice() + " American Dolars.");
            } else {
                System.out.println(index+1 + ". " + bookList.get(index).getNameBook() + " edition number " + ((Magazine) bookList.get(index)).getMagazinEdition() +
                        " at " + bookList.get(index).getPrice() + " Euros.");
            }
        }
    }
}
