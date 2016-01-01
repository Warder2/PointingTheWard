package test;

import org.junit.After;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import persistance.dao.MemberDAO;

public class MemberTest {
	private AbstractApplicationContext context;
	private MemberDAO memberDao;
	
	@After
	public void setUp(){
		context = new GenericXmlApplicationContext("daoContext.xml");
		memberDao = context.getBean("memberDao", MemberDAO.class);
	}
	
	@Test
	public void signUp(){}
}
