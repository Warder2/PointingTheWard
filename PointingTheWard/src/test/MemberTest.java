package test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import model.beans.Transportation;
import persistance.dao.MemberDAO;
import persistance.dto.MemberDTO;
import persistance.dto.MemberODTO;

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
				new MemberDTO("email2", "name2", "pwd2", "location2", Transportation.DRIVING),
				new MemberDTO("email3", "name", "pwd3", "location3", Transportation.DRIVING)
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
	
	@Test
	public void searchMemberByName(){
		System.out.println("searchMemberByName");
		signUpMembers();
		List<MemberDTO> list = memberDao.searchMemberByName("name");
		Assert.notEmpty(list);
		System.out.println(list);
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
	public void searchMemberOInfo(){
		System.out.println("searchMemberOInfo");
		
		signUp();
		
		MemberODTO memberODTO = memberDao.searchMemberOp(members[0].getEmail());
		Assert.notNull(memberODTO);
		System.out.println(memberODTO);
	}
	
	@Test(expected=EmptyResultDataAccessException.class)
	public void searchMemberOInfoEmpty(){
		System.out.println("searchMemberOInfoEmpty");
		
		signUp();
		
		memberDao.searchMemberOp("");
	}
	
	@Test
	public void searchMemberPInfo(){
		System.out.println("searchMemberPInfo");
		
		signUp();
		
		Assert.notNull(memberDao.searchMemberP(members[0].getEmail()));
	}
	
	@Test(expected=EmptyResultDataAccessException.class)
	public void searchMemberPInfoEmpty(){
		System.out.println("searchMemberPInfoEmpty");
		
		memberDao.searchMemberP(members[0].getEmail());
	}
	
	@Test(expected=EmptyResultDataAccessException.class)
	public void deleteMember(){
		System.out.println("deleteMember");
		
		signUp();
		
		memberDao.dropOutMember(members[0].getEmail());
		
		memberDao.searchMember(members[0].getEmail());
	}
	
	@Test(expected=EmptyResultDataAccessException.class)
	public void deleteMembers(){
		System.out.println("deleteMembers");
		
		signUpMembers();
		
		memberDao.dropOutMembers(members[0].getEmail(), members[1].getEmail(), members[2].getEmail());
		
		memberDao.searchMembers(members[0].getEmail(), members[1].getEmail(), members[2].getEmail());
	}
	
	@Test
	public void modifyMember(){
		System.out.println("modifyMember");
		
		signUp();
		memberDao.modifyMember(members[0].getEmail(), "11", "name1", "location1", Transportation.DRIVING);
		
		MemberDTO memberDTO = memberDao.searchMember(members[0].getEmail());
		Assert.isTrue(!members[0].equals(memberDTO));
	}
	
	@Test
	public void modifyMemberLocation(){
		System.out.println("modifyMemberLocation");
		
		signUp();
		
		memberDao.modifyMemberLocation(members[0].getEmail(), "location!!");
		
		Assert.isTrue(!members[0].getLocation().equals(memberDao.searchMember(members[0].getEmail()).getLocation()));
	}
	
	@Test
	public void modifyMemberTransportation(){
		System.out.println("modifyMemberTransportation");
		signUp();
		memberDao.modifyTransportation(members[0].getEmail(), Transportation.DRIVING);
		
		Assert.isTrue(!members[0].getTransportation().equals(memberDao.searchMember(members[0].getEmail()).getTransportation()));
	}
	
	@Test
	public void modifyMemberPwd(){
		System.out.println("modifyMemberPwd");
		signUp();
		memberDao.modifyMemberPwd(members[0].getEmail(), "pwd!@#@@");
		
		Assert.isTrue(!members[0].getPwd().equals(memberDao.searchMember(members[0].getEmail()).getPwd()));
	}
}
