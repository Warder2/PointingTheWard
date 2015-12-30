package model.service;

import java.util.ArrayList;
import java.util.List;

import model.Abstract.AbstractFriendService;
import model.beans.Friend;

public class FriendService extends AbstractFriendService{
	public boolean addFriend(Friend friend){
		return false;
	}
	public boolean addFriend(int index,Friend friend){
		return false;
	}
	public Friend searchFriend(Friend friend){
		return new Friend();
	}
	public Friend searchFriendEmail(String email){
		return new Friend();
	}
	public List<Friend> searchFriendName(String name){
		return new ArrayList<Friend>();
	}
	public boolean modifyFriend(Friend friend, Friend newFriend){
		return false;
	}
	public boolean modifyFriend(String email, Friend newFriend){
		return false;
	}
	public boolean modifyFriendEmail(String email, String newMail){
		return false;
	}
	public boolean modifyFriendName(String email, String name){
		return false;
	}
	public boolean deleteFriendEmail(String email){
		return false;
	}
	public int deleteFriendName(String name){
		return 1;
	}
	
}
