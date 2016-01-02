package service.interfaces;

import java.util.List;

import model.beans.Event;
import model.beans.Member;
import model.beans.Place;

public interface EventModifiable {
	public boolean modifyEvent(String email, Event event,Event newEvent);
	public boolean modifyEventTitle(String email, Event event,String newTitle);
	public boolean modifyEventTitle(String email, String sDate,String eDate,String sTime,String eTime,String newTitle);
	public boolean modifyEventDate(String email, Event event,String newSdate,String newEdate);
	public boolean modifyEventDate(String email, String sDate,String eDate,String sTime,String eTime,String newSdate,String newEdate);
	public boolean modifyEventDateTime(String email, Event event,String newStime,String newEtime);
	public boolean modifyEventDateTime(String email, String sDate,String eDate,String sTime,String eTime,String newSdate,String newEdate);
	public boolean modifyEventContent(String email, Event event,String newContent);
	public boolean modifyEventContent(String email, String sDate,String eDate,String sTime,String eTime,String newContent);
	public boolean modifyEventPlace(String email, Event event,Place place);
	public boolean modifyEventPlace(String email, String sDate,String eDate,String sTime,String eTime,Place place);
	public boolean modifyEventParticipants(String email, Event event,List<Member> participants);
	public boolean modifyEventParticipants(String email, String sDate,String eDate,String sTime,String eTime,List<Member> participants);
}
