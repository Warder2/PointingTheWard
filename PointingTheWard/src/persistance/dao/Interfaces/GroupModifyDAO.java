package persistance.dao.Interfaces;

import java.util.List;

import model.beans.Friend;
import model.beans.Group;

public interface GroupModifyDAO {
	//modify group
	void modifyGroup(int gCode, Group group);
	void modifyGroup(int gCode, String name);
	
	//그룹원 추가
	void addFriend(int gCode, String email);
	void addFriends(int gCode, String... emails);
	void addFriend(int gCode, Friend friend);
	void addFriends(int gCode, Friend... friends);
	void addFriends(int gCode, List<Friend> friends);
}
