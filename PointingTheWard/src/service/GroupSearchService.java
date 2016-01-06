package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import model.beans.Friend;
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
		String owner = request.getObject("owner");
		String name = request.getObject("gName");
		
		if(owner != null){
			List<Group> groups = null;
			if(name != null){
				groups = searchGroupName(name, owner);
			}else{
				groups = searchGroup(owner);
			}
			request.addObject("groups", groups);
		}else{
			int gCode = request.getObject("gCode");
			Group group = searchGroup(gCode);
			request.addObject("group", group);
		}
	}

	@Override
	@Transactional
	public List<Group> searchGroup(String owner) {
		List<GroupDTO> groupDTOs = groupDao.searchGroup(owner);
		List<Group> groups = new ArrayList<Group>();
		for(GroupDTO groupDTO : groupDTOs){
			Group group = new Group();
			group.setgCode(groupDTO.getCode());
			group.setName(groupDTO.getName());
			List<Friend> participants = new ArrayList<Friend>();
			List<GroupParticipantInfoDTO> infoDTOs = groupDao.searchGroupParticipants(groupDTO.getCode());
			for(GroupParticipantInfoDTO infoDTO : infoDTOs){
				participants.add(new Friend(infoDTO.getName(), infoDTO.getEmail()));
			}
			group.setParticipants(participants);
			groups.add(group);
		}
		return groups;
	}

	@Override
	public Group searchGroup(int gCode) {
		List<GroupParticipantInfoDTO> infoDTOs = groupDao.searchGroupParticipants(gCode);
		Group group = new Group();
		group.setgCode(gCode);
		group.setName(infoDTOs.get(0).getGName());
		List<Friend> participants = new ArrayList<Friend>();
		for(GroupParticipantInfoDTO infoDTO : infoDTOs){
			participants.add(new Friend(infoDTO.getName(), infoDTO.getEmail()));
		}
		group.setParticipants(participants);
		return group;
	}

	@Override
	public List<Group> searchGroupName(String name, String owner) {
		List<GroupDTO> groupDTOs = groupDao.searchGroupByName(name, owner);
		List<Group> groups = new ArrayList<Group>();
		for(GroupDTO groupDTO : groupDTOs){
			Group group = new Group();
			group.setgCode(groupDTO.getCode());
			group.setName(groupDTO.getName());
			List<Friend> participants = new ArrayList<Friend>();
			List<GroupParticipantInfoDTO> infoDTOs = groupDao.searchGroupParticipants(groupDTO.getCode());
			for(GroupParticipantInfoDTO infoDTO : infoDTOs){
				participants.add(new Friend(infoDTO.getName(), infoDTO.getEmail()));
			}
			group.setParticipants(participants);
			groups.add(group);
		}
		return groups;
	}
}
