package service;

import model.beans.Group;
import model.beans.Member;
import model.list.MemberList;
import service.abstracts.AbstractGroupService;
import service.interfaces.GroupModifiable;

public class GroupModifyService extends AbstractGroupService implements GroupModifiable{

	@Override
	public void execute(ServiceRequest request) {
		// TODO Auto-generated method stub
		System.out.println("GroupModifyService test : " + request.getObject("test"));
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

	@Override
	public boolean modifyGroupParticipant(Group group, MemberList members) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyGroupParticipant(String name, MemberList members) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyGroupParticipantAdd(Group group, Member member) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyGroupParticipantAdd(String name, Member member) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyGroupParticipantDropout(Group group, Member member) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyGroupParticipantDropout(String name, Member member) {
		// TODO Auto-generated method stub
		return false;
	}

}
