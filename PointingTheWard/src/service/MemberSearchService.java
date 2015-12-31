package service;

import java.util.List;

import model.beans.Member;
import service.abstracts.AbstractMemberService;
import service.interfaces.MemberSearchable;

public class MemberSearchService extends AbstractMemberService implements MemberSearchable{

	@Override
	public void execute(ServiceRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Member searchMember(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member searchMemberEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> searchMemberName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
