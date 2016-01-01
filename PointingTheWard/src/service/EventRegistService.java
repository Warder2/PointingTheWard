package service;

import model.beans.Event;
import model.list.MemberList;
import service.abstracts.AbstractCalendarService;
import service.interfaces.EventRegistable;

public class EventRegistService extends AbstractCalendarService implements EventRegistable{

	@Override
	public void execute(ServiceRequest request) {
		Event event = request.getObject("eventInfo");
		if(event != null){
			registEvent(event);
		}
	}

	@Override
	public boolean registEvent(Event event) {
		// TODO Auto-generated method stub
		System.out.println(event);
		return false;
	}

	@Override
	public void registEvent(int index, Event event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int registEvent(MemberList members, Event event) {
		// TODO Auto-generated method stub
		return 0;
	}

}
