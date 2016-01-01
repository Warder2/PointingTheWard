package persistance.dao.Interfaces;

import java.util.List;

import model.beans.Friend;
import model.beans.Group;

public interface GroupCreateDAO {
	//create group
	void createGroup(Group group);
	void createGroup(String name, List<Friend> friends);
}
