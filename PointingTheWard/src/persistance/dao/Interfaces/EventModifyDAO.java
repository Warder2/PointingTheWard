
package persistance.dao.Interfaces;

import persistance.dto.EventDTO;

public interface EventModifyDAO {

	public void eventModify(EventDTO oldEvent, EventDTO newEvent);
	public void eventModify(int eventCode, EventDTO newEvent);
	
	public void eventParticipantModify(String email, EventDTO newEvent);
	public void eventParticipantModift(String email, int eventCode);
}