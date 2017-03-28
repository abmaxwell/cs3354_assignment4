package lms;

public class Faculty extends Member {

	public Faculty(int memberID) {
		super(memberID);
	}

	@Override
	public Day calculateNewBookDueDate(Day startDate) {
        Day newDate = startDate.addDays(90);
        return newDate;
	}

}
