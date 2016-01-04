package persistance.dao.Interfaces;

import java.util.List;

import persistance.dto.FriendDTO;

public interface GroupCreateDAO {
	// create group
	void createGroup(String owner, String name);

	// 그룹원 추가
	void createGroupParticipant(int gCode, String email);

	void createGroupParticipants(int gCode, String... emails);
	
	void createGroupParticipant(int gCode, List<String> emails);

	void createGroupParticipant(int gCode, FriendDTO friend);

	void createGroupParticipants(int gCode, FriendDTO... friends);

	void createGroupParticipants(int gCode, List<FriendDTO> friends);
}
