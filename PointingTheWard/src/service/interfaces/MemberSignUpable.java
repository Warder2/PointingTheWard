package service.interfaces;

import model.beans.Member;

public interface MemberSignUpable {
	public boolean SignUp(Member member);
	public boolean SignUp(String email,String name,String pwd,String location,String transportation);
}
