package persistance.dao.Interfaces;

import java.util.List;

import model.beans.Member;
import model.beans.Place;
import persistance.dto.EventDTO;
public interface EventRegistDAO {

	public void eventRegist(String email , EventDTO event);
	public void eventRegist(String email,String title, String content, String sDate , String eDate , String sTime, String eTime, String place  );
	
}