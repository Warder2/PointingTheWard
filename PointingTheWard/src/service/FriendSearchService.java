package service;

import java.util.List;

import model.beans.Friend;
import service.abstracts.AbstractFriendService;
import service.interfaces.FriendSearchable;

public class FriendSearchService extends AbstractFriendService implements FriendSearchable{

	@Override
	public void execute(ServiceRequest request) {
		// TODO Auto-generated method stub
		System.out.println("FriendSearchService test : " + request.getObject("test"));
	}

	@Override
	public Friend searchFriend(Friend friend) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Friend searchFriendEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Friend> searchFriendName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
