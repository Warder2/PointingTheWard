package service;

import model.beans.Group;
import service.abstracts.AbstractGroupService;
import service.interfaces.GroupSearchable;

public class GroupSearchService extends AbstractGroupService implements GroupSearchable{

	@Override
	public void execute(ServiceRequest request) {
		// TODO Auto-generated method stub
		System.out.println("GroupSearchService test : " + request.getObject("test"));
	}

	@Override
	public Group searchGroupName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group searchGroup(Group group) {
		// TODO Auto-generated method stub
		return null;
	}

}
