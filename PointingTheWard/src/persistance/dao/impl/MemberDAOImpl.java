package persistance.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import model.beans.Transportation;
import persistance.dao.MemberDAO;
import persistance.dto.MemberDTO;
import persistance.viewdto.MemberOViewDTO;

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
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public void dropOutAll() {
		template.update("delete from member_view");
	}

	@Override
	public void dropOutMember(String email) {
		template.update("delete from member_view where email='?'", email);
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
		template.update("update member_p_view set pwd='?' where email='?'",  pwd, email);
	}

	@Override
	public void modifyMemberOp(MemberOViewDTO member) {
		modifyMemberOp(member.getEmail(), member.getName(), member.getLocation(), member.getTransportation());
	}

	@Override
	public void modifyMemberOp(String email, String name, String location, Transportation transportation) {
		template.update("update member_view set name='?', location='?', transportation='?' where email='?'",
				name, location, transportation.getStr(), email);
	}

	@Override
	public void modifyMember(MemberDTO member) {
		
	}

	@Override
	public void modifyMember(String email, String pwd, String name, String location, Transportation transportation) {
		
	}

	@Override
	public void modifyMemberLocation(String email, String location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MemberDTO> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDTO searchMember(String email) {
		Object[] args = new Object[]{email};
		return template.queryForObject("select * from member_view where email=?", args, memberDTOMapper);
	}

	@Override
	public List<MemberDTO> searchMembers(String... emails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberDTO> searchMembers(List<String> emails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberDTO> searchMemberByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberOViewDTO> searchMemberOpAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberOViewDTO searchMemberOp(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberOViewDTO> searchMemberOps(String... emails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberOViewDTO> searchMemberOps(List<String> emails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberOViewDTO> searchMemberOpByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void signUpMember(MemberDTO member) {
		signUpMember(member.getEmail(), member.getName(), member.getPwd(), member.getLocation(), member.getTransportaion());
	}

	@Override
	public void signUpMember(String email, String name, String pwd, String location, Transportation transportation) {
		template.update("insert into member_view(email, name, pwd, location, transportation) values('?', '?', '?', '?', '?')", email, name, pwd, location, transportation);
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
