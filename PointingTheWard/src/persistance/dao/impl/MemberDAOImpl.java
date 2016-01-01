package persistance.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import model.beans.Member;
import model.beans.Transportation;
import persistance.dao.MemberDAO;

public class MemberDAOImpl implements MemberDAO{
	private JdbcTemplate template;
	private	RowMapper<Member> mapper = new RowMapper<Member>() {
		
		@Override
		public Member mapRow(ResultSet rs, int index) throws SQLException {
			Member member = new Member();
			member.setEmail(rs.getString("email"));
			return member;
		}
	};
	public void setTemplate(JdbcTemplate template){
		this.template = template;
	}
	
	@Override
	public void dropOutAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropOutMember(String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropOutMember(String... emails) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyMember(String email, String pwd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyMemberOp(Member member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyMember(String email, String name, String location, String transportation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyMember(Member member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyMember(String email, String pwd, String name, String location, String transportation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyMemberLocation(String email, String location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Member> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member searchMember(String email) {
		Object[] args = {email};
		return (Member) template.query("sql", args, mapper);
	}

	@Override
	public List<Member> searchMembers(String... emails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> searchMemberByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void signUpMember(Member member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void signUpMember(String email, String name, String pwd, String location, Transportation transportation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void signUpMembers(Member... members) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void signUpMembers(List<Member> members) {
		// TODO Auto-generated method stub
		
	}

}
