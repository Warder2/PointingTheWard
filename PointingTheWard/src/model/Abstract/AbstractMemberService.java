package model.Abstract;

import model.ListVO.MemberList;
import model.interfaces.MemberDropOutAble;
import model.interfaces.MemberModifiAble;
import model.interfaces.MemberSearchAble;
import model.interfaces.MemberSignInAble;
import model.interfaces.MemberSignUpAble;

public abstract class AbstractMemberService implements MemberSignInAble,MemberSignUpAble,MemberSearchAble,MemberModifiAble,MemberDropOutAble{
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
