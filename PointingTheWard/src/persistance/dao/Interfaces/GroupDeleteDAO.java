package persistance.dao.Interfaces;

public interface GroupDeleteDAO {
	//delete group
	void deleteGroup(int gCode);
	//delete groups
	void deleteGroups(int... gCodes);
}
