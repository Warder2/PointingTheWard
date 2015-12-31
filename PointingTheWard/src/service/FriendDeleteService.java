package service;

import service.abstracts.AbstractFriendService;
import service.interfaces.FriendDelible;

public class FriendDeleteService extends AbstractFriendService implements FriendDelible{

	@Override
	public void execute(ServiceRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteFriendEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deleteFriendName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

}
