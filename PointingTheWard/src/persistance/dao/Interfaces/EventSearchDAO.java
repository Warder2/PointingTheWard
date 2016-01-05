package persistance.dao.Interfaces;

import java.util.List;

import persistance.dto.EventDTO;
import persistance.dto.EventParticipantDTO;
import persistance.dto.EventParticipantInfoDTO;

public interface EventSearchDAO {

	public List<EventDTO> eventSearchAll();
	
	public EventDTO eventSearchCode(int eventCode);

	public List<EventParticipantDTO> eventParticipantSearchMail(String email);

	public List<EventParticipantDTO> eventParticipantSearchCode(int eventCode);

	public EventParticipantDTO eventParticipantSearch(String email, int eventCode);
	
	public List<EventParticipantInfoDTO> eventParticipantInfoSearchMail(String email);
	
	public EventParticipantInfoDTO eventParticipantInfoSearch(String email, int eventCode);

	public EventParticipantInfoDTO eventParticipantInfoSearchCode(int eventCode);

	public List<EventDTO> eventSearch(EventDTO event);
	
	public List<EventDTO> eventSearchRangeDate(String sDate , String eDate);
	
	public List<EventDTO> eventSearchScope(int scope);
	
	public List<EventDTO> eventSearchRangeTime(String date , String sTime, String eTime);
	
}