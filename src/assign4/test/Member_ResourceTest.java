package assign4.test;

import lms.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;

/**
 * @author Alexander Maxwell
 * Date: 03/25/17
 * Description: Used to test the abstract class Resource's method
 * .calculateNewDueDate() which has child-class definitions for each
 * Resource's child-class Movie.class and Book.class. Each due date has
 * specific due dates based on the child-classess of Member.class
 * (Faculty.class and Student.class).
 **/

public class Member_ResourceTest {

    // Needed by IntelliJ IDEA
    public Member_ResourceTest(){
    }

    // Global test resources.
    Student testStudent;
    Faculty testFaculty;
    Book testBookStudent;
    Book testBookFaculty;
    Movie testMovieStudent;
    Movie testMovieFaculty;
    Day startDate;
    Day expectedDate;

    @Before public void setUp(){

        // Tracking print out.
        // System.out.println(" Running Member_ResourceTest...");

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
    }

    @Test public void dueDateStudentBook(){
        // DEBUG: System.out.println("Now testing dueDateStudentBook()...");
        // Define expected due date.
        expectedDate = new Day(2017, 1, 29);
        assertEquals("Student Book is due 28 days after start date. Due date must be 1/29/2017", expectedDate,testBookStudent.calculateNewDueDate(startDate,testStudent));
        // DEBUG: System.out.println("Test 1 Finished!");
    }

    @Test public void dueDateStudentMovie(){
        // DEBUG: System.out.println("Now testing dueDateStudentMovie()...");
        // Define expected due date.
        expectedDate = new Day(2017, 1, 8);
        assertEquals("Student Movie is due 7 days after start date. Due date must be 1/8/2017", expectedDate,testMovieStudent.calculateNewDueDate(startDate,testStudent));
        // DEBUG: System.out.println("Test 2 Finished!");
    }

    @Test public void dueDateFacultyBook(){
        // DEBUG: System.out.println("Now testing dueDateFacultyBook()...");
        // Define expected due date.
        expectedDate = new Day(2017, 4, 1);
        assertEquals("Faculty Book is due 90 days after start date. Due date must be 4/1/2017", expectedDate,testBookFaculty.calculateNewDueDate(startDate,testFaculty));
        // DEBUG: System.out.println("Test 3 Finished!");
    }

    @Test public void dueDateFacultyMovie(){
        // DEBUG: System.out.println("Now testing dueDateFacultyMovie()...");
        // Define expected due date.
        expectedDate = new Day(2017, 1, 8);
        assertEquals("Faculty Movie is due 7 days after start date. Due date must be 1/8/2017", expectedDate,testMovieFaculty.calculateNewDueDate(startDate,testFaculty));
        // DEBUG: System.out.println("Test 1 Finished!");
    }

    @After public void tearDown(){
        Student testStudent = null;
        Faculty testFaculty = null;
        Book testBookStudent = null;
        Book testBookFaculty = null;
        Movie testMovieStudent = null;
        Movie testMovieFaculty = null;
        Day startDate = null;
        Day expectedDate = null;

        // Tracking print out.
        //System.out.println("Test Complete.");
    }
}