package service;

import model.beans.Member;
import service.abstracts.AbstractMemberService;
import service.interfaces.MemberSignUpable;

public class MemberSignUpService extends AbstractMemberService implements MemberSignUpable{

	@Override
	public void execute(ServiceRequest request) {
		// TODO Auto-generated method stub
		Member member = request.getObject("memberInfo");
		if(member != null){
			SignUp(member);
		}
	}

	@Override
	public boolean SignUp(Member member) {
		// TODO Auto-generated method stub
		System.out.println(member);
		return false;
	}

	@Override
	public boolean SignUp(String email, String name, String pwd, String location, String transportation) {
		// TODO Auto-generated method stub
		return false;
	}


}
