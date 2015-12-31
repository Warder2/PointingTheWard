package service;

import model.beans.Event;
import service.abstracts.AbstractCalendarService;
import service.interfaces.EventCreatable;

public class EventRegistService extends AbstractCalendarService implements EventCreatable{

	@Override
	public void execute(ServiceRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean createEvent(Event event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createEvent(int index, Event event) {
		// TODO Auto-generated method stub
		
	}

}
