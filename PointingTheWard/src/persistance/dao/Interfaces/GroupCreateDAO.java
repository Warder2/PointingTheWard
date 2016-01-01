package persistance.dao.Interfaces;

import java.util.List;

import model.beans.Group;

public interface GroupCreateDAO {
	//create group
	void createGroup(Group group);
	void createGroup(String name, String... ids);
	void createGroup(String name, List<String> ids);
}
