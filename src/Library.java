

import java.util.*;

public class Library {
    // Add the missing implementation to this class
    private String address;
    
    /* Array implementation
    private Book books[];
    private int numBooks; */
    public ArrayList<Book> books;

    public Library(String address) {
        this.address = address;
        /* Array implementation
        this.numBooks = 0;
        this.books = new Book[100]; */
        this.books = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        /* Array implementation
        books[numBooks] = book;
        numBooks++; */
        books.add(book);
    }

    public static void printOpeningHours() {
        System.out.println("Open Daily: 9am to 5pm");
    }

    public void printAddress(){
        System.out.println(this.address);
    }

    public void borrowBook(String title) {
        for (Book book: this.books) {
            if (book.title.equals(title)) {
                if (book.isBorrowed()) {
                    System.out.println("Sorry, '" + title + "'" + "is already borrowed");
                }
                else {
                    book.borrowed();
                    System.out.println("You successfully borrowed '" + title + "'");
                }
                return;
            }
        }
        System.out.println("Sorry,'" + title + "' is not in our catalog.");
    }

    public void printAvailableBooks() {
        int availableBooks = 0;
        for (Book book: this.books) {
            if (!book.isBorrowed()) {
                System.out.println(book.title);
                availableBooks++;
            }
        }
        if (availableBooks == 0) {
            System.out.println("No books are available to borrow.");
        }
    }

    public void returnBook(String title) {
        for (Book book: this.books) {
            if (book.title.equals(title)) {
                if (book.isBorrowed()) {
                    book.returned();
                    System.out.println("You successfully returned '" + title + "'");
                }
                else {
                    System.out.println("Error: Our records show that'" + title + "'" + "has already been returned.");
                }
                return;
            }
        }
        System.out.println("Error: '" + title + "' is not in our catalog.");
    }


    public static void main(String[] args) {
        
        // Create two libraries
        Library firstLibrary = new Library("10 Main St."); 
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
} 