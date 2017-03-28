package lms;


/**
 * Represents a resource in a library collection.
 * @author Jill Seaman
 *
 */
public abstract class Resource  {

	public final static int CHECKED_OUT = 0;
	public final static int ON_THE_SHELF = 1;
	
	private int resourceID;           // library's id number
    private String title;             // product title
    private Day dueDate;             // date the Resource is due back
    private int status;               // status (availability) of the item
                                      // currently only checked out or on the shelf
 

	/**
	 * Constructs Product from parameters.
	 * @param resourceID
	 * @param title
	 */
	public Resource(int resourceID, String title) {
		this.resourceID = resourceID;
		this.title = title;
		this.status = ON_THE_SHELF;   //by default it is available
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

    public int getResourceID() {
        return resourceID;
    }

	public Day getDueDate() {
		return dueDate;
	}

	/**
	 * A  setter for the dueDate attribute, saves a copy of the argument.
	 * @param dueDate
	 */
	public void setDueDate(Day dueDate) {
		this.dueDate = dueDate;
	}
	
    /**
     * Calculates the dueDate by adding the appropriate amount of time to
     * the startDate.
     * @param startDate is the date the resource is checked out.
     * @param member the member checking out the book
     * @return the date the resource should be due.
     */
    abstract public Day calculateNewDueDate(Day startDate, Member member);
	
    /**
     * Calculates the fine assuming the book is returned on the given date.
     * Library members are fined $0.25 per day that the books are overdue 
     * to a maximum of $5.00 per overdue item.
     * @param date is the date that the book was returned.
     * @return the calculated fine.
     */
	public double calculateFine(Day date) {
		if (dueDate==null)
			return 0;
		// .25 per day, up to 5.00 max
        int days = date.daysFrom(dueDate); //if positive, dueDate is before date
		if (days>0) {
			double fine = days * 0.25;
			return (Math.min(fine,5.00));
		}
		return 0;
	}
}