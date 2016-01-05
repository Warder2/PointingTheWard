package service;

import model.beans.Member;
import model.beans.Transportation;
import persistance.dao.MemberDAO;
import persistance.dto.MemberDTO;
import service.abstracts.AbstractMemberService;
import service.interfaces.MemberSignUpable;

public class MemberSignUpService extends AbstractMemberService implements MemberSignUpable {
	private MemberDAO memberDao;

	public void setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public void execute(ServiceRequest request) {
		Member member = request.getObject("memberInfo");
		if (member != null) {
			signUp(member);
		}else{
			throw new NullPointerException("member info is null");
		}
	}

	@Override
	public void signUp(Member member) {
		signUp(member.getEmail(), member.getName(), member.getPwd(), member.getLocation(), member.getTransportation());
	}

	@Override
	public void signUp(String email, String name, String pwd, String location, Transportation transportation) {
		memberDao.signUpMember(new MemberDTO(email, name, pwd, location, transportation));
	}

}
