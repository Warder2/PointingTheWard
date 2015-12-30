package model.interfaces;

import java.util.List;

import model.beans.Member;

public interface MemberSearchable {
	public Member searchMember(Member member);
	public Member searchMemberEmail(String email);
	public List<Member> searchMemberName(String name);
}
