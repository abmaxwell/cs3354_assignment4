package assign4;
import assign4.test.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * @author Alexander Maxwell
 * Date: 03/25/17
 * Description: Driver function Main() to run the various
 * test class files.
 **/
public class Main {
    public static void main(String[] args) {

        // Define a results object to test for failures.
        Result result;

        // Begin testing the calculateFine() method of the  Resource.class.
        result = JUnitCore.runClasses(ResourceTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        // Begin testing the Collection.class.
        result = JUnitCore.runClasses(CollectionTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        // Begin testing the collaboration of the Resource.class
        // and Member.class via their sub-classes.
        result = JUnitCore.runClasses(Member_ResourceTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

    }
}