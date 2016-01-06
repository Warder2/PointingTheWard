package service;

import java.util.ArrayList;
import java.util.List;

import model.beans.Friend;
import persistance.dao.FriendDAO;
import persistance.dto.FriendInfoDTO;
import service.abstracts.AbstractFriendService;
import service.interfaces.FriendSearchable;

public class FriendSearchService extends AbstractFriendService implements FriendSearchable{
	private FriendDAO friendDao;
	
	public void setFriendDao(FriendDAO friendDao) {
		this.friendDao = friendDao;
	}
	
	@Override
	public void execute(ServiceRequest request) {
		String email = request.getObject("email");
		String fEmail = request.getObject("fEmail");
		String fName = request.getObject("fName");
		
		if(email != null){
			if(fEmail != null){
				Friend friend = searchFriend(email, fEmail);
				request.addObject("friend", friend);
			}else if(fName != null){
				List<Friend> friends = searchFriendName(email, fName);
				request.addObject("friends", friends);
			}else{
				List<Friend> friends = searchFriends(email);
				request.addObject("friends", friends);
			}
		}
	}
	
	@Override
	public Friend searchFriend(String email, String fEmail){
		FriendInfoDTO friendInfoDTO = friendDao.searchFriendInfoEmail(email, fEmail);
		return new Friend(friendInfoDTO.getfName(), friendInfoDTO.getfEmail());
	}

	@Override
	public List<Friend> searchFriends(String email) {
		List<FriendInfoDTO> friendInfoDTOs = friendDao.searchFriendsInfoEmail(email);
		List<Friend> friends = new ArrayList<Friend>();
		for(FriendInfoDTO friendInfoDTO : friendInfoDTOs){
			friends.add(new Friend(friendInfoDTO.getfName(), friendInfoDTO.getfEmail()));
		}
		return friends;
	}
	
	@Override
	public List<Friend> searchFriendName(String email, String fName) {
		List<FriendInfoDTO> friendInfoDTOs = friendDao.searchFriendInfoByName(email, fName);
		List<Friend> friends = new ArrayList<Friend>();
		for(FriendInfoDTO friendInfoDTO : friendInfoDTOs){
			friends.add(new Friend(friendInfoDTO.getfName(), friendInfoDTO.getfEmail()));
		}
		return friends;
	}
	
	

}
