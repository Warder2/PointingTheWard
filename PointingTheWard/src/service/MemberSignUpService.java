package service;

import model.beans.Member;
import service.abstracts.AbstractMemberService;
import service.interfaces.MemberSignUpable;

public class MemberSignUpService extends AbstractMemberService implements MemberSignUpable{

	@Override
	public void execute(ServiceRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean SingUp(Member member) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean SingUp(String email, String name, String pwd, String location, String transportation) {
		// TODO Auto-generated method stub
		return false;
	}

}
