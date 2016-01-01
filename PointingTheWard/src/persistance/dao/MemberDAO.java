package persistance.dao;

import persistance.dao.Interfaces.MemberDropoutDAO;
import persistance.dao.Interfaces.MemberModifyDAO;
import persistance.dao.Interfaces.MemberSearchDAO;
import persistance.dao.Interfaces.MemberSignInDAO;
import persistance.dao.Interfaces.MemberSignUpDAO;

public interface MemberDAO extends MemberDropoutDAO,MemberModifyDAO,MemberSearchDAO,MemberSignUpDAO{

}
