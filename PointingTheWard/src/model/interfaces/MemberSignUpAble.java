package model.interfaces;

import model.beans.Member;

public interface MemberSignUpAble {
	public boolean SingUp(Member member);
	public boolean SingUp(String email,String name,String pwd,String location,String transportation);
}
