package service;

import model.beans.Group;
import service.abstracts.AbstractGroupService;
import service.interfaces.GroupCreatable;

public class GroupCreateService extends AbstractGroupService implements GroupCreatable{

	@Override
	public void execute(ServiceRequest request) {
		// TODO Auto-generated method stub
		System.out.println("GroupCreateService test : " + request.getObject("test"));
	}

	@Override
	public boolean addGroup(Group group) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addGroup(int index, Group group) {
		// TODO Auto-generated method stub
		return false;
	}

}
