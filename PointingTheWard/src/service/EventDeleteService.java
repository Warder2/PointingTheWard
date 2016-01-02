package service;

import model.beans.Event;
import service.abstracts.AbstractCalendarService;
import service.interfaces.EventDelible;

public class EventDeleteService extends AbstractCalendarService implements EventDelible{

	@Override
	public void execute(ServiceRequest request) {
		String title = request.getObject("eventTitle");
		if(title != null){
			deleteEventTitle(title);
		}
	}

	@Override
	public boolean deleteEvent(Event event) {
		return false;
	}

	@Override
	public boolean deleteEventTitle(String title) {
		System.out.println("delete : " + title);
		return false;
	}

	@Override
	public boolean deleteEventEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

}
