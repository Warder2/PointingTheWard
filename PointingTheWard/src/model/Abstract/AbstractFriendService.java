package model.Abstract;

import model.ListVO.FriendList;
import model.interfaces.FriendInsertable;
import model.interfaces.FriendDropoutable;
import model.interfaces.FriendModifiable;
import model.interfaces.FriendSearchable;

public abstract class AbstractFriendService implements FriendInsertable,FriendSearchable,FriendModifiable,FriendDropoutable{
	private static FriendList friends;
	static{
		AbstractFriendService.friends = new FriendList();
	}
	public static synchronized FriendList getFriends() {
		return friends;
	}
	public static void setFriends(FriendList friends) {
		AbstractFriendService.friends = friends;
	}	
}
