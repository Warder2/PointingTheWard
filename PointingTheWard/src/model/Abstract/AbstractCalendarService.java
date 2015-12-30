package model.Abstract;

import model.ListVO.Calendar;

public abstract class AbstractCalendarService {
	private static Calendar calendar;

	static {
		AbstractCalendarService.calendar = new Calendar();
	}

	public static Calendar getCalendar() {
		return calendar;
	}

	public static void setCalendar(Calendar calendar) {
		AbstractCalendarService.calendar = calendar;
	}
}
