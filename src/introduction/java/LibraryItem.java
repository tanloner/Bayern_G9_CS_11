package introduction.java;

// This LibraryItem is a base class representing a general library item
// This class has fields for title, author, year, and checked out status
// It also has methods to check out, return, and display information about the item
// It can later be extended by specific item types like Book, Ebook, and AudioBook
// and is just a blueprint for those classes
public class LibraryItem {
    // The keyword private, means that these fields are only accessible from inside this class,
    // or by classes that inherit from it (Like Book, Ebook, and AudioBook)
    // so this is a private field, that can only hold text values (String) and has the name title.
    private String title;
    private String author;

    // this is an integer field, that can only hold whole numbers (int) and has the name year.
    private int year;

    // this is a boolean field, that can only hold true or false values and has the name isCheckedOut.
    private boolean isCheckedOut;

    /**
     * Constructor to create a library item with title, author, and year
     * A Constructor is a special method that is called when an object is created
     * It initializes the object with the provided values (title, author, year)
     *
     * @param title The title of the item
     * @param author The author of the item
     * @param year The year the item was published
     */
    public LibraryItem(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isCheckedOut = false;
    }

    // Getter methods to access the private fields from outside the class.
    // the public keyword means that these methods can be accessed from outside the class.
    // I hope you remember the basic syntax of a method.
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    /**
     * Method to check out the item<hr>
     * remember that isCheckedOut is a boolean field?<br>
     * This method first checks if the item is already checked out, by using an if statement.<br>
     * the exclamation mark (!) is a logical operator that negates the value of isCheckedOut.<br>
     * so !True is False and !False is True.<br>
     * you can read the if statement as "if not isCheckedOut do:"<br>
     * if the item is not checked out, we set isCheckedOut to true and print a message.<br>
     * else (if the item is already checked out), we print a different message.<br>
     */
    public void checkOut() {
        if (!isCheckedOut) {
            isCheckedOut = true;
            System.out.println(title + " has been checked out.");
        } else {
            System.out.println(title + " is already checked out.");
        }
    }

    /**
     * Method to return the item<br>
     * This method is similar to the checkOut method, but it checks if the item is already in the library.
     */
    public void returnItem() {
        if (isCheckedOut) {
            isCheckedOut = false;
            System.out.println(title + " has been returned.");
        } else {
            System.out.println(title + " is already in the library.");
        }
    }

    /**
     * Method to display information about the item
     */
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year: " + year);
        System.out.println("Status: " + (isCheckedOut ? "Checked Out" : "Available"));
    }
}
