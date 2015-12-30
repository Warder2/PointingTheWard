package model.Abstract;

import model.ListVO.MemberList;
import model.interfaces.MemberDropoutable;
import model.interfaces.MemberModifiable;
import model.interfaces.MemberSearchable;
import model.interfaces.MemberSignInable;
import model.interfaces.MemberSignUpable;

public abstract class AbstractMemberService implements MemberSignInable,MemberSignUpable,MemberSearchable,MemberModifiable,MemberDropoutable{
	private static MemberList members;
	static{
		AbstractMemberService.members = new MemberList();
	}
	public static synchronized MemberList getMembers() {
		return members;
	}
	public static void setMembers(MemberList members) {
		AbstractMemberService.members = members;
	}
}
