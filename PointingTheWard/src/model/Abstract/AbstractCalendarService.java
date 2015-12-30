package model.Abstract;

import model.ListVO.Calendar;
import model.interfaces.EventCreatable;
import model.interfaces.EventDelible;
import model.interfaces.EventModifiable;
import model.interfaces.EventSearchable;

public abstract class AbstractCalendarService implements EventCreatable,EventSearchable,EventModifiable,EventDelible{
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
