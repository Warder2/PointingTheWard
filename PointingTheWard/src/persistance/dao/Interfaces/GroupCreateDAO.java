package persistance.dao.Interfaces;

import java.util.List;
import persistance.dto.GroupDTO;

public interface GroupCreateDAO {
	//create group
	void createGroup(GroupDTO group);
	void createGroup(String name, String... ids);
	void createGroup(String name, List<String> ids);
}
