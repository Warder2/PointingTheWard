package service;

import java.util.List;

import model.beans.Event;
import model.beans.Member;
import model.beans.Place;
import service.abstracts.AbstractCalendarService;
import service.interfaces.EventModifiable;
/**
 * 이벤트 수정 서비스 클래스
 * @author SEONGBONG
 *
 */
public class EventModifyService extends AbstractCalendarService implements EventModifiable{

	@Override
	public void execute(ServiceRequest request) {
		// TODO Auto-generated method stub
		System.out.println("EventModifyService test : " + request.getObject("test"));
	}

	@Override
	public boolean modifyEvent(String email, Event event, Event newEvent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyEventTitle(String email, Event event, String newTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyEventTitle(String email, String sDate, String eDate, String sTime, String eTime,
			String newTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyEventDate(String email, Event event, String newSdate, String newEdate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyEventDate(String email, String sDate, String eDate, String sTime, String eTime,
			String newSdate, String newEdate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyEventDateTime(String email, Event event, String newStime, String newEtime) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyEventDateTime(String email, String sDate, String eDate, String sTime, String eTime,
			String newSdate, String newEdate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyEventContent(String email, Event event, String newContent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyEventContent(String email, String sDate, String eDate, String sTime, String eTime,
			String newContent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyEventPlace(String email, Event event, Place place) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyEventPlace(String email, String sDate, String eDate, String sTime, String eTime, Place place) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyEventParticipants(String email, Event event, List<Member> participants) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyEventParticipants(String email, String sDate, String eDate, String sTime, String eTime,
			List<Member> participants) {
		// TODO Auto-generated method stub
		return false;
	}

}
