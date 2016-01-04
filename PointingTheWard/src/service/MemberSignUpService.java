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
		// TODO Auto-generated method stub
		Member member = request.getObject("memberInfo");
		if (member != null) {
			SignUp(member);
		}
	}

	@Override
	public void SignUp(Member member) {
		// TODO Auto-generated method stub
		System.out.println(member);
	}

	@Override
	public void SignUp(String email, String name, String pwd, String location, Transportation transportation) {
		memberDao.signUpMember(new MemberDTO(email, name, pwd, location, transportation));
	}

}
