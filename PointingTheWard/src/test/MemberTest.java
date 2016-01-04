package test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import model.beans.Transportation;
import persistance.dao.MemberDAO;
import persistance.dto.MemberDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/daoContext.xml")
public class MemberTest {
	@Autowired
	private MemberDAO memberDao;
	private MemberDTO[] members;
	
	@Before
	public void setUp(){
		members = new MemberDTO[]{
				new MemberDTO("email", "name", "pwd", "location", Transportation.TRANSIT),
				new MemberDTO("email1", "name1", "pwd1", "location1", Transportation.TRANSIT),
				new MemberDTO("email2", "name2", "pwd2", "location2", Transportation.DRIVING)
		};
	}
	
	@After
	@Before
	public void deleteAll(){
		memberDao.dropOutAll();
	}
	
	@Test
	public void signUp(){
		System.out.println("signUp");
		
		memberDao.signUpMember(members[0]);
		MemberDTO memberDTO = memberDao.searchMember(members[0].getEmail());
		
		Assert.isTrue(members[0].equals(memberDTO));
	}
	
	@Test
	public void signUpMembers(){
		System.out.println("signUpMembers");
		memberDao.signUpMembers(members);
	}
	
	@Test(expected=DuplicateKeyException.class)
	public void signUpDuplicateException(){
		System.out.println("signUpDuplicateException");
		
		memberDao.signUpMember(members[0]);
		memberDao.signUpMember(members[0]);
	}
	
	@Test
	public void searchMember(){
		System.out.println("searchMember");
		
		memberDao.signUpMember(members[0]);
		MemberDTO memberDTO = memberDao.searchMember(members[0].getEmail());
		
		Assert.notNull(memberDTO);
	}
	
	@Test(expected=EmptyResultDataAccessException.class)
	public void searchMemberEmpty(){
		System.out.println("searchMemberEmpty");
		
		MemberDTO memberDTO = memberDao.searchMember(members[0].getEmail());
		
		Assert.notNull(memberDTO);
	}
	
	@Test
	public void searchMembers(){
		System.out.println("searchMembers");
		
		signUpMembers();
		
		List<MemberDTO> list = memberDao.searchMembers(members[0].getEmail(), members[1].getEmail(), members[2].getEmail());
		Assert.notEmpty(list);
		System.out.println(list);
	}
	
	@Test
	public void deleteMember(){
		System.out.println("deleteMember");
		
		
	}
}
