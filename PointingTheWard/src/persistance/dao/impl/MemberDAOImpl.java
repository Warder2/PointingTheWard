package persistance.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import model.beans.Transportation;
import persistance.dao.MemberDAO;
import persistance.dto.MemberDTO;
import persistance.dto.MemberODTO;
import persistance.dto.MemberPDTO;

public class MemberDAOImpl implements MemberDAO{
	private JdbcTemplate template;
	private RowMapper<MemberDTO> memberDTOMapper = new RowMapper<MemberDTO>() {
		@Override
		public MemberDTO mapRow(ResultSet rs, int index) throws SQLException {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setEmail(rs.getString("email"));
			memberDTO.setName(rs.getString("name"));
			memberDTO.setPwd(rs.getString("pwd"));
			memberDTO.setLocation(rs.getString("location"));
			memberDTO.setTransportaion(Transportation.valueOfByStr(rs.getString("transportation")));
			return memberDTO;
		}
	};
	
	private RowMapper<MemberODTO> memberOViewDTOMapper = new RowMapper<MemberODTO>() {
		
		@Override
		public MemberODTO mapRow(ResultSet rs, int index) throws SQLException {
			MemberODTO memberOViewDTO = new MemberODTO();
			memberOViewDTO.setEmail(rs.getString("email"));
			memberOViewDTO.setName(rs.getString("name"));
			memberOViewDTO.setLocation(rs.getString("location"));
			memberOViewDTO.setTransportation(Transportation.valueOfByStr(rs.getString("transportation")));
			return memberOViewDTO;
		}
	};
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public void dropOutAll() {
		template.update("delete from member_view");
	}

	@Override
	public void dropOutMember(String email) {
		template.update("delete from member_view where email=?", email);
	}

	@Override
	@Transactional
	public void dropOutMembers(String... emails) {
		for(String email : emails){
			dropOutMember(email);
		}
	}

	@Override
	public void modifyMemberPwd(String email, String pwd) {
		template.update("update member_view set pwd=? where email=?",  pwd, email);
	}

	@Override
	public void modifyMemberOp(MemberODTO member) {
		modifyMemberOp(member.getEmail(), member.getName(), member.getLocation(), member.getTransportation());
	}

	@Override
	public void modifyMemberOp(String email, String name, String location, Transportation transportation) {
		template.update("update member_view set name=?, location=?, transportation=? where email=?",
				name, location, transportation.getStr(), email);
	}

	@Override
	public void modifyMember(MemberDTO member) {
		modifyMember(member.getEmail(), member.getPwd(), member.getName(), member.getLocation(), member.getTransportaion());
	}

	@Override
	public void modifyMember(String email, String pwd, String name, String location, Transportation transportation) {
		template.update("update member_view set name=?, pwd=?, location =?, transportation=? where email=?",
				name, pwd, location, transportation.getStr(), email);
	}

	@Override
	public void modifyMemberLocation(String email, String location) {
		template.update("update member_view set location=? where email=?", location, email);
	}
	
	@Override
	public void modifyTransportation(String email, Transportation transportation) {
		template.update("update member_view set transportation=? where email=?", transportation.getStr(), email);
	}

	@Override
	public List<MemberDTO> searchAll() {
		return template.query("select * from member_view", memberDTOMapper);
	}

	@Override
	public MemberDTO searchMember(String email) {
		return template.queryForObject("select * from member_view where email=?", memberDTOMapper, email);
	}

	@Override
	@Transactional
	public List<MemberDTO> searchMembers(String... emails) {
		List<MemberDTO> memberDTOs = new ArrayList<MemberDTO>();
		for(String email : emails){
			memberDTOs.add(searchMember(email));
		}
		return memberDTOs;
	}

	@Override
	public List<MemberDTO> searchMembers(List<String> emails) {
		List<MemberDTO> memberDTOs = new ArrayList<MemberDTO>();
		for(String email : emails){
			memberDTOs.add(searchMember(email));
		}
		return memberDTOs;
	}

	@Override
	public List<MemberDTO> searchMemberByName(String name) {
		return template.query("select * from member_view where name=?", memberDTOMapper, name);
	}

	@Override
	public List<MemberODTO> searchMemberOpAll() {
		return template.query("select * from member_o_view", memberOViewDTOMapper);
	}

	@Override
	public MemberODTO searchMemberOp(String email) {
		return template.queryForObject("select * from member_o_view where email=?", memberOViewDTOMapper, email);
	}

	@Override
	@Transactional
	public List<MemberODTO> searchMemberOps(String... emails) {
		List<MemberODTO> oViewDTOs = new ArrayList<MemberODTO>();
		for(String email : emails){
			oViewDTOs.add(searchMemberOp(email));
		}
		return oViewDTOs;
	}

	@Override
	public List<MemberODTO> searchMemberOps(List<String> emails) {
		List<MemberODTO> oViewDTOs = new ArrayList<MemberODTO>();
		for(String email : emails){
			oViewDTOs.add(searchMemberOp(email));
		}
		return oViewDTOs;
	}

	@Override
	public List<MemberODTO> searchMemberOpByName(String name) {
		return template.query("select * from member_o_view where name=?", memberOViewDTOMapper, name);
	}
	
	@Override
	public MemberPDTO searchMemberP(String email) {
		return template.queryForObject("select * from member_p_view where email=?", new RowMapper<MemberPDTO>(){
			@Override
			public MemberPDTO mapRow(ResultSet rs, int index) throws SQLException {
				MemberPDTO memberPDTO = new MemberPDTO();
				memberPDTO.setEmail(rs.getString("email"));
				memberPDTO.setPwd(rs.getString("pwd"));
				memberPDTO.setName(rs.getString("name"));
				return memberPDTO;
			}
		}, email);
	}

	@Override
	public void signUpMember(MemberDTO member) {
		signUpMember(member.getEmail(), member.getName(), member.getPwd(), member.getLocation(), member.getTransportaion());
	}

	@Override
	public void signUpMember(String email, String name, String pwd, String location, Transportation transportation) {
		template.update("insert into member_view(email, name, pwd, location, transportation) values(?,?,?,?,?)", email, name, pwd, location, transportation.getStr());
	}

	@Override
	@Transactional
	public void signUpMembers(MemberDTO... members) {
		for(MemberDTO member : members){
			signUpMember(member);
		}
	}

	@Override
	@Transactional
	public void signUpMembers(List<MemberDTO> members) {
		for(MemberDTO member : members){
			signUpMember(member);
		}
	}

}
