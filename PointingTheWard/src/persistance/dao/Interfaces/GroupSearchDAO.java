package persistance.dao.Interfaces;

import java.util.List;

import persistance.dto.GroupDTO;
import persistance.dto.GroupParticipantInfoDTO;

public interface GroupSearchDAO {
	//search group
	List<GroupDTO> searchGroupInfoAll();
	List<GroupDTO> searchGroupInfo(String email);
	List<GroupParticipantInfoDTO> searchGroupParticipants(int gCode);
	GroupParticipantInfoDTO searchGroupParticipant(int gCode, String email);
}