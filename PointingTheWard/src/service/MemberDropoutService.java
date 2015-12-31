package service;

import model.beans.Member;
import service.abstracts.AbstractMemberService;
import service.interfaces.MemberDropoutable;

public class MemberDropoutService extends AbstractMemberService implements MemberDropoutable{

	@Override
	public void execute(ServiceRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean removeMember(Member member) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeMemberEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int removeMemberName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

}
