package service.interfaces;

import model.beans.Group;

public interface GroupSearchable {
public Group searchGroupName(String name);	
	public Group searchGroup(Group group);
}
