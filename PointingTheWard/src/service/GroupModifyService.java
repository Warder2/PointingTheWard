package service;

import model.List.MemberList;
import model.beans.Group;
import model.beans.Member;
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
