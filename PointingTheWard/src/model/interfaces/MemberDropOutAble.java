package model.interfaces;

import model.beans.Member;

public interface MemberDropOutAble {
	public boolean removeMember(Member member);
	public boolean removeMemberEmail(String email);
	public int removeMemberName(String name);
}
