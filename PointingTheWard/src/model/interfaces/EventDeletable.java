package model.interfaces;

import model.beans.Event;

public interface EventDeletable {
	public boolean deleteEvent(Event event);
	public boolean deleteEventTitle(String title);
	public boolean deleteEventDate(String sDate,String eDate);
	public boolean deleteEventDateTime(String sDate,String eDate,String sTime,String eTime);
}
