package introduction.java;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class DigitalLibraryTest {

    private DigitalLibrary library;

    @Before
    public void setUp() throws Exception {
        library = new DigitalLibrary();

        library.addItem(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 180));
        library.addItem(new Ebook("1984", "George Orwell", 1949, "PDF"));
        library.addItem(new AudioBook("To Kill a Mockingbird", "Harper Lee", 1960, 720));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void displayAllItems() {

    }

    @Test
    public void searchByAuthor() {
        // Capture output using a PrintStream and ByteArrayOutputStream
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        library.searchByAuthor("F. Scott Fitzgerald");

        // Verify that the correct book is found
        String expectedOutput = "Title: The Great Gatsby";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void analyzeLibrary() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        library.analyzeLibrary();

        String expectedOutput1 = "Total items: 3";
        String expectedOutput2 = "Books: 1";
        String expectedOutput3 = "E-books: 1";
        String expectedOutput4 = "Audiobooks: 1";
        String expectedOutput5 = "There's a tie for the most common item type.";
        assertTrue(outContent.toString().contains(expectedOutput1));
        assertTrue(outContent.toString().contains(expectedOutput2));
        assertTrue(outContent.toString().contains(expectedOutput3));
        assertTrue(outContent.toString().contains(expectedOutput4));
        assertTrue(outContent.toString().contains(expectedOutput5));
    }

    @Test
    public void searchByTitle() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        library.searchByTitle("1984");
        String expectedOutput = "Title: 1984";
        assertTrue("Test1 Failed:\nExpected to find: " + expectedOutput + " in output\nGot:" + outContent,
                outContent.toString().contains(expectedOutput));
        System.out.println("Test1 Passed");

        outContent.reset();
        library.searchByTitle("The Great Gatsby");
        expectedOutput = "Author: F. Scott Fitzgerald";
        assertTrue("Test2 Failed:\nExpected to find: " + expectedOutput + " in output\nGot:" + outContent,
                outContent.toString().contains(expectedOutput));
        System.out.println("Test2 Passed");

        outContent.reset();
        library.searchByTitle("To Kill a Mockingbird");
        expectedOutput = "Year: 1960";
        assertTrue("Test3 Failed:\nExpected to find: " + expectedOutput + " in output\nGot:" + outContent,
                outContent.toString().contains(expectedOutput));

    }

    @Test
    public void searchByYear() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        library.searchByYear(1925);
        String expectedOutput = "Title: The Great Gatsby";
        assertTrue("Test1 Failed:\nExpected to find: " + expectedOutput + " in output\nGot:" + outContent,
                outContent.toString().contains(expectedOutput));
        System.out.println("Test1 Passed");

        outContent.reset();
        library.searchByYear(1949);
        expectedOutput = "Title: 1984";
        assertTrue("Test2 Failed:\nExpected to find: " + expectedOutput + " in output\nGot:" + outContent,
                outContent.toString().contains(expectedOutput));
        System.out.println("Test2 Passed");

        outContent.reset();
        library.searchByYear(1960);
        expectedOutput = "Title: To Kill a Mockingbird";
        assertTrue("Test3 Failed:\nExpected to find: " + expectedOutput + " in output\nGot:" + outContent,
                outContent.toString().contains(expectedOutput));
    }

    @Test
    public void searchByStatus() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        library.searchByStatus(false);
        String expectedOutput = "Title: The Great Gatsby";
        assertTrue("Test1 Failed:\nExpected to find: " + expectedOutput + " in output\nGot:" + outContent,
                outContent.toString().contains(expectedOutput));
        System.out.println("Test1 Passed");

        expectedOutput = "Title: 1984";
        assertTrue("Test2 Failed:\nExpected to find: " + expectedOutput + " in output\nGot:" + outContent,
                outContent.toString().contains(expectedOutput));
        System.out.println("Test2 Passed");

        expectedOutput = "Title: To Kill a Mockingbird";
        assertTrue("Test3 Failed:\nExpected to find: " + expectedOutput + " in output\nGot:" + outContent,
                outContent.toString().contains(expectedOutput));
        System.out.println("Test3 Passed");

        outContent.reset();
        LibraryItem item = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954, 1170);
        item.checkOut();
        library.addItem(item);
        library.searchByStatus(true);
        expectedOutput = "Title: The Lord of the Rings";
        assertTrue("Test4 Failed:\nExpected to find: " + expectedOutput + " in output\nGot:" + outContent,
                outContent.toString().contains(expectedOutput));
        System.out.println("Test4 Passed");
    }
}