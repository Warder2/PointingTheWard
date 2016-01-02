package service.interfaces;

import java.util.List;

import model.beans.Event;
import model.beans.Member;
import model.beans.Place;
import persistance.viewdto.EventViewDTO;

public interface EventSearchable {
	public Event searchEvent(Event event);
	public List<Event> searchEventTitle(String title);
	public List<Event> searchEventSdate(String sDate);
	public List<Event> searchEventSdateEdate(String sDate,String eDate);
	public List<Event> searchEventStime(String stime);
	public List<Event> searchEventStimeEtime(String sTime,String etime);
	public List<Event> searchEventPlace(Place place);
	public List<Event> searchEventParticipants(List<Member> participants);
}
