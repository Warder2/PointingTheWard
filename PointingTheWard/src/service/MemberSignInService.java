package service;

import service.abstracts.AbstractMemberService;
import service.interfaces.MemberSignInable;

public class MemberSignInService extends AbstractMemberService implements MemberSignInable{

	@Override
	public void execute(ServiceRequest request) {
		// TODO Auto-generated method stub
		
		signIn(request.getObject("id"), request.getObject("pw"));
	}

	@Override
	public boolean signIn(String email, String pwd) {
		// TODO Auto-generated method stub
		System.out.println("email : " + email);
		System.out.println("pw : " + pwd);
		
		return false;
	}

}
