package model.interfaces;

import model.beans.Group;

public interface GroupModifiable {
	public boolean modifyGroupName(String name, String newName);
	public boolean modifyGroup(String name, Group newGroup);
	public boolean modifyGroup(Group group, Group newGroup);
}
