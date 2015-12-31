package service;

import service.abstracts.AbstractFriendService;
import service.interfaces.FriendDelible;

public class FriendDeleteService extends AbstractFriendService implements FriendDelible{

	@Override
	public void execute(ServiceRequest request) {
		// TODO Auto-generated method stub
		System.out.println("FriendDeleteService test : " + request.getObject("test"));
		deleteFriendEmail(request.getObject("email"));
	}

	@Override
	public boolean deleteFriendEmail(String email) {
		// TODO Auto-generated method stub
		System.out.println("deleteFriendEmail email : " + email);
		return false;
	}

	@Override
	public int deleteFriendName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

}
