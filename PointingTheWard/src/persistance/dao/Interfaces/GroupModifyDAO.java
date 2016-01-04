package persistance.dao.Interfaces;

import java.util.List;
import persistance.dto.FriendDTO;
import persistance.dto.GroupDTO;

public interface GroupModifyDAO {
	//modify group
	void modifyGroup(int gCode, GroupDTO group);
	void modifyGroup(int gCode, String name);
	
	//그룹원 추가
	void addFriend(int gCode, String email);
	void addFriends(int gCode, String... emails);
	void addFriend(int gCode, FriendDTO friend);
	void addFriends(int gCode, FriendDTO... friends);
	void addFriends(int gCode, List<FriendDTO> friends);
}
