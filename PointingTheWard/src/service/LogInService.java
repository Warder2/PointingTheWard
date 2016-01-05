package service;

import model.beans.LoginInfo;
import persistance.dao.MemberDAO;
import persistance.dto.MemberPDTO;

public class LogInService implements Service{
	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public void execute(ServiceRequest request) {
		LoginInfo loginInfo = request.getObject("loginInfo");
		if(login(loginInfo)){
		}
	}
	
	private boolean login(LoginInfo loginInfo){
		MemberPDTO pdto = memberDAO.searchMemberP(loginInfo.getEmail());
		if(pdto.getPwd().equals(loginInfo.getPwd())){
			return true;
		}else{
			return false;
		}
	}
}

