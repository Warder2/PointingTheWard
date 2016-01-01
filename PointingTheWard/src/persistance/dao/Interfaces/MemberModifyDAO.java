package persistance.dao.Interfaces;

import model.beans.Member;

public interface MemberModifyDAO {
	//modify member(pwd)
	void modifyMember(String email, String pwd);
	//modify member(name, location, transportation)
	void modifyMemberOp(Member member);
	void modifyMember(String email, String name, String location, String transportation);
	//modify member
	void modifyMember(Member member);
	void modifyMember(String email, String pwd, String name, String location, String transportation);
	//modify member(location)
	void modifyMemberLocation(String email, String location);
}
