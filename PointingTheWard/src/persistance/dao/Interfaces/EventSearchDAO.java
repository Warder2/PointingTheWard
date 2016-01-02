package persistance.dao.Interfaces;

import java.util.List;

import model.beans.Event;
import persistance.viewdto.EventParticipantInfoViewDTO;
import persistance.viewdto.EventViewDTO;

public interface EventSearchDAO {

	
	public EventViewDTO eventSearchCode(int eventCode);
	public List<EventParticipantInfoViewDTO> eventSearchMail(String email);
	public List<EventParticipantInfoViewDTO> eventSearchTitle(String email, String title);
	public List<EventParticipantInfoViewDTO> eventSearchDate(String email, String sDate , String eDate);
	public List<EventParticipantInfoViewDTO> eventSearchTime(String email, String sTime , String eTime);
	public List<EventParticipantInfoViewDTO> eventSearchContent(String email , String content);
	
}