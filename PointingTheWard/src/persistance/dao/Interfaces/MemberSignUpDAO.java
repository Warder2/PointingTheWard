package persistance.dao.Interfaces;

import java.util.List;

import model.beans.Member;
import model.beans.Transportation;

public interface MemberSignUpDAO {
	//sign up member
	void signUpMember(Member member);
	void signUpMember(String email, String name, String pwd, String location, Transportation transportation);
	//sign up members
	void signUpMembers(Member... members);
	void signUpMembers(List<Member> members);
}
