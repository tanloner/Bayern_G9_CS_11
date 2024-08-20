package introduction.java;

/**
 * Inheritance: Book class inherits from LibraryItem
 * The Book class extends the LibraryItem class,
 * which means it inherits all the fields and methods from LibraryItem,
 * but it can also have its own fields and methods.
 * for inheritance, we use the extends keyword, followed by the name of the class we want to inherit from.
 */
public class Book extends LibraryItem {
    private int pages; // Additional field for the number of pages. We still have the title, author, year, and isCheckedOut fields from LibraryItem

    /**
     * Constructor to create a book with title, author, year, pages<br>
     * This constructor calls the constructor of the superclass (LibraryItem) using the super keyword.
     *
     * @param title  The title of the book
     * @param author The author of the book
     * @param year   The year the book was published
     * @param pages  The number of pages in the book
     */
    public Book(String title, String author, int year, int pages) {
        super(title, author, year);
        this.pages = pages;
    }

    /**
     * This method shows two special things, we only have in classes that inherit:<br>
     * 1. We are overriding a method from the superclass (LibraryItem) using the @Override annotation.
     * What means overriding? It means that we are replacing the method from the superclass with our own.<br>
     * 2. We are calling a method from the superclass using the super keyword.
     */
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Pages: " + pages);
    }
}
