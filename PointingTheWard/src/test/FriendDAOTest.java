package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import persistance.dao.FriendDAO;
import persistance.dto.FriendDTO;
import persistance.dto.FriendInfoDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/daoContext.xml")
public class FriendDAOTest {
	@Autowired
	private FriendDAO friendDao;
	private List<String> friendsEmail1;
	private String[] friendsEmail2;

	@Before
	public void set() {
		friendsEmail1 = new ArrayList<String>();
		friendsEmail1.add("email1");
		friendsEmail1.add("email2");
		friendsEmail2 = new String[] { "email1", "email2" };
	}

	public void addtionFriend() {
		System.out.println("addtionFriend");
		friendDao.addtionFriend("email", "email2");
		// try{
		// friendDao.addtionFriend("email", "email2");
		// }catch (DuplicateKeyException dke){
		// System.out.println("unique한 값이 아닙니다.");
		// }
		// DataIntegrityViolationException - 무결성 제약 조건 위반
		// BadSqlGrammarException - SQL이 유효하지 않은 경우 예외가 발생
		// DataAccessResourceFailureException - JDBC를 사용하여 데이터베이스에 연결할 수 없는경우
		// CannotAcquireLockException - 누군가 DB물고있는경우, 누가 커밋안했을때 - DB락
		// DeadlockLoserDataAccessException -현재 프로세스가 교착 상태
		searchFriend();
	}

	public void addtionFriends1() {
		System.out.println("addtionFriends");
		for (String friendEmail : friendsEmail1) {
			friendDao.addtionFriends("email", friendEmail);
		}
		searchFriend();
	}
	
	public void addtionFriends2() {
		System.out.println("addtionFriends");
		for (String friendEmail : friendsEmail2) {
			friendDao.addtionFriends("email", friendEmail);
		}
		searchFriend();
	}

	public void deleteFriendAll() {
		System.out.println("friendsAdd");
		friendDao.deleteFriendAll("email");
		searchFriend();
	}

	public void deleteFriendEmail() {
		System.out.println("deleteFriendEmail");
		friendDao.deleteFriendEmail("email", "email1");
		searchFriend();
	}

	
	public void deleteFriends1() {
		System.out.println("deleteFriends");
		friendDao.deleteFriends("email", friendsEmail1);
		searchFriend();
	}
	
	public void deleteFriends2() {
		System.out.println("deleteFriends");
		friendDao.deleteFriends("email", friendsEmail2);
		searchFriend();
	}
	
	public void searchFriend() {
		List<FriendDTO> friends = friendDao.searchFriendAll();

		Assert.notNull(friends);
		System.out.println("friendSearch : " + friends.size());
		for (FriendDTO friend : friends) {
			System.out.println(friend);
		}
	}
	
	public void searchFriends(){
		System.out.println("searchFriends");
		List<FriendDTO> friends = friendDao.searchFriends("email");
		Assert.notNull(friends);
		System.out.println("friendSearch : " + friends.size());
		for (FriendDTO friend : friends) {
			System.out.println(friend);
		}
	}
	
	public void searchFriendsInfoAll(){
		System.out.println("searchFriends");
		List<FriendInfoDTO> friends = friendDao.searchFriendsInfoAll();
		Assert.notNull(friends);
		System.out.println("friendSearch : " + friends.size());
		for (FriendInfoDTO friend : friends) {
			System.out.println(friend);
		}
	}
	
	public void searchFriendsInfoEmail(){
		System.out.println("searchFriendsInfoEmail");
		List<FriendInfoDTO> friends = friendDao.searchFriendsInfoEmail("email");
		Assert.notNull(friends);
		System.out.println("friendSearch : " + friends.size());
		for (FriendInfoDTO friend : friends) {
			System.out.println(friend);
		}
	}
	@Test
	public void searchFriendInfoEmail(){
		System.out.println("searchFriendInfoEmail");
		FriendInfoDTO friendInfo = friendDao.searchFriendInfoEmail("email", "email1");
		Assert.notNull(friendInfo);
		System.out.println(friendInfo);
	}
}
