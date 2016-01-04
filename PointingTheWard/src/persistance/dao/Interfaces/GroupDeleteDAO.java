package persistance.dao.Interfaces;

import java.util.List;

public interface GroupDeleteDAO {
	//delete group all
	void deleteGroupAll();
	//delete group
	void deleteGroup(int gCode);
	//delete groups
	void deleteGroups(String owner);
	void deleteGroups(int... gCodes);
	void deleteGroups(List<Integer> gCodes);
	
	//그룹 탈퇴
	void deleteGroupParticipant(int gCode, String email);
	void deleteGroupParticipants(int gCode, String... emails);
	void deleteGroupParticipants(int gCode, List<String> emails);
}
