package persistance.dao.Interfaces;

import java.util.List;

import model.beans.Member;
import persistance.dto.MemberDTO;
import persistance.dto.MemberODTO;

public interface MemberSearchDAO {
	//search all
	List<MemberDTO> searchAll();
	//search member
	MemberDTO searchMember(String email);
	//search members
	List<MemberDTO> searchMembers(String... emails);
	List<MemberDTO> searchMembers(List<String> emails);
	//search member by name
	List<MemberDTO> searchMemberByName(String name);
	
	//search memberOp
	List<MemberODTO> searchMemberOpAll();
	MemberODTO searchMemberOp(String email);
	List<MemberODTO> searchMemberOps(String... emails);
	List<MemberODTO> searchMemberOps(List<String> emails);
	List<MemberODTO> searchMemberOpByName(String name);
}
