package service;

import model.beans.Event;
import service.abstracts.AbstractCalendarService;
import service.interfaces.EventDelible;

public class EventDeleteService extends AbstractCalendarService implements EventDelible{

	@Override
	public void execute(ServiceRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteEvent(Event event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEventTitle(String title) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEventDate(String sDate, String eDate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEventDateTime(String sDate, String eDate, String sTime, String eTime) {
		// TODO Auto-generated method stub
		return false;
	}

}
