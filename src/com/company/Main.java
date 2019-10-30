package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

//@todo add posibility to delete book --list all in order to choose the one to be removed
//@todo when 0 of smth print "out of stock <that smth>"
//@todo enter name, return department and shelf, like search book in library

public class Main {

    public static void main(String[] args) throws Exception {

        List<Book> bookList = new ArrayList<>();
        File file = new File("date.txt");
        String inputBufferString = new String(); /// read input here
        int myPos, counterApparitionBook;
        int index;
        String bookToFind;
        String nameToDelete;
        String text = "Your data is up, choose one of the following operation:\n" +
                "1. List all books.\n" +
                "2. Delete one book.\n" +
                "3. Search one book.\n" +
                "4. See the cheapest book.\n" +
                "5. See the most expensive book.\n" +
                "6. Close the program.\n" +
                "Enter the digit of the operation you want";
        int chooseOperation = 1;
        int previousOperation = -1;
        boolean isRunning = true;
        double minPrice;
        double maxPrice;
        boolean invalidOperation = false;
        String nameOfChepestBook, nameOfExpensiveBook;
        Scanner input = new Scanner(System.in); // System Scanner

        ///First we read all the data
        try {
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNextLine()) {
                String[] inputBufferArray;///read Magazine data
                inputBufferString = inputStream.nextLine();
                inputBufferArray = inputBufferString.split(", ");
                myPos = 0;
                switch (inputBufferArray[0]) {
                    case "Magazine":
                        Magazine myMagazine = new Magazine();
                        myPos++;
                        myMagazine.setNameBook(inputBufferArray[myPos]);///magazine title
                        myPos++;
                        myMagazine.setAuthorName(inputBufferArray[myPos]);///magazine author name
                        myPos++;
                        myMagazine.setNrPages(Integer.parseInt(inputBufferArray[myPos]));///magazine number of pages
                        myPos++;
                        myMagazine.setPriceInEuros(Double.parseDouble(inputBufferArray[myPos]));///magazine price in euros
                        myPos++;
                        myMagazine.setDepartmentToFound(Integer.parseInt(inputBufferArray[myPos]));///magazine department number
                        myPos++;
                        myMagazine.setShelf(Integer.parseInt(inputBufferArray[myPos]));///magazine shelf location number
                        myPos++;
                        myMagazine.setMagazinEdition(Integer.parseInt(inputBufferArray[myPos]));///magazine edition
                        bookList.add(myMagazine);
                        break;
                    case "Novel":
                        Novel myNovel = new Novel();
                        myPos++;
                        myNovel.setNameBook(inputBufferArray[myPos]);
                        myPos++;
                        myNovel.setAuthorName(inputBufferArray[myPos]);
                        myPos++;
                        myNovel.setNrPages(Integer.parseInt(inputBufferArray[myPos]));
                        myPos++;
                        myNovel.setYearOfApparition(Integer.parseInt(inputBufferArray[myPos]));
                        myPos++;
                        myNovel.setDepartmentToFound(Integer.parseInt(inputBufferArray[myPos]));
                        myPos++;
                        myNovel.setShelf(Integer.parseInt(inputBufferArray[myPos]));
                        myPos++;
                        myNovel.setPriceInEuros(Double.parseDouble(inputBufferArray[myPos]));
                        myPos++;
                        myNovel.setType(inputBufferArray[myPos]);
                        bookList.add(myNovel);
                        break;
                    case "ArtCatalog":
                        ArtCatalog myArtCatalog = new ArtCatalog();
                        myPos++;
                        myArtCatalog.setNameBook(inputBufferArray[myPos]);
                        myPos++;
                        myArtCatalog.setAuthorName(inputBufferArray[myPos]);
                        myPos++;
                        myArtCatalog.setNrPages(Integer.parseInt(inputBufferArray[myPos]));
                        myPos++;
                        myArtCatalog.setDepartmentToFound(Integer.parseInt(inputBufferArray[myPos]));
                        myPos++;
                        myArtCatalog.setShelf(Integer.parseInt(inputBufferArray[myPos]));
                        myPos++;
                        myArtCatalog.setPriceInEuros(Double.parseDouble(inputBufferArray[myPos]));
                        myPos++;
                        myArtCatalog.setPaperQuality(Double.parseDouble(inputBufferArray[myPos]));
                        bookList.add(myArtCatalog);
                        break;
                    default:
                        System.out.println("Invalid type!");
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("Invalid input file!");
        }

        ///Here we handle the data, no more reading of data till the next execution
        while (isRunning) {
            invalidOperation = false;
            System.out.println(text);

//            try {
//                chooseOperation = input.nextInt();
//            } catch (Exception e) {
//                System.out.println("Invalid operation selected. Please enter a valid digit");
//                invalidOperation = true;
//            }
//            if (invalidOperation)
//                chooseOperation = 1;//by default
            chooseOperation = input.nextInt();
            switch (chooseOperation) {

                case 1:
                    ///List all the books;
                    for (index = 0; index < bookList.size(); index++) {
                        if (!(bookList.get(index) instanceof Magazine)) { //this object is not a Magazine
                            if (bookList.get(index) instanceof ArtCatalog)
                                System.out.println(bookList.get(index).getNameBook() + " written by " + bookList.get(index).getAuthorName() + //better to save that list item in a Book object? Helps memory?
                                        " at " + bookList.get(index).getPrice() + " Euros.");
                            else
                                System.out.println(bookList.get(index).getNameBook() + " written " + bookList.get(index).getAuthorName() +
                                        " at " + bookList.get(index).getPrice() + " Yuan renminbi.");
                        } else {
                            System.out.println(bookList.get(index).getNameBook() + " edition number " + ((Magazine) bookList.get(index)).getMagazinEdition() +
                                    " at " + bookList.get(index).getPrice() + " Euros.");
                        }
                    }
                    System.out.println('\n');
                    previousOperation = 1;
                    break;

                case 2:
                    ///Delete all book due to name.. future implementation, due to name and smth else if 2 equal
                    if (bookList.isEmpty())
                        System.out.println("Book List is empty we can't delete any book.");
                    else {
                        counterApparitionBook = 0;
                        System.out.println("Enter the name title you want to delete: ");
                        input.nextLine();//free the buffer
                        nameToDelete = input.nextLine();
                        index = 0;
                        while (index < bookList.size() && !bookList.isEmpty()) {
                            if (bookList.get(index).getNameBook().equals(nameToDelete)) {
                                counterApparitionBook++;
                                bookList.remove(bookList.get(index));
                            } else
                                index++;
                        }
                        if (counterApparitionBook == 0)
                            System.out.println("This book is not in our list or you didn't wrote it properly, try again!\n");
                        else
                            System.out.println("Book " + nameToDelete + " has been deleted from our list.\n");
                        previousOperation = 2;
                    }
                    break;

                case 3:
                    ///search book due to name//@todo implement this
                    System.out.println("Enter the name of the book you want to find:");
                    bookToFind = input.nextLine();
                    System.out.println(bookToFind);
                    // yet don't kno how to read this if string before, smth like wait() or smth
                    previousOperation = 3;
                    break;

                case 4:
                    ///show cheapest novel
                    minPrice = Integer.MAX_VALUE;
                    nameOfChepestBook = "";
                    for (index = 0; index < bookList.size(); index++) {
                        if (bookList.get(index) instanceof Novel && bookList.get(index).getPrice() < minPrice) { // can i acces the Book's price method?
                            minPrice = bookList.get(index).getPrice();
                            nameOfChepestBook = bookList.get(index).getNameBook();
                        }
                    }
                    System.out.println("The cheapest book is " + nameOfChepestBook + " at " + minPrice + " Yuan renminbi.\n");
                    previousOperation = 4;
                    break;

                case 5:
                    ///show most expensive novel
                    maxPrice = Integer.MIN_VALUE;
                    nameOfExpensiveBook = "";
                    for (index = 0; index < bookList.size(); index++) {
                        if (bookList.get(index) instanceof Novel && bookList.get(index).getPrice() > maxPrice) {
                            maxPrice = bookList.get(index).getPrice();
                            nameOfExpensiveBook = bookList.get(index).getNameBook();
                        }
                    }
                    System.out.println("The most expensive book is " + nameOfExpensiveBook + " at " + maxPrice + " Yuan renminbi.\n");
                    previousOperation = 5;
                    break;

                case 6:
                    isRunning = false;
                    System.out.println("Run the program again to start over!");
                    break;

                default:
                    System.out.println("Enter a valid opertion index!");
                    break;
            }

        }
    }
}
