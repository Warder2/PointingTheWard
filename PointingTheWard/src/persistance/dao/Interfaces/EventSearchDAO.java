package persistance.dao.Interfaces;

import java.util.List;

import model.beans.Event;

public interface EventSearchDAO {

	public List<Event> eventSearch(String email);
	public Event eventSearch(String email, String title);
	public List<Event> eventSearchDate(String email, String sDate , String eDate);
	public List<Event> eventSearchTime(String email, String sTime , String eTime);
	public List<Event> eventSearchContent(String email , String content);
	
}