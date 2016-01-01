package persistance.dao.Interfaces;

public interface MemberDropoutDAO {
	//drop all
	void dropOutAll();
	//drop user
	void dropOutMember(String email);
	//drop users
	void dropOutMember(String... emails);
}
