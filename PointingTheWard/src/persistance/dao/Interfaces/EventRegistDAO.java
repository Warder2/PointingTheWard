package persistance.dao.Interfaces;

import java.util.List;

import model.beans.Event;
import model.beans.Member;
import model.beans.Place;
public interface EventRegistDAO {

	
	public void eventRegist(String email , Event event);
	public void eventRegist(String email,String content, String sDate , String eDate , String sTime, String eTime, Place place , List<Member> participants );
	
}