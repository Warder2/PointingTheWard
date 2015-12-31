package service.interfaces;

import model.beans.Member;

public interface MemberModifiable {
	public boolean modifyMember(Member member, Member newMember);
	public boolean modifyMemberEmail(String email, Member newMember);
}
