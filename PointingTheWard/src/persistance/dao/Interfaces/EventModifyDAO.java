
package persistance.dao.Interfaces;

import model.beans.Event;

public interface EventModifyDAO {

	public void eventModify(String email, Event event , Event newEvent);
	
	
}