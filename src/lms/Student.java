package lms;

import java.util.Calendar;

public class Student extends Member {

	public Student(int memberID) {
		super(memberID);
	}

	@Override
	public Day calculateNewBookDueDate(Day startDate) {
        Day newDate = startDate.addDays(28);
        return newDate;
	}

}
