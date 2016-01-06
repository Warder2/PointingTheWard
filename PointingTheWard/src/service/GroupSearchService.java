package service;

import java.util.ArrayList;
import java.util.List;

import model.beans.Group;
import persistance.dao.GroupDAO;
import persistance.dto.GroupDTO;
import persistance.dto.GroupParticipantInfoDTO;
import service.abstracts.AbstractGroupService;
import service.interfaces.GroupSearchable;

public class GroupSearchService extends AbstractGroupService implements GroupSearchable{
	private GroupDAO groupDao;
	
	public void setGroupDao(GroupDAO groupDao) {
		this.groupDao = groupDao;
	}
	
	@Override
	public void execute(ServiceRequest request) {
	}

	@Override
	public List<Group> searchGroup(String owner) {
		List<GroupDTO> groupDTOs = groupDao.searchGroup(owner);
		List<Group> groups = new ArrayList<Group>();
		for(GroupDTO groupDTO : groupDTOs){
			Group group = new Group(name, participants);
		}
		List<GroupParticipantInfoDTO> infoDTOs = groupDao.searchGroupParticipants(groupDTOs);
		return null;
	}

	@Override
	public Group searchGroup(int gCode) {
		return null;
	}

	@Override
	public List<Group> searchGroupName(String name, String owner) {
		return null;
	}
}
