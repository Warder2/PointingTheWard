package persistance.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import model.beans.Friend;
import model.beans.Group;
import persistance.dao.GroupDAO;
import persistance.dto.GroupDTO;
import persistance.dto.GroupParticipantInfoDTO;

public class GroupDAOImpl implements GroupDAO{
	private JdbcTemplate template;
	private RowMapper<GroupDTO> groupDTOMapper = new RowMapper<GroupDTO>() {
		
		@Override
		public GroupDTO mapRow(ResultSet rs, int index) throws SQLException {
			GroupDTO groupDTO = new GroupDTO();
			groupDTO.setCode(rs.getInt("g_code"));
			groupDTO.setName(rs.getString("name"));
			return groupDTO;
		}
	};
	private RowMapper<GroupParticipantInfoDTO> groupParticipantInfoViewDTOMapper = new RowMapper<GroupParticipantInfoDTO>() {
		
		@Override
		public GroupParticipantInfoDTO mapRow(ResultSet rs, int index) throws SQLException {
			GroupParticipantInfoDTO groupParticipantInfoViewDTO = new GroupParticipantInfoDTO();
			groupParticipantInfoViewDTO.setGroupCode(rs.getInt("g_code"));
			groupParticipantInfoViewDTO.setEmail(rs.getString("email"));
			groupParticipantInfoViewDTO.setGroupName(rs.getString("name"));
			groupParticipantInfoViewDTO.setLocation(rs.getString("location"));
			groupParticipantInfoViewDTO.setTransportation(rs.getString("transportation"));
			return groupParticipantInfoViewDTO;
		}
	};
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public void createGroup(Group group) {
		
	}
	
	@Override
	public void createGroup(String name, String... ids) {
		
	}

	@Override
	public void createGroup(String name, List<String> ids) {
		template.update("insert into group_view(g_code, name) values(group_sequence.nextval, ?)", name);
		for(String id : ids){
			template.update("insert into g_participant_view(g_code, email) values(?, ?)", id);
		}
	}
	
	@Override
	public void deleteGroupAll() {
		template.update("delete from group_view");
	}

	@Override
	public void deleteGroup(int gCode) {
		template.update("delete from group_view where gCode=?", gCode);
	}

	@Override
	public void deleteGroup(int gCode, String email) {
		template.update("delete from group_view where gCode=? and email=?", gCode, email);
	}

	@Override
	@Transactional
	public void deleteGroups(String email, int... gCodes) {
		for(int gCode : gCodes){
			template.update("delete from g_participant_view where email=? and g_code=?", email, gCode);
		}
	}

	@Override
	public void deleteGroups(String email, List<Integer> gCodes) {
		for(int gCode : gCodes){
			template.update("delete from g_participant_view where email=? and g_code=?", email, gCode);
		}
	}

	@Override
	public void modifyGroup(int gCode, Group group) {
		modifyGroup(gCode, group.getName());
	}

	@Override
	public void modifyGroup(int gCode, String name) {
		template.update("update g_participant_view set name=? where g_code=?", name, gCode);
	}

	@Override
	public void addFriend(int gCode, String email) {
		template.update("insert into g_participant_view(g_code, email) values(?, ?)", gCode, email);
	}

	@Override
	@Transactional
	public void addFriends(int gCode, String... emails) {
		for(String email : emails){
			addFriend(gCode, email);
		}
	}

	@Override
	public void addFriend(int gCode, Friend friend) {
		addFriend(gCode, friend.getEmail());
	}

	@Override
	@Transactional
	public void addFriends(int gCode, Friend... friends) {
		// TODO Auto-generated method stub
		for(Friend friend : friends){
			addFriend(gCode, friend);
		}
	}

	@Override
	@Transactional
	public void addFriends(int gCode, List<Friend> friends) {
		// TODO Auto-generated method stub
		for(Friend friend : friends){
			addFriend(gCode, friend);
		}
	}

	@Override
	public List<GroupDTO> searchGroupInfoAll() {
		return template.query("select * from group_view", groupDTOMapper);
	}

	@Override
	public List<GroupDTO> searchGroupInfo(String email) {
		return template.query("select * from group_view where email=?", groupDTOMapper, email);
	}

	@Override
	public List<GroupParticipantInfoDTO> searchGroupParticipants(int gCode) {
		return template.query("select * from g_participant_info_view where g_code=?", groupParticipantInfoViewDTOMapper);
	}

	@Override
	public GroupParticipantInfoDTO searchGroupParticipant(int gCode, String email) {
		// TODO Auto-generated method stub
		return template.queryForObject("select * from g_participant_info_view where email=? and g_code=?", groupParticipantInfoViewDTOMapper, email, gCode);
	}

}
