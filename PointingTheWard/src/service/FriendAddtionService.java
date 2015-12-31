package service;

import model.beans.Friend;
import service.abstracts.AbstractFriendService;
import service.interfaces.FriendAddible;

public class FriendAddtionService extends AbstractFriendService implements FriendAddible{

	@Override
	public void execute(ServiceRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addFriend(Friend friend) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addFriend(int index, Friend friend) {
		// TODO Auto-generated method stub
		return false;
	}

}
