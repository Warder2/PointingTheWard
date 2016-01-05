package service.interfaces;

import model.beans.Member;
import model.beans.Transportation;

public interface MemberSignUpable {
	public void signUp(Member member);
	public void signUp(String email,String name,String pwd,String location,Transportation transportation);
}
