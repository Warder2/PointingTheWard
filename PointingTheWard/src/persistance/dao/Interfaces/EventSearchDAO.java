package persistance.dao.Interfaces;

import java.util.List;

import persistance.dto.EventDTO;
import persistance.dto.EventParticipantDTO;
import persistance.dto.EventParticipantInfoDTO;

public interface EventSearchDAO {

	public EventDTO eventSearchCode(int eventCode);

	public List<EventParticipantInfoDTO> eventParticipantInfoSearch(String email, int eventCode);

	public List<EventParticipantInfoDTO> eventParticipantInfoSearchMail(String email);

	public List<EventParticipantInfoDTO> eventParticipantInfoSearchCode(int eventCode);

	public List<EventParticipantDTO> eventParticipantSearchMail(String email);

	public List<EventParticipantDTO> eventParticipantSearchCode(int eventCode);

	public List<EventParticipantDTO> eventParticipantSearch(String email, int eventCode);
}