package persistance.dao.Interfaces;

import java.util.List;

import model.beans.Member;

public interface MemberSearchDAO {
	//search all
	List<Member> searchAll();
	//search member
	Member searchMember(String email);
	//search members
	List<Member> searchMembers(String... emails);
	//search member by name
	List<Member> searchMemberByName(String name);
}
