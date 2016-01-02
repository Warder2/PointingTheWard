package persistance.dao.Interfaces;

import java.util.List;

import persistance.viewdto.EventParticipantInfoViewDTO;
import persistance.viewdto.EventParticipantViewDTO;
import persistance.viewdto.EventViewDTO;

public interface EventSearchDAO {

	
	
	public EventViewDTO eventSearchCode(int eventCode);
	
	public List<EventParticipantInfoViewDTO> eventParticipantInfoSearch(String email, int eventCode);
	public List<EventParticipantInfoViewDTO> eventParticipantInfoSearchMail(String email);
	public List<EventParticipantInfoViewDTO> eventParticipantInfoSearchCode(int eventCode);
	
	public List<EventParticipantViewDTO> eventParticipantSearchMail(String email);
	public List<EventParticipantViewDTO> eventParticipantSearchCode(int eventCode);
	public List<EventParticipantViewDTO> eventParticipantSearch(String email, int eventCode);
}