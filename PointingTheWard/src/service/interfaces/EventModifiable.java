package service.interfaces;

import java.util.List;

import model.beans.Event;
import model.beans.Member;
import model.beans.Place;

public interface EventModifiable {
	public boolean modifyEvent(Event event,Event newEvent);
	public boolean modifyEventTitle(Event event,String newTitle);
	public boolean modifyEventTitle(String sDate,String eDate,String sTime,String eTime,String newTitle);
	public boolean modifyEventDate(Event event,String newSdate,String newEdate);
	public boolean modifyEventDate(String sDate,String eDate,String sTime,String eTime,String newSdate,String newEdate);
	public boolean modifyEventDateTime(Event event,String newStime,String newEtime);
	public boolean modifyEventDateTime(String sDate,String eDate,String sTime,String eTime,String newSdate,String newEdate);
	public boolean modifyEventContent(Event event,String newContent);
	public boolean modifyEventContent(String sDate,String eDate,String sTime,String eTime,String newContent);
	public boolean modifyEventPlace(Event event,Place place);
	public boolean modifyEventPlace(String sDate,String eDate,String sTime,String eTime,Place place);
	public boolean modifyEventParticipants(Event event,List<Member> participants);
	public boolean modifyEventParticipants(String sDate,String eDate,String sTime,String eTime,List<Member> participants);
}
