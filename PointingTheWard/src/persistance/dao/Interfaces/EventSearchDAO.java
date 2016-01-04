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

	public List<EventParticipantInfoDTO> eventParticipantInfoSearchCode(int eventCode);

	
}