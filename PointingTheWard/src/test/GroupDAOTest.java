package test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import persistance.dao.GroupDAO;
import persistance.dto.GroupDTO;
import persistance.dto.GroupParticipantInfoDTO;

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
		List<GroupDTO> list = groupDAO.searchGroup("email");
		Assert.notEmpty(list);
	}
	
	@Test
	public void searchGroup(){
		System.out.println("searchGroup");
		createGroup();
		List<GroupDTO> groupDTOs = groupDAO.searchGroupByName("group1", "email");
		List<GroupParticipantInfoDTO> groupParticipantInfoDTOs = groupDAO.searchGroupParticipants(3);
	}
	
	@Test
	public void deleteGroup(){
		System.out.println("deleteGroup");
		
		groupDAO.createGroup("email", "name!!");
		groupDAO.deleteGroup(1);
	}
}