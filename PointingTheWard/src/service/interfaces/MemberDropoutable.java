package service.interfaces;

import model.beans.Member;

public interface MemberDropoutable {
	public boolean removeMember(Member member);
	public boolean removeMemberEmail(String email);
	public int removeMemberName(String name);
}
