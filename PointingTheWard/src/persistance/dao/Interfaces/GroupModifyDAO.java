package persistance.dao.Interfaces;

import model.beans.Group;

public interface GroupModifyDAO {
	//modify group
	void modifyGroup(int gCode, Group group);
	void modifyGroup(int gCode, String name);
}
