package persistance.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import model.beans.Friend;
import model.beans.Group;
import persistance.dao.GroupDAO;
import persistance.dto.GroupDTO;
import persistance.viewdto.GroupParticipantInfoViewDTO;

public class GroupDAOImpl implements GroupDAO{
	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public void createGroup(Group group) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createGroup(String name, List<Friend> friends) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGroup(int gCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGroup(int gCode, String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGroups(String email, int... gCodes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGroups(String email, List<Integer> gCodes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyGroup(int gCode, Group group) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyGroup(int gCode, String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFriend(int gCode, String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFriends(int gCode, String... emails) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFriend(int gCode, Friend friend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFriends(int gCode, Friend... friends) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFriends(int gCode, List<Friend> friends) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<GroupDTO> searchGroupInfoAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GroupDTO> searchGroupInfo(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GroupParticipantInfoViewDTO> searchGroupParticipants(int gCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupParticipantInfoViewDTO searchGroupParticipant(int gCode, String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
