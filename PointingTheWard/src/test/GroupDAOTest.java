package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import persistance.dao.GroupDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/daoContext.xml")
public class GroupDAOTest {
	@Autowired
	private GroupDAO groupDAO;
	
	@Before
	public void setUp(){
	}
	
	@Before
	@After
	public void deleteAll(){
		groupDAO.deleteGroupAll();
	}
	
	@Test
	public void createGroup(){
		System.out.println("createGroup");
		groupDAO.createGroup("email", "group1");
		groupDAO.search
	}
}
