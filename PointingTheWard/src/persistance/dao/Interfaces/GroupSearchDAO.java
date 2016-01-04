package persistance.dao.Interfaces;

import java.util.List;

import persistance.dto.GroupDTO;
import persistance.dto.GroupParticipantInfoDTO;

public interface GroupSearchDAO {
	//search group
	List<GroupDTO> searchGroupAll();
	List<GroupDTO> searchGroup(String owner);
	GroupDTO searchGroup(int gCode);
	List<GroupDTO> searchGroupByName(String name, String owner);
	
	//search participant info
	GroupParticipantInfoDTO searchGroupParticipant(int gCode, String email);
	List<GroupParticipantInfoDTO> searchGroupParticipants(int gCode);
}