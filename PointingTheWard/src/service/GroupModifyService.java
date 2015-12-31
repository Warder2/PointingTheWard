package service;

import model.beans.Group;
import service.abstracts.AbstractGroupService;
import service.interfaces.GroupModifiable;

public class GroupModifyService extends AbstractGroupService implements GroupModifiable{

	@Override
	public void execute(ServiceRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean modifyGroupName(String name, String newName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyGroup(String name, Group newGroup) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyGroup(Group group, Group newGroup) {
		// TODO Auto-generated method stub
		return false;
	}

}
