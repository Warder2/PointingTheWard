package service.interfaces;

import model.beans.Event;

public interface EventCreatable {
	public boolean createEvent(Event event);
	public void createEvent(int index, Event event);
}
