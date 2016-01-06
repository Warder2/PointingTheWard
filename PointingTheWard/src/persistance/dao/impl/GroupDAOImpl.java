package persistance.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

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
			groupParticipantInfoViewDTO.setGName(rs.getString("g_name"));
			groupParticipantInfoViewDTO.setOwner(rs.getString("owner"));
			groupParticipantInfoViewDTO.setEmail(rs.getString("email"));
			groupParticipantInfoViewDTO.setName(rs.getString("name"));
			groupParticipantInfoViewDTO.setLocation(rs.getString("location"));
			groupParticipantInfoViewDTO.setTransportation(rs.getString("transportation"));
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
		template.update("delete from group_view where g_code=?", gCode);
	}

	@Override
	public void deleteGroups(String owner) {
		template.update("delete from group_view where owner=?", owner);
	}

	@Override
	@Transactional
	public void deleteGroups(int... gCodes) {
		for(int gCode : gCodes){
			deleteGroup(gCode);
		}
	}

	@Override
	@Transactional
	public void deleteGroups(List<Integer> gCodes) {
		for(int gCode : gCodes){
			deleteGroup(gCode);
		}
	}

	@Override
	public void deleteGroupParticipant(int gCode, String email) {
		template.update("delete from g_participant_view where g_code=? and email=?", gCode, email);
	}

	@Override
	@Transactional
	public void deleteGroupParticipants(int gCode, String... emails) {
		for(String email : emails){
			deleteGroupParticipant(gCode, email);
		}
	}

	@Override
	public void deleteGroupParticipants(int gCode, List<String> emails) {
		for(String email : emails){
			deleteGroupParticipant(gCode, email);
		}
	}

	@Override
	public void modifyGroup(GroupDTO group) {
		modifyGroup(group.getCode(), group.getName());
	}

	@Override
	public void modifyGroup(int gCode, String name) {
		template.update("update group_view set name=? where g_code=?", name, gCode);
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
		return template.query("select * from group_view where name=? and owner=?", groupDTOMapper, name, owner);
	}

	@Override
	public GroupParticipantInfoDTO searchGroupParticipant(int gCode, String email) {
		return template.queryForObject("select * from g_participant_info_view where g_code=? and email=?", groupParticipantInfoViewDTOMapper, gCode, email);
	}

	@Override
	public List<GroupParticipantInfoDTO> searchGroupParticipants(int gCode) {
		return template.query("select * from g_participant_info_view where g_code=?", groupParticipantInfoViewDTOMapper, gCode);
	}

	@Override
	public void createGroup(String owner, String name) {
		template.update("insert into group_view(g_code, name, owner) values(group_sequence.nextval, ?, ?)", name, owner);
	}

	@Override
	public void createGroupParticipant(int gCode, String email) {
		template.update("insert into g_participant_view(g_code, email) values(?, ?)", gCode, email);
	}

	@Override
	@Transactional
	public void createGroupParticipants(int gCode, String... emails) {
		for(String email : emails){
			createGroupParticipant(gCode, email);
		}
	}

	@Override
	public void createGroupParticipant(int gCode, List<String> emails) {
		for(String email : emails){
			createGroupParticipant(gCode, email);
		}
	}

	@Override
	public void createGroupParticipant(int gCode, FriendDTO friend) {
		createGroupParticipant(gCode, friend.getFriendEmail());
	}

	@Override
	@Transactional
	public void createGroupParticipants(int gCode, FriendDTO... friends) {
		for(FriendDTO friend : friends){
			createGroupParticipant(gCode, friend);
		}
	}

	@Override
	public void createGroupParticipants(int gCode, List<FriendDTO> friends) {
		for(FriendDTO friend : friends){
			createGroupParticipant(gCode, friend);
		}
	}
	
}
