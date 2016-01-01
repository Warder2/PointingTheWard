package persistance.dao.Interfaces;

import model.beans.Transportation;
import persistance.dto.MemberDTO;
import persistance.viewdto.MemberOViewDTO;

public interface MemberModifyDAO {
	//modify member(pwd)
	void modifyMemberPwd(String email, String pwd);
	//modify member(name, location, transportation)
	void modifyMemberOp(MemberOViewDTO member);
	void modifyMemberOp(String email, String name, String location, Transportation transportation);
	//modify member
	void modifyMember(MemberDTO member);
	void modifyMember(String email, String pwd, String name, String location, Transportation transportation);
	//modify member(location)
	void modifyMemberLocation(String email, String location);
}
