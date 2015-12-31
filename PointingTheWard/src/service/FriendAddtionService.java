package service;

import model.beans.Friend;
import service.abstracts.AbstractFriendService;
import service.interfaces.FriendInsertable;

public class FriendAddtionService extends AbstractFriendService implements FriendInsertable{

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
