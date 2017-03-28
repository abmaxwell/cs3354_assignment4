package assign4.test;

import lms.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;

/**
 * @author Alexander Maxwell
 * Date: 03/25/17
 * Description: Used to test the Collection.class specifically
 * the addResource(int) and findResource(int) methods for TRUE
 * and FAIL cases.
 **/

public class CollectionTest {

    // Needed by IntelliJ IDEA
    public CollectionTest(){}

    // Global class resources.
    Collection testCollection;
    Movie testMovie1;
    Movie testMovie2;
    Movie testMovie3;
    Book testBook1;
    Book testBook2;
    Book testBook3;

    @Before
    public void setup(){
        // Tracking print out.
        //System.out.println(" Running CollectionTest...");

        // Create empty collection
        testCollection = new Collection();

        // Create resources to stock the collection with for testing.
        testMovie1 = new Movie(200000, "UP!", "20000000000");
        testMovie2 = new Movie(200001, "UP! 2", "20000000001");
        testMovie3 = new Movie(200002, "The Accountant", "20000000002");
        testBook1 = new Book(100000, "Huckleberry Finn", "10000000000","Mark Twain");
        testBook2 = new Book(100001, "Just David", "10000000001","Unknown");
        testBook3 = new Book(100002, "Hardy Boys", "10000000002","Franklin W. Dixon");

        // Add resources to the collection.
        testCollection.addResource(testBook1);
        testCollection.addResource(testBook2);
        testCollection.addResource(testBook3);
        testCollection.addResource(testMovie1);
        testCollection.addResource(testMovie2);
        testCollection.addResource(testMovie3);
    }

    @Test
    public void addDuplicateResourceMovie() {

        // DEBUG: System.out.println("Now testing addDuplicateResourceMovie()...");

        // Create resources with duplicate resource id.
        Movie duplicateMovie = new Movie(200000, "Test Duplicate Movie", "20000000000");

        // (Expected FAIL) Test adding movie with duplicate ID.
        assertFalse("Add movie with duplicate ID. Add fails. Must be false.", testCollection.addResource(duplicateMovie));

        // DEBUG: System.out.print("Test 1 Finished!");
    }

    @Test
    public void addDuplicateResourceBook() {

        // DEBUG: System.out.println("Now testing addDuplicateResourceBook()...");

        // Create resources with duplicate resource id.
        Book duplicateBook = new Book(100000, "Test Duplicate Book", "10000000000", "Unknown");

        // (Expected FAIL) Test adding book with duplicate ID.
        assertFalse("Add duplicate book. Must be false.",testCollection.addResource(duplicateBook));

        // DEBUG: System.out.print("Test 2 Finished!");
    }

    @Test
    public void addNonDuplicateResourceMovie() {

        // DEBUG: System.out.println("Now testing addNonDuplicateResourceMovie()...");

        // Create resource that are unique.
        Movie newMovie = new Movie(200003, "Test Unique New Movie", "20000000003");

        // (Expected TRUE) Test adding movie that is NOT duplicate but unique.
        assertTrue("Add new movie. Must be false.", testCollection.addResource(newMovie));

        // DEBUG: System.out.print("Test 3 Finished!");
    }

    @Test
    public void addNonDuplicateResourceBook() {

        // DEBUG: System.out.println("Now testing addNonDuplicateResourceBook()...");

        // Create resource that are unique.
        Book newBook = new Book(100003, "Test Unique New Book", "10000000003", "Unknown");

        // (Expected TRUE) Test adding book that is NOT duplicate but unique.
        assertTrue("Add new book. Must be false.", testCollection.addResource(newBook));

        // DEBUG System.out.println("Test 4 Finished!");
    }

    @After
    public void tearDown(){
        Collection testCollection = null;
        Movie testMovie1 = null;
        Movie testMovie2 = null;
        Movie testMovie3 = null;
        Book testBook1 = null;
        Book testBook2 = null;
        Book testBook3 = null;

        // Tracking print out.
        //System.out.println("Test Complete.");
    }
}