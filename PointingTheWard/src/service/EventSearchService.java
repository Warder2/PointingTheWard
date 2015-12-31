package service;

import java.util.List;

import model.beans.Event;
import model.beans.Member;
import model.beans.Place;
import service.abstracts.AbstractCalendarService;
import service.interfaces.EventSearchable;

public class EventSearchService extends AbstractCalendarService implements EventSearchable{

	@Override
	public void execute(ServiceRequest request) {
		// TODO Auto-generated method stub
		
		System.out.println("sDate : " + request.getObject("sDate"));
		System.out.println("eDate : " + request.getObject("eDate"));
	}

	@Override
	public Event searchEvent(Event event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> searchEventTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> searchEventSdate(String sDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> searchEventSdateEdate(String sDate, String eDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> searchEventStime(String stime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> searchEventStimeEtime(String sTime, String etime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> searchEventPlace(Place place) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> searchEventParticipants(List<Member> participants) {
		// TODO Auto-generated method stub
		return null;
	}

}
