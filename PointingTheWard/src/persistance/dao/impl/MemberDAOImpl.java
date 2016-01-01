package persistance.dao.impl;

import java.util.List;

import model.beans.Transportation;
import persistance.dao.MemberDAO;
import persistance.dto.MemberDTO;
import persistance.viewdto.MemberOViewDTO;

public class MemberDAOImpl implements MemberDAO{

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
	public void modifyMemberOp(MemberOViewDTO member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyMember(String email, String name, String location, Transportation transportation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyMember(MemberDTO member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyMember(String email, String pwd, String name, String location, Transportation transportation) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void signUpMember(String email, String name, String pwd, String location, Transportation transportation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void signUpMembers(MemberDTO... members) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void signUpMembers(List<MemberDTO> members) {
		// TODO Auto-generated method stub
		
	}

}
