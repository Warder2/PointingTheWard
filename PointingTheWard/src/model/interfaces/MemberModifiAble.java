package model.interfaces;

import model.beans.Member;

public interface MemberModifiAble {
	public boolean modifyMember(Member member, Member newMember);
	public boolean modifyMemberEmail(String email, Member newMember);
}
