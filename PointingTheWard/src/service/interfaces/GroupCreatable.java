package service.interfaces;

import model.beans.Group;

public interface GroupCreatable {
	public boolean addGroup(Group group);
	public boolean addGroup(int index,Group group);
}
