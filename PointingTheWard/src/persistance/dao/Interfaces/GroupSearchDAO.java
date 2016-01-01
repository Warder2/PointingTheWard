package persistance.dao.Interfaces;

import java.util.List;

import persistance.dto.GroupDTO;
import persistance.viewdto.GroupViewDTO;

public interface GroupSearchDAO {
	//search group
	List<GroupDTO> searchGroupInfoAll();
	List<GroupDTO> searchGroupInfo(String email);
	List<GroupViewDTO> searchGroup(String email);
	List<GroupViewDTO> searchGroup(String email, int gCode);
}
