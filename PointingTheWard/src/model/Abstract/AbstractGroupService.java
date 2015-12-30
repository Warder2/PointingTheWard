package model.Abstract;

import model.ListVO.GroupList;
import model.interfaces.GroupCreatable;
import model.interfaces.GroupDelible;
import model.interfaces.GroupModifiable;
import model.interfaces.GroupSearchable;

public abstract class AbstractGroupService implements GroupCreatable, GroupSearchable, GroupModifiable, GroupDelible {
	private static GroupList groups;

	static {
		AbstractGroupService.groups = new GroupList();
	}

	public static GroupList getGroups() {
		return groups;
	}

	public static void setGroups(GroupList groups) {
		AbstractGroupService.groups = groups;
	}

}
