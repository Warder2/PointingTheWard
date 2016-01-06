package service;

import persistance.dao.FriendDAO;
import service.abstracts.AbstractFriendService;
import service.interfaces.FriendAddible;

public class FriendAddtionService extends AbstractFriendService implements FriendAddible{
	private FriendDAO friendDao;
	
	public void setFriendDao(FriendDAO friendDao) {
		this.friendDao = friendDao;
	}
	
	@Override
	public void execute(ServiceRequest request) {
		String email = request.getObject("email");
		String fEmail = request.getObject("fEmail");
		if(email == null || fEmail == null){
			throw new NullPointerException("email or friend email is null");
		}else{
			addFriend(email, fEmail);
		}
	}
	@Override
	public void addFriend(String email, String fEmail) {
		friendDao.addtionFriend(email, fEmail);
	}
}
