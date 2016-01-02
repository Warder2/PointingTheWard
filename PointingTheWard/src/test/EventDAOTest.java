package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.beans.Transportation;
import persistance.dao.EventDAO;
import persistance.dao.MemberDAO;
import persistance.dto.EventDTO;
import persistance.dto.MemberDTO;
import persistance.viewdto.EventParticipantInfoViewDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/daoContext.xml")
public class EventDAOTest {

	@Autowired
	private EventDAO eventDAO;
	private EventDTO[] events;
	private EventParticipantInfoViewDTO[] eventparticipants;
	private MemberDTO[] members;
	private MemberDAO memberDao;

		@Before
		public void setUp(){
			eventparticipants = new EventParticipantInfoViewDTO[]{
					new EventParticipantInfoViewDTO(1,"email1", "title", "sDate" , "eDate" , "sTime" , "eTime" , "content", "place"),
					new EventParticipantInfoViewDTO(2,"email1","title2", "sDate" , "eDate" , "sTime" , "eTime" , "content", "place"),
					new EventParticipantInfoViewDTO(3,"email3","title3", "sDate" , "eDate" , "sTime" , "eTime" , "content", "place"),
					
			};
			
			events = new EventDTO[]{
					new EventDTO("sival", "sDate" , "eDate" , "sTime" , "eTime" , "content", "place"),
					new EventDTO(2,"title2", "sDate" , "eDate" , "sTime" , "eTime" , "content", "place"),
					new EventDTO(3,"title3", "sDate" , "eDate" , "sTime" , "eTime" , "content", "place"),
			};

			members = new MemberDTO[]{
					new MemberDTO("email", "name", "pwd", "location", Transportation.TRANSIT),
					new MemberDTO("email1", "name1", "pwd1", "location1", Transportation.TRANSIT),
					new MemberDTO("email2", "name2", "pwd2", "location2", Transportation.DRIVING)
			};                      
			                      
		}

	public void insertEvent(){
		
			
	}
	public void searchEvent() {
		
	}
	
	public void deleteEvent(){
		
	}

	public void modifyEvent(){
		
	}
}
