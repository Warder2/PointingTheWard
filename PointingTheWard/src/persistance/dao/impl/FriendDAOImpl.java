package persistance.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import persistance.dao.FriendDAO;
import persistance.dto.FriendDTO;
import persistance.dto.FriendInfoDTO;

public class FriendDAOImpl implements FriendDAO {
	private JdbcTemplate template;
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public RowMapper<FriendDTO> FriendDTOMapper = new RowMapper<FriendDTO>() {

		@Override
		public FriendDTO mapRow(ResultSet rs, int rowNumber) throws SQLException {
			// TODO Auto-generated method stub
			FriendDTO FriendDTO = new FriendDTO();
			FriendDTO.setEmail(rs.getString("email"));
			FriendDTO.setFriendEmail(rs.getString("f_email"));
			
			return FriendDTO;
		}	
	};
	public RowMapper<FriendInfoDTO> friendInfoViewDTOMapper = new RowMapper<FriendInfoDTO>() {

		@Override
		public FriendInfoDTO mapRow(ResultSet rs, int rowNumber) throws SQLException {
			// TODO Auto-generated method stub
			FriendInfoDTO friendInfoViewDTO = new FriendInfoDTO();
			friendInfoViewDTO.setEmail(rs.getString("email"));
			friendInfoViewDTO.setfEmail(rs.getString("f_email"));
			friendInfoViewDTO.setfName(rs.getString("f_name"));
			friendInfoViewDTO.setfLocation(rs.getString("f_location"));
			friendInfoViewDTO.setfTransportation(rs.getString("f_transportation"));
			return friendInfoViewDTO;
		}
	};

	@Override
	public void addtionFriend(String email, String friendEmail) {
		// TODO Auto-generated method stub
		String insertFriendSql="insert into friend_view(email, f_email) values(?, ?)";
		template.update(insertFriendSql, email, friendEmail);
		
	}

	@Override
	public void addtionFriends(String email, String... friendEmails) {
		// TODO Auto-generated method stub
		for(String friendEmail : friendEmails){
			addtionFriend(email, friendEmail);
		}		
	}

	@Override
	@Transactional
	public void addtionFriends(String email, List<String> friendEmails) {
		// TODO Auto-generated method stub
		for(String friendEmail : friendEmails){
			addtionFriend(email, friendEmail);
		}
	}

	@Override
	public void deleteFriendAll(String email) {
		template.update("delete from friend_view where email=?", email);
	}

	@Override
	public void deleteFriendEmail(String email, String friendEmail) {
		template.update("delete from friend_view where email=? and f_email=?", email,friendEmail);
	}

	@Override
	@Transactional	//트랜젝션이 이루어져야 하니까 추가
	public void deleteFriends(String email, List<String> friendEmails) {
		// TODO Auto-generated method stub
		for(String friendEmail: friendEmails){
			deleteFriendEmail(email, friendEmail);
		}		
	}

	@Override
	@Transactional
	public void deleteFriends(String email, String... friendEmails) {
		// TODO Auto-generated method stub
		for(String friendEmail: friendEmails){
			deleteFriendEmail(email, friendEmail);
		}	
	}

	@Override
	public List<FriendDTO> searchFriendAll() {
		// TODO Auto-generated method stub
		String searchSql="select * from friend_view";
		return template.query(searchSql, FriendDTOMapper);
		
	}

	@Override
	public List<FriendDTO> searchFriends(String email) {
		// TODO Auto-generated method stub
		String searchSql="select * from friend_view where email=?";
		//List<FriendDTO> FriendDTOs = new ArrayList<FriendDTO>();
		return template.query(searchSql, FriendDTOMapper, email);
	}

	@Override
	public List<FriendInfoDTO> searchFriendsInfoAll() {
		return template.query("select * from friend_info_view", friendInfoViewDTOMapper);
	}

	@Override
	public List<FriendInfoDTO> searchFriendsInfoEmail(String email) {
		return template.query("select * from friend_info_view where email=?", friendInfoViewDTOMapper, email);
	}

	@Override
	public FriendInfoDTO searchFriendInfoEmail(String email, String friendEmail) {
		// TODO Auto-generated method stub
		String searchSql = "select * from friend_info_view where email=? and f_email=?";
		
		return template.queryForObject(searchSql, friendInfoViewDTOMapper,email,friendEmail);
	}
}
