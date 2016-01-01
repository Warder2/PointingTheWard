package persistance.dao.Interfaces;

import java.util.List;

import model.beans.Member;
import persistance.dto.MemberDTO;
import persistance.viewdto.MemberOViewDTO;

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
	List<MemberOViewDTO> searchMemberOpAll();
	MemberOViewDTO searchMemberOp(String email);
	List<MemberOViewDTO> searchMemberOps(String... emails);
	List<MemberOViewDTO> searchMemberOps(List<String> emails);
	List<MemberOViewDTO> searchMemberOpByName(String name);
}
