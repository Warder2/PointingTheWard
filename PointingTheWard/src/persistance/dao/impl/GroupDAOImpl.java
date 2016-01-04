package persistance.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import persistance.dao.GroupDAO;
import persistance.dto.FriendDTO;
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
			groupDTO.setOwner(rs.getString("owner"));
			return groupDTO;
		}
	};
	private RowMapper<GroupParticipantInfoDTO> groupParticipantInfoViewDTOMapper = new RowMapper<GroupParticipantInfoDTO>() {
		
		@Override
		public GroupParticipantInfoDTO mapRow(ResultSet rs, int index) throws SQLException {
			GroupParticipantInfoDTO groupParticipantInfoViewDTO = new GroupParticipantInfoDTO();
			groupParticipantInfoViewDTO.setGCode(rs.getInt("g_code"));
			groupParticipantInfoViewDTO.setEmail(rs.getString("email"));
			groupParticipantInfoViewDTO.setGName(rs.getString("name"));
			groupParticipantInfoViewDTO.setLocation(rs.getString("location"));
			groupParticipantInfoViewDTO.setTransportation(rs.getString("transportation"));
			groupParticipantInfoViewDTO.setOwner(rs.getString("owner"));
			return groupParticipantInfoViewDTO;
		}
	};
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public void deleteGroupAll() {
		template.update("delete from g_participant_view");
		template.update("delete from group_view");
	}

	@Override
	public void deleteGroup(int gCode) {
		
	}

	@Override
	public void deleteGroups(String owner) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGroups(int... gCodes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGroups(List<Integer> gCodes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGroups(String owner, int... gCodes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGroups(String owner, List<Integer> gCodes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGroupParticipant(int gCode, String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGroupParticipants(int gCode, String... emails) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGroupParticipants(int gCode, List<String> emails) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyGroup(GroupDTO group) {
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
	public void addFriend(int gCode, FriendDTO friend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFriends(int gCode, FriendDTO... friends) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFriends(int gCode, List<FriendDTO> friends) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<GroupDTO> searchGroupAll() {
		return template.query("select * from group_view", groupDTOMapper);
	}

	@Override
	public List<GroupDTO> searchGroup(String owner) {
		return template.query("select * from group_view where owner=?", groupDTOMapper, owner);
	}

	@Override
	public GroupDTO searchGroup(int gCode) {
		return template.queryForObject("select * from group_view where g_code=?", groupDTOMapper, gCode);
	}

	@Override
	public List<GroupDTO> searchGroupByName(String name, String owner) {
		return template.query("select * from group_view name=? and owner=?", groupDTOMapper, name, owner);
	}

	@Override
	public GroupParticipantInfoDTO searchGroupParticipant(int gCode, String email) {
		return template.queryForObject("select * from g_participant_info_view where g_code=? and email=?", groupParticipantInfoViewDTOMapper, gCode, email);
	}

	@Override
	public List<GroupParticipantInfoDTO> searchGroupParticipants(int gCode) {
		return template.query("select * from g_participant_info_view where g_code", groupParticipantInfoViewDTOMapper, gCode);
	}

	@Override
	public void createGroup(String owner, String name) {
		template.update("insert into group_view(g_code, name, owner) values(group_sequence.nextval, ?, ?)", name, owner);
	}
	
}
