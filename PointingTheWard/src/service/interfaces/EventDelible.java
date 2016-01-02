package service.interfaces;

import model.beans.Event;

public interface EventDelible {
	
	public boolean deleteEventTitle(String title);
	public boolean deleteEventEmail(String email);
	public boolean deleteEvent(Event event);
}
