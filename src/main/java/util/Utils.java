package util;

import model.*;

import java.util.List;

public class Utils {

    /**
     * this method returns the first apparition of a book searched by name
     *
     * @param books    list of books
     * @param bookName name of the book
     * @return index of the first apparition or -1 if not appears
     */
    public static Book findBookInArray(BooksStock<Book> books, String bookName) {
        int index;
        for (index = 0; index < books.size(); index++) {
            if (books.get(index).getNameBook().equals(bookName)) {
                return books.get(index);
            }
        }
        return null;
    }

    public static double convertDollarsInEuros(double dolars) {
        return dolars * 0.90;
    }

    public static void printBooksNice(BooksStock<Book> bookList) {
        int index;
        for (index = 0; index < bookList.size(); index++) {
            if (!(bookList.get(index) instanceof Magazine)) { //this object is not a Magazine
                if (bookList.get(index) instanceof ArtCatalog)
                    System.out.println(index + ". " + bookList.get(index).getNameBook() + " written by " + bookList.get(index).getAuthorName() + //better to save that list item in a Book object? Helps memory?
                            " at " + bookList.get(index).getPrice() + " Euros.");
                else {
                    Novel novel = new Novel();
                    novel = (Novel) bookList.get(index);
                    System.out.println(index + ". " + bookList.get(index).getNameBook() + " written by " + bookList.get(index).getAuthorName() +
                            " type of novel " + novel.getType() + " at " + bookList.get(index).getPrice() + " American Dolars.");

                }
            } else {
                System.out.println(index + ". " + bookList.get(index).getNameBook() + " edition number " + ((Magazine) bookList.get(index)).getMagazineEdition() +
                        " at " + bookList.get(index).getPrice() + " Euros.");
            }
        }
    }
}
