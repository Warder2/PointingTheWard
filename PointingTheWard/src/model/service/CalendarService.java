package model.service;

import java.util.ArrayList;
import java.util.List;

import model.Abstract.AbstractCalendarService;
import model.beans.Event;
import model.beans.Member;
import model.beans.Place;

public class CalendarService extends AbstractCalendarService{
	public boolean createEvent(Event event){
		return false;
	}
	public void createEvent(int index, Event event) {
	}
	public Event searchEvent(Event event){
		return new Event();
	}
	public List<Event> searchEventTitle(String title){
		return new ArrayList<Event>();		
	}
	public List<Event> searchEventSdate(String sDate){
		return new ArrayList<Event>();
	}
	public List<Event> searchEventSdateEdate(String sDate,String eDate){
		return new ArrayList<Event>();
	}
	public List<Event> searchEventStime(String stime){
		return new ArrayList<Event>();
	}
	public List<Event> searchEventStimeEtime(String sTime,String etime){
		return new ArrayList<Event>();
	}
	public List<Event> searchEventPlace(Place place){
		return new ArrayList<Event>();
	}
	public List<Event> searchEventParticipants(List<Member> participants){
		return new ArrayList<Event>();
	}
	public boolean modifyEvent(Event event,Event newEvent){
		return false;
	}
	public boolean modifyEventTitle(Event event,String newTitle){
		return false;
	}
	public boolean modifyEventTitle(String sDate,String eDate,String sTime,String eTime,String newTitle){
		return false;
	}
	public boolean modifyEventDate(Event event,String newSdate,String newEdate){
		return false;
	}
	public boolean modifyEventDate(String sDate,String eDate,String sTime,String eTime,String newSdate,String newEdate){
		return false;
	}
	public boolean modifyEventDateTime(Event event,String newStime,String newEtime){
		return false;
	}
	public boolean modifyEventDateTime(String sDate,String eDate,String sTime,String eTime,String newSdate,String newEdate){
		return false;
	}
	public boolean modifyEventContent(Event event,String newContent){
		return false;
	}
	public boolean modifyEventContent(String sDate,String eDate,String sTime,String eTime,String newContent){
		return false;
	}
	public boolean modifyEventPlace(Event event,Place place){
		return false;
	}
	public boolean modifyEventPlace(String sDate,String eDate,String sTime,String eTime,Place place){
		return false;
	}
	public boolean modifyEventParticipants(Event event,List<Member> participants){
		return false;
	}
	public boolean modifyEventParticipants(String sDate,String eDate,String sTime,String eTime,List<Member> participants){
		return false;
	}
	public boolean deleteEvent(Event event){
		return false;
	}
	public boolean deleteEventTitle(String title){
		return false;
	}
	public boolean deleteEventDate(String sDate,String eDate){
		return false;
	}
	public boolean deleteEventDateTime(String sDate,String eDate,String sTime,String eTime){
		return false;
	}
}
