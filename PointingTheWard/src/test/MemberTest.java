package test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
	
	@Test
	public void signUp(){
		System.out.println(memberDao);
	}
}
