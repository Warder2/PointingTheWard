package service.interfaces;

import model.beans.Member;
import model.beans.Transportation;

public interface MemberSignUpable {
	public void SignUp(Member member);
	public void SignUp(String email,String name,String pwd,String location,Transportation transportation);
}
