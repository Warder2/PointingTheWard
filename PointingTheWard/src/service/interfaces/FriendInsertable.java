package service.interfaces;

import model.beans.Friend;

public interface FriendInsertable {
	public boolean addFriend(Friend friend);
	public boolean addFriend(int index,Friend friend);
}
