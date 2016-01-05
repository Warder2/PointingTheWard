package service;

import model.beans.SignInInfo;
import persistance.dao.MemberDAO;
import persistance.dto.MemberPDTO;

public class LogInService implements Service{
	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public void execute(ServiceRequest request) {
		SignInInfo loginInfo = request.getObject("loginInfo");
		if(login(loginInfo)){
		}
	}
	
	private boolean login(SignInInfo loginInfo){
		MemberPDTO pdto = memberDAO.searchMemberP(loginInfo.getEmail());
		if(pdto.getPwd().equals(loginInfo.getPwd())){
			return true;
		}else{
			return false;
		}
	}
}

