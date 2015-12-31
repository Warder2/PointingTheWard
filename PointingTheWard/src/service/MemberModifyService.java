package service;

import model.beans.Member;
import service.abstracts.AbstractMemberService;
import service.interfaces.MemberModifiable;

public class MemberModifyService extends AbstractMemberService implements MemberModifiable{

	@Override
	public void execute(ServiceRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean modifyMember(Member member, Member newMember) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyMemberEmail(String email, Member newMember) {
		// TODO Auto-generated method stub
		return false;
	}

}
