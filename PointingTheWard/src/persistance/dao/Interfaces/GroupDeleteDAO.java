package persistance.dao.Interfaces;

import java.util.List;

public interface GroupDeleteDAO {
	//delete group
	void deleteGroup(int gCode);
	//그룹 탈퇴
	void deleteGroup(int gCode, String email);
	//delete groups
	void deleteGroups(String email, int... gCodes);
	void deleteGroups(String email, List<Integer> gCodes);
}
