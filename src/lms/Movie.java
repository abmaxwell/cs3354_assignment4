package lms;

import java.util.Calendar;


/**
 * A movie in the collection.
 * @author Jill Seaman
 *
 */
public class Movie extends Resource {
	
	private String upc;      // the universal product code for the movie

	/**
	 * constructs Movie from parameters
	 * @param resourceID
	 * @param title
	 * @param upc
	 */
	public Movie(int resourceID, String title, String upc) {
		super(resourceID, title);
		this.upc = upc;
	}

	@Override
	public Day calculateNewDueDate(Day startDate, Member member) {
		
        return startDate.addDays(7);  //Movies are checked out for 7 days	
	}
}
