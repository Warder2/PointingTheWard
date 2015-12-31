package service;

import model.beans.Friend;
import service.abstracts.AbstractFriendService;
import service.interfaces.FriendModifiable;

public class FriendModifyService extends AbstractFriendService implements FriendModifiable{

	@Override
	public void execute(ServiceRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean modifyFriend(Friend friend, Friend newFriend) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyFriend(String email, Friend newFriend) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyFriendEmail(String email, String newMail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyFriendName(String email, String name) {
		// TODO Auto-generated method stub
		return false;
	}

}
