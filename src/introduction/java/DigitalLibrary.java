package introduction.java;

import java.util.ArrayList;
import java.util.List;

// Main class to demonstrate the usage
public class DigitalLibrary {
    // here we declare a private List that can only hold LibraryItem objects (LibraryItem, Book, Ebook, AudioBook)
    private List<LibraryItem> items;

    /**
     * Constructor to create a digital library with an empty list of items
     */
    public DigitalLibrary() {
        items = new ArrayList<>();
    }

    // Method to add an item to the library
    public void addItem(LibraryItem item) {
        items.add(item); // ArrayList has an add method to add items to the list
    }

    /**
     * This method demonstrates a for-each loop<hr>
     * A for-each loop is a special type of loop that iterates over a every item in a List, array, or similar collection.<br>
     * You can read the for-each loop as "for each item of type LibraryItem in items do:"<br>
     */
    public void displayAllItems() {
        for (LibraryItem item : items) {
            item.displayInfo();
            System.out.println("--------------------");
        }
    }

    /**
     * This method searches for all items from a specific author<hr>
     * It uses a for-each loop to iterate over all items in the library.<br>
     * and checks for each item if the author matches the search query.<br>
     * If an item is found, it displays the information about the item, and sets the boolean found to true.<br>
     * If no items are found, it prints a message.<br>
     *
     * @param author The author to search for
     */
    public void searchByAuthor(String author) {
        boolean found = false;
        for (LibraryItem item : items) {
            if (item.getAuthor().equalsIgnoreCase(author)) {
                item.displayInfo();
                System.out.println("--------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No items found by author: " + author);
        }
    }

    // Method to demonstrate control structures
    public void analyzeLibrary() {
        int totalItems = items.size();
        int booksCount = 0;
        int ebooksCount = 0;
        int audioBooksCount = 0;

        for (LibraryItem item : items) {
            if (item instanceof Book) {
                booksCount++;
            } else if (item instanceof Ebook) {
                ebooksCount++;
            } else if (item instanceof AudioBook) {
                audioBooksCount++;
            }
        }

        System.out.println("Library Analysis:");
        System.out.println("Total items: " + totalItems);
        System.out.println("Books: " + booksCount);
        System.out.println("E-books: " + ebooksCount);
        System.out.println("Audiobooks: " + audioBooksCount);

        if (booksCount > ebooksCount && booksCount > audioBooksCount) {
            System.out.println("Physical books are the most common in this library.");
        } else if (ebooksCount > booksCount && ebooksCount > audioBooksCount) {
            System.out.println("E-books are the most common in this library.");
        } else if (audioBooksCount > booksCount && audioBooksCount > ebooksCount) {
            System.out.println("Audiobooks are the most common in this library.");
        } else {
            System.out.println("There's a tie for the most common item type.");
        }
    }

    public void searchByTitle(String title) {
        // This method is left as an exercise
    }

    public void searchByYear(int year) {
        // This method is left as an exercise
    }

    public void searchByStatus(boolean isCheckedOut) {
        // This method is left as an exercise
    }

    public static void main(String[] args) {
        DigitalLibrary library = new DigitalLibrary();

        // Adding items to the library
        library.addItem(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 180));
        library.addItem(new Ebook("1984", "George Orwell", 1949, "PDF"));
        library.addItem(new AudioBook("To Kill a Mockingbird", "Harper Lee", 1960, 720));
        library.addItem(new Book("Pride and Prejudice", "Jane Austen", 1813, 432));
        library.addItem(new Book("Dune", "Frank Herbert", 1965, 694));
        library.addItem(new Ebook("Sophies Welt", "Jostein Gaarder", 1991, "EPUB"));

        // Displaying all items
        System.out.println("All items in the library:");
        library.displayAllItems();

        // Searching by author
        System.out.println("Searching for books by Jane Austen:");
        library.searchByAuthor("Jane Austen");

        // Analyzing the library
        library.analyzeLibrary();

        // Demonstrating method calls and object interaction
        LibraryItem item = new Book("Moby Dick", "Herman Melville", 1851, 585);
        item.checkOut();
        item.checkOut(); // Trying to check out again
        item.returnItem();
        item.returnItem(); // Trying to return again
    }
}
