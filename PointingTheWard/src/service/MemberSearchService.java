package service;

import java.util.ArrayList;
import java.util.List;

import model.beans.Member;
import persistance.dao.MemberDAO;
import persistance.dto.MemberDTO;
import service.abstracts.AbstractMemberService;
import service.interfaces.MemberSearchable;

public class MemberSearchService extends AbstractMemberService implements MemberSearchable{
	private MemberDAO memberDao;
	
	public void setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}
	
	@Override
	public void execute(ServiceRequest request) {
		String email = request.getObject("email");
		String name = request.getObject("name");
		
		if(email != null){
			Member member = searchMemberEmail(email);
			request.addObject("member", member);
		}else if(name != null){
			List<Member> members = searchMemberName(name);
			request.addObject("members", members);
		}else{
			throw new NullPointerException("email or name is null");
		}
	}

	@Override
	public Member searchMemberEmail(String email) {
		MemberDTO memberDTO = memberDao.searchMember(email);
		return new Member(memberDTO.getName(), memberDTO.getEmail(),
				memberDTO.getPwd(), memberDTO.getLocation(), memberDTO.getTransportation());
	}

	@Override
	public List<Member> searchMemberName(String name) {
		List<MemberDTO> memberDTOs = memberDao.searchMemberByName(name);
		List<Member> members = new ArrayList<Member>();
		for(MemberDTO memberDTO : memberDTOs){
			members.add(new Member(memberDTO.getName(), memberDTO.getEmail(),
					memberDTO.getPwd(), memberDTO.getLocation(), memberDTO.getTransportation()));
		}
		return members;
	}

}
