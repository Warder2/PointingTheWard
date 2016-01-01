package persistance.dao.impl;

import java.util.List;

import model.beans.Event;
import model.beans.Member;
import model.beans.Place;
import persistance.dao.EventDAO;

public class EventDAOImpl implements EventDAO{

	@Override
	public void eventDeleteDate(String email, String sDate, String eDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eventDeleteTime(String email, String sTime, String eTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eventDelete(String email, String sDate, String eDate, String sTime, String eTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eventDelete(String email, String title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eventModify(String email, Event event, Event newEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Event> eventSearch(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event eventSearch(String email, String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> eventSearchDate(String email, String sDate, String eDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> eventSearchTime(String email, String sTime, String eTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> eventSearchContent(String email, String content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eventRegist(String email, Event event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eventRegist(String email, String content, String sDate, String eDate, String sTime, String eTime,
			Place place, List<Member> participants) {
		// TODO Auto-generated method stub
		
	}

}
