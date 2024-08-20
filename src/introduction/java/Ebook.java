package introduction.java;

// Ebook class inherits from LibraryItem
public class Ebook extends LibraryItem {
    private String format;

    public Ebook(String title, String author, int year, String format) {
        super(title, author, year);
        this.format = format;
    }

    // Overriding the displayInfo method
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Format: " + format);
    }
}
