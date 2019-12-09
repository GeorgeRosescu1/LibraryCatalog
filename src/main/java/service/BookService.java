package service;

import enums.NovelType;
import exception.OutOfStockException;
import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BookService {

    private BooksStock<Book> bookList = new BooksStock();
    // private static Logger logger = LogManager.getLogger(BookService.class);

    //CRUD

    //C Create


    public static BooksStock populateResource() throws OutOfStockException {
        File file = new File("src/main/resources/date.txt");
        BooksStock bookList = new BooksStock();
        int myPos;
        boolean isNovelType = false;
        try (Scanner scanner = new Scanner(file)) {
            String[] inputBufferArray;
            String inputBufferString;
            if (!scanner.hasNext())
                throw new OutOfStockException();
            while (scanner.hasNext()) {
                inputBufferString = scanner.nextLine();
                if (inputBufferString.startsWith("Magazine") || inputBufferString.startsWith("ArtCatalog")
                        || inputBufferString.startsWith("Novel")) {
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
                            myMagazine.setMagazineEdition(Integer.parseInt(inputBufferArray[myPos]));///magazine edition
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
                            myNovel.setPriceInEuros(Double.parseDouble(inputBufferArray[myPos]));
                            myPos++;
                            for (NovelType novelType : NovelType.values()) {
                                String type = String.valueOf(novelType);
                                if (inputBufferArray[myPos].equals(type))
                                    isNovelType = true;
                            }
                            if (isNovelType)
                                myNovel.setType(inputBufferArray[myPos]);
                            else
                                myNovel.setType("'Unknown type of novel'");
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
            }

        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong with the file reading process.");
            e.printStackTrace();
        }
        return bookList;
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    //R Read

    public Book getBookByID(int index) {
        return bookList.get(index);
    }

    public Book getBookByName(String bookName) {
        int index;
        for (index = 0; index <= bookList.size(); index++) {
            if (bookList.get(index).getNameBook().equals(bookName))
                return bookList.get(index);
        }
        return null;
    }
    //U Update

    public void updateBook(Book oldBook, Book updatedBook) {
        Book foundBook = getBookByName(oldBook.getNameBook()); //pointer
        int index = bookList.indexOf(foundBook);
        bookList.set(index, updatedBook);
    }

    public void deleteBook(Book book) {
        bookList.remove(getBookByName(book.getNameBook()));
    }
}
