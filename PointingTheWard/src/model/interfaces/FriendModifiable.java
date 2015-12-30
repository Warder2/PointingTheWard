package model.interfaces;

import model.beans.Friend;

public interface FriendModifiable {
	public boolean modifyFriend(Friend friend, Friend newFriend);
	public boolean modifyFriend(String email, Friend newFriend);
	public boolean modifyFriendEmail(String email, String newMail);
	public boolean modifyFriendName(String email, String name);
}
