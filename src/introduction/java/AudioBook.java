package introduction.java;

// AudioBook class inherits from LibraryItem
public class AudioBook extends LibraryItem {
    private int duration; // in minutes

    public AudioBook(String title, String author, int year, int duration) {
        super(title, author, year);
        this.duration = duration;
    }

    // Overriding the displayInfo method
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Duration: " + duration + " minutes");
    }
}
