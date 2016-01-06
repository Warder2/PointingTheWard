package persistance.dao.Interfaces;

import java.util.List;

import persistance.dto.FriendDTO;
import persistance.dto.FriendInfoDTO;
/**
 * 친구정보를 데이터베이스에서 가져오는 INTERFACE
 * @author SEONGBONG
 *
 */
public interface FriendSearchDAO {
	/**
	 * 친구로 등록된 모든 친구를 가져오는 메소드
	 * @return 친구들의 이름과 이메일 정보들
	 */
	public List<FriendDTO> searchFriendAll();
	
	/**
	 * 특정 회원의 친구들을 가져오는 메소드
	 * @param email 회원 이메일
	 * @return 친구들의 이름과 이메일 정보들
	 */
	public List<FriendDTO> searchFriends(String email);
	/**
	 * 친구로 등록된 모든 회원들의 정보들을 가져오는 메소드
	 * @return 친구들의 회원정보들
	 */
	public List<FriendInfoDTO> searchFriendsInfoAll();
	/**
	 * 특정 회원의 친구들의 회원정보를 가져오는 메소드
	 * @param email 회원 이메일
	 * @return 친구들의 회원정보들
	 */
	public List<FriendInfoDTO> searchFriendsInfoEmail(String email);

	/**
	 * 특정 회원의 친구들 중 특정 친구의 회원정보를 가져오는 메소드
	 * @param email 회원이메일
	 * @param friendEmail 조회 할 친구이메일
	 * @return 친구의 회원정보
	 */
	public FriendInfoDTO searchFriendInfoEmail(String email,String friendEmail);
	
	public List<FriendInfoDTO> searchFriendInfoByName(String email, String fName);
		
}
