package persistance.dao.Interfaces;

import java.util.List;

import persistance.dto.GroupDTO;
import persistance.viewdto.GroupParticipantInfoViewDTO;

public interface GroupSearchDAO {
	//search group
	List<GroupDTO> searchGroupInfoAll();
	List<GroupDTO> searchGroupInfo(String email);
	List<GroupParticipantInfoViewDTO> searchGroupParticipants(int gCode);
	GroupParticipantInfoViewDTO searchGroupParticipant(int gCode, String email);
}