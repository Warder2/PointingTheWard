
package persistance.dao.Interfaces;

import persistance.dto.EventDTO;

public interface EventModifyDAO {

	public void eventModify(EventDTO oldEvent, EventDTO newEvent);
	public void eventModifyCode(int eventCode, EventDTO newEvent);
}