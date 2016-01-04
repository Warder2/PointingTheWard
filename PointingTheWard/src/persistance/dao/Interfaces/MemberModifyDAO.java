package persistance.dao.Interfaces;

import model.beans.Transportation;
import persistance.dto.MemberDTO;
import persistance.dto.MemberODTO;

public interface MemberModifyDAO {
	//modify member(pwd)
	void modifyMemberPwd(String email, String pwd);
	//modify member(name, location, transportation)
	void modifyMemberOp(MemberODTO member);
	void modifyMemberOp(String email, String name, String location, Transportation transportation);
	//modify member
	void modifyMember(MemberDTO member);
	void modifyMember(String email, String pwd, String name, String location, Transportation transportation);
	//modify member(location)
	void modifyMemberLocation(String email, String location);
	//modify transportation
	void modifyTransportation(String email, Transportation transportation);
}
