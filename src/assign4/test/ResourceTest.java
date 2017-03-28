package assign4.test;

import lms.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;

/**
 * @author Alexander Maxwell
 * Date: 03/25/17
 * Description: Used to test the .calculateFine(Day date)
 * method of the Resource class. Eight different dates are
 * used to test the lower and upper bounds of the fine
 * function.
 **/

public class ResourceTest {

    // Needed by IntelliJ IDEA
    public ResourceTest(){



    }

    // Global test resources.
    Student testStudent;
    Faculty testFaculty;
    Book testBookStudent;
    Book testBookFaculty;
    Movie testMovieStudent;
    Movie testMovieFaculty;
    Day startDate;
    Day testDay4Days;
    Day testDay2Weeks;
    Day testDay2Months;
    Day testDay4Months;

    @Before
    public void setUp(){

        // Tracking print out.
        // System.out.println(" Running ResourceTest...");

        // Create new test student.
        testStudent = new Student(1);

        // Create new test faculty.
        testFaculty = new Faculty(2);

        // Create student resources.
        testBookStudent = new Book(100000, "The Adventures of Peter Pan", "1000000000000", "Unknown");

        testMovieStudent = new Movie(200000, "UP!", "00000000002");

        // Create faculty resources.
        testBookFaculty = new Book(100001, "The Adventures of Huckleberry Finn", "1000000000000", "Unknown");

        testMovieFaculty = new Movie(200001, "UP! 2", "20000000000");

        // Initial start date.
        startDate = new Day(2017, 1, 1);

        // 4 days after start date.
        testDay4Days = new Day(2017, 1, 5);

        // 2 weeks after start date..
        testDay2Weeks = new Day(2017, 1, 15);

        // 2 months after start date.
        testDay2Months = new Day(2017, 3, 1);

        // 4 months after start date.
        testDay4Months = new Day(2017, 5, 1);

        // Set due dates for various test ranges.
        testBookStudent.setDueDate(testBookStudent.calculateNewDueDate(startDate, testStudent));

        testMovieStudent.setDueDate(testMovieStudent.calculateNewDueDate(startDate, testStudent));

        testBookFaculty.setDueDate(testBookFaculty.calculateNewDueDate(startDate, testFaculty));

        testMovieFaculty.setDueDate(testMovieFaculty.calculateNewDueDate(startDate, testFaculty));
    }

    @Test
    public void calculateFineStudentBookBefore() {
        // DEBUG: System.out.println("Now testing calculateFineStudentBookBefore()...");
        // Fine for student book before due date.
        assertEquals("Student Book: 2 Weeks before due date. Fine must be $0.00", 0.00, testBookStudent.calculateFine(testDay2Weeks),0.001);
        // DEBUG: System.out.println("Test 1 Finished!");
    }

    @Test
    public void calculateFineStudentBookAfter() {
        // DEBUG: System.out.println("Now testing calculateFineStudentBookAfter()...");
        // Fine for student book after due date.
        assertEquals("Student Book: 30 Days after due date. Fine must be $5.00", 5.00, testBookStudent.calculateFine(testDay2Months), 0.001);
        // DEBUG: System.out.println("Test 2 Finished!");
    }

    @Test
    public void calculateFineStudentMovieBefore() {
        // DEBUG: System.out.println("Now testing calculateFineStudentMovieBefore()...");
        // Fine for student movie before due date.
        assertEquals("Student Movie: 3 Days before due date fine must be $0.00", 0.00, testMovieStudent.calculateFine(testDay4Days), 0.001);
        // DEBUG: System.out.println("Test 3 Finished!");
    }

    @Test
    public void calculateFineStudentMovieAfter() {
        // Debug: System.out.println("Now testing calculateFineStudentMovieAfter()...");
        // Fine for student movie after due date.
        assertEquals("Student Movie: 1 Week after due date fine must be $1.75", 1.75, testMovieStudent.calculateFine(testDay2Weeks), 0.001);
        // Debug: System.out.println("Test 4 Finished!");
    }

    @Test
    public void calculateFineFacultyBookBefore() {
        // DEBUG: System.out.println("Now testing calculateFineFacultyBookBefore()...");
        // Fine for faculty book before due date.
        assertEquals("Faculty Book: 1 Month before due date. Fine must be $0.00", 0.00, testBookFaculty.calculateFine(testDay2Months), 0.001);
        // DEBUG: System.out.println("Test 5 Finished!");
    }

    @Test
    public void calculateFineFacultyBookAfter() {
        // DEBUG: System.out.println("Now testing calculateFineFacultyBookAfter()...");
        // Fine for faculty book after due date.
        assertEquals("Faculty Book: 1 Month after due date. Fine must be $5.00", 5.00, testBookFaculty.calculateFine(testDay4Months), 0.001);
        // DEBUG: System.out.println("Test 6 Finished!");
    }

    @Test
    public void calculateFineFacultyMovieBefore() {
        // DEBUG: System.out.println("Now testing calculateFineFacultyMovieBefore()...");
        // Fine for faculty movie before due date.
        assertEquals("Faculty Movie: 3 Days before due date fine must be $0.00", 0.00, testMovieFaculty.calculateFine(testDay4Days), 0.001);
        // DEBUG: System.out.println("Test 7 Finished!");
    }

    @Test
    public void calculateFineFacultyMovieAfter() {
        // DEBUG: System.out.println("Now testing calculateFineFacultyMovieAfter()...");
        // Fine for faculty movie after due date.
        assertEquals("Faculty Movie: 1 Week after due date fine must be $1.75", 1.75, testMovieFaculty.calculateFine(testDay2Weeks), 0.001);
        // DEBUG: System.out.println("Test 8 Finished!");
    }

    @After
    public void tearDown(){
        Student testStudent = null;
        Faculty testFaculty = null;
        Book testBookStudent = null;
        Book testBookFaculty = null;
        Movie testMovieStudent = null;
        Movie testMovieFaculty = null;
        Day startDate = null;
        Day testDay4Days = null;
        Day testDay2Weeks = null;
        Day testDay2Months = null;
        Day testDay4Months = null;

        // Tracking print out.
        // System.out.println("Test Complete.");
    }
}
