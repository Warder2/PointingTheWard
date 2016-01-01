package persistance.dao.Interfaces;

import java.util.List;

import model.beans.Transportation;
import persistance.dto.MemberDTO;

public interface MemberSignUpDAO {
	//sign up member
	void signUpMember(MemberDTO member);
	void signUpMember(String email, String name, String pwd, String location, Transportation transportation);
	//sign up members
	void signUpMembers(MemberDTO... members);
	void signUpMembers(List<MemberDTO> members);
}
