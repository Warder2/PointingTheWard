package service;

import model.beans.SignInInfo;
import persistance.dao.MemberDAO;
import service.abstracts.AbstractMemberService;
import service.interfaces.MemberSignInable;
import validation.exception.PwdMisMatchedException;

public class MemberSignInService extends AbstractMemberService implements MemberSignInable{
	private MemberDAO memberDao;
	
	public void setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}
	
	@Override
	public void execute(ServiceRequest request) {
		SignInInfo signInInfo = request.getObject("signInInfo");
		if(signInInfo != null){
			signIn(signInInfo.getEmail(), signInInfo.getPwd());
		}else{
			throw new NullPointerException("sign in info is null");
		}
	}

	@Override
	public void signIn(String email, String pwd) {
		if(!memberDao.searchMemberP(email).getPwd().equals(pwd)){
			throw new PwdMisMatchedException(pwd);
		}
	}

}
