package service;

import java.util.List;

import model.beans.Event;
import model.beans.Member;
import model.beans.Place;
import service.abstracts.AbstractCalendarService;
import service.interfaces.EventModifiable;

public class EventModifyService extends AbstractCalendarService implements EventModifiable{

	@Override
	public void execute(ServiceRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean modifyEvent(Event event, Event newEvent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyEventTitle(Event event, String newTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyEventTitle(String sDate, String eDate, String sTime, String eTime, String newTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyEventDate(Event event, String newSdate, String newEdate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyEventDate(String sDate, String eDate, String sTime, String eTime, String newSdate,
			String newEdate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyEventDateTime(Event event, String newStime, String newEtime) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyEventDateTime(String sDate, String eDate, String sTime, String eTime, String newSdate,
			String newEdate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyEventContent(Event event, String newContent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyEventContent(String sDate, String eDate, String sTime, String eTime, String newContent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyEventPlace(Event event, Place place) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyEventPlace(String sDate, String eDate, String sTime, String eTime, Place place) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyEventParticipants(Event event, List<Member> participants) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyEventParticipants(String sDate, String eDate, String sTime, String eTime,
			List<Member> participants) {
		// TODO Auto-generated method stub
		return false;
	}

}
