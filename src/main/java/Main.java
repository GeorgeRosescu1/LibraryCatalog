import exception.NotInStockException;
import exception.OutOfBudgetException;
import exception.OutOfStockException;
import model.*;
import service.BookService;
import util.Utils;

import java.util.*;

//@todo add posibility to delete book --list all in order to choose the one to be removed
//@todo when 0 of smth print "out of stock <that smth>"
//@todo enter name, return department and shelf, like search book in library -- ask Cristi

public class Main {

    public static final double LIBRARY_FEE = 3.97;

    public static void main(String[] args) throws Exception {

        TreeMap<Integer, List<Book>> bookMap = new TreeMap<>();
        BooksStock<Book> bookList = new BooksStock<>();


        int counterApparitionBook;
        int index, index1;
        boolean fileFound = true;
        Integer key;
        String nameToDelete;
        String text = "Your data is up, choose one of the following operation:\n" +
                "1. List all books.\n" +
                "2. Delete one book.\n" +
                "3. Search book by department.\n" +
                "4. See the cheapest book.\n" +
                "5. See the most expensive book.\n" +
                "6. Buy book.\n" +
                "7. See budget.\n" +
                "8. Close the program.\n" +
                "Enter the digit of the operation you want";
        int chooseOperation;
        boolean isRunning = true;
        double minPrice;
        double maxPrice;
        Double myBudget;
        String bookToBuy;
        String nameOfChepestBook, nameOfExpensiveBook;
        Scanner input = new Scanner(System.in); // System Scanner
        System.out.print("Enter your budget: ");
        myBudget = input.nextDouble();
        System.out.println();
        Scanner consoleScaner = new Scanner(System.in);

        bookList = BookService.populateResource();

        if (fileFound != false) {
            index = 0;
            while (index < bookList.size()) {
                key = bookList.get(index).getDepartmentToFound();
                if (!bookMap.containsKey(key)) {
                    List<Book> listInMap = new ArrayList<>();
                    listInMap.add(bookList.get(index));
                    if (index < bookList.size() - 1) {
                        for (index1 = index + 1; index1 < bookList.size(); index1++) {
                            if (bookList.get(index1).getDepartmentToFound() == key)
                                listInMap.add(bookList.get(index1));
                        }
                    }
                    Collections.sort(listInMap);
                    bookMap.put(key, listInMap);
                }
                index++;
            }


            //Here we handle the data, no more reading of data until the next execution
            while (isRunning) {
                System.out.println(text);
                chooseOperation = input.nextInt();
                switch (chooseOperation) {

                    case 1:
                        ///List all the books;
                        Utils.printBooksNice(bookList);
                        System.out.println('\n');
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
                        }
                        break;

                    case 3:
                        Set<Integer> departments = new HashSet<>();
                        int depSelect;

                        departments = bookMap.keySet();
                        System.out.println("Please select one of the following departments: " + departments);
                        depSelect = input.nextInt();
                        if (!departments.contains(depSelect)) {
                            System.out.println("This department doesn't exist");
                        } else {
                            System.out.println("Books to be foud in Department No." + depSelect + " are:");
                            for (index = 0; index < bookMap.get(depSelect).size(); index++) {
                                System.out.println(bookMap.get(depSelect).get(index).getNameBook() + " de " + bookMap.get(depSelect).get(index).getAuthorName());
                            }
                            System.out.println();
                        }
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
                        System.out.println("The cheapest book is " + nameOfChepestBook + " at " + minPrice + " American Dolars.\n");
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
                        System.out.println("The most expensive book is " + nameOfExpensiveBook + " at " + maxPrice + " American Dolars.\n");
                        break;

                    case 6:
                        Utils.printBooksNice(bookList);
                        int position;
                        Book book = new Book();
                        position = consoleScaner.nextInt();
                        book = bookList.get(position);
                        try {
                            myBudget=bookList.buyBook(book, myBudget);
                        } catch (OutOfBudgetException e) {
                            e.printStackTrace();
                        } catch (NotInStockException e) {
                            e.printStackTrace();
                        } catch (OutOfStockException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 7:
                        System.out.println("Your budget = " + myBudget + " Euros.");
                        break;

                    case 8:
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
}
