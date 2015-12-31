package service;

import model.beans.Event;
import service.abstracts.AbstractCalendarService;
import service.interfaces.EventCreatable;

public class EventRegistService extends AbstractCalendarService implements EventCreatable{

	@Override
	public void execute(ServiceRequest request) {
		Event event = request.getObject("eventInfo");
		if(event != null){
			createEvent(event);
		}
	}

	@Override
	public boolean createEvent(Event event) {
		System.out.println(event);
		return false;
	}

	@Override
	public void createEvent(int index, Event event) {
		// TODO Auto-generated method stub
		
	}

}
