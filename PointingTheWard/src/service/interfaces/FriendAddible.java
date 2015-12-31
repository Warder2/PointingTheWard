package service.interfaces;

import model.beans.Friend;

public interface FriendAddible {
	public boolean addFriend(Friend friend);
	public boolean addFriend(int index,Friend friend);
}
