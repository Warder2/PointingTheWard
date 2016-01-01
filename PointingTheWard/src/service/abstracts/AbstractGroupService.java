package service.abstracts;

import model.list.GroupList;
import service.Service;

public abstract class AbstractGroupService implements Service{
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
