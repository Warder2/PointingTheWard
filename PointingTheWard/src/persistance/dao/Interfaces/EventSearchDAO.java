package persistance.dao.Interfaces;

import java.util.List;

import persistance.dto.EventParticipantInfoDTO;
import persistance.viewdto.EventParticipantDTO;
import persistance.viewdto.EventViewDTO;

public interface EventSearchDAO {

	
	
	public EventViewDTO eventSearchCode(int eventCode);
	
	public List<EventParticipantInfoDTO> eventParticipantInfoSearch(String email, int eventCode);
	public List<EventParticipantInfoDTO> eventParticipantInfoSearchMail(String email);
	public List<EventParticipantInfoDTO> eventParticipantInfoSearchCode(int eventCode);
	
	public List<EventParticipantDTO> eventParticipantSearchMail(String email);
	public List<EventParticipantDTO> eventParticipantSearchCode(int eventCode);
	public List<EventParticipantDTO> eventParticipantSearch(String email, int eventCode);
}