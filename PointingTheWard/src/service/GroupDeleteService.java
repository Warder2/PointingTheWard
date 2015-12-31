package service;

import service.abstracts.AbstractGroupService;
import service.interfaces.GroupDelible;

public class GroupDeleteService extends AbstractGroupService implements GroupDelible{

	@Override
	public void execute(ServiceRequest request) {
		// TODO Auto-generated method stub
		System.out.println("GroupDeleteService test : " + request.getObject("test"));
	}

	@Override
	public boolean deleteGroupName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

}
