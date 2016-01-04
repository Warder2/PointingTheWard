package persistance.dao.Interfaces;

import persistance.dto.GroupDTO;

public interface GroupModifyDAO {
	//modify group
	void modifyGroup(GroupDTO group);
	void modifyGroup(int gCode, String name);
}
