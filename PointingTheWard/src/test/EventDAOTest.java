package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import persistance.dao.EventDAO;
import persistance.dto.EventDTO;
import persistance.dto.EventParticipantDTO;
import persistance.dto.EventParticipantInfoDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/daoContext.xml")
public class EventDAOTest {

	@Autowired
	private EventDAO eventDAO;
	private List<EventDTO> eventsList;
	private EventDTO[] eventsArray;
	private List<EventParticipantInfoDTO> eventPsList;
	private EventParticipantInfoDTO[] eventPsArray;



	@Before
	public void setUp() {
		eventsList = new ArrayList();
		eventsList.add(new EventDTO(0,"title1","sD","eD","sT","eT","content","place"));
		eventsList.add(new EventDTO(0,"title2","sD","eD","sT","eT","content","place"));
		eventsList.add(new EventDTO(0,"title3","sD","eD","sT","eT","content","place"));
		
		eventPsArray = new EventParticipantInfoDTO[] {
				new EventParticipantInfoDTO(1, "email1", "title", "sDate", "eDate", "sTime", "eTime", "content",
						"place"),
				new EventParticipantInfoDTO(2, "email1", "title2", "sDate", "eDate", "sTime", "eTime", "content",
						"place"),
				new EventParticipantInfoDTO(3, "email3", "title3", "sDate", "eDate", "sTime", "eTime", "content",
						"place"),

		};

		eventsArray = new EventDTO[] { new EventDTO("sival", "sDate", "eDate", "sTime", "eTime", "content", "place"),
				new EventDTO(2, "title2", "sDate", "eDate", "sTime", "eTime", "content", "place"),
				new EventDTO(3, "title3", "sDate", "eDate", "sTime", "eTime", "content", "place"), };
	}
	
	
	public void eventSearch(){
		List<EventDTO> events = eventDAO.eventSearchAll();
		System.out.println(events.size());
		for(EventDTO event : events){
			Assert.notNull(event);
			System.out.println(event);
		}
		
	}
	
	public void eventSearchCode(){
		EventDTO event = eventDAO.eventSearchCode(1);
		Assert.notNull(event);
		System.out.println(event);
	}
	
	
	public void eventParticipantSearchMail(){
		List<EventParticipantDTO> events = eventDAO.eventParticipantSearchMail("email");
		System.out.println(events.size());
		for(EventParticipantDTO event : events){
			Assert.notNull(event);
			System.out.println(event);
		}
	}
	
	public void eventParticipantSearchCode(){
		List<EventParticipantDTO> events = eventDAO.eventParticipantSearchCode(2);
		System.out.println(events.size());
		for(EventParticipantDTO event : events){
			Assert.notNull(event);
			System.out.println(event);
		}
	}
	
	
	public void eventParticipantSearch(){
		EventParticipantDTO event = eventDAO.eventParticipantSearch("email", 1);
		Assert.notNull(event);
		System.out.println(event);
	}
	
	
	public void eventParticipantInfoSearchMail(){
		List<EventParticipantInfoDTO> events = eventDAO.eventParticipantInfoSearchMail("email");
		System.out.println(events.size());
		for(EventParticipantInfoDTO event : events){
			Assert.notNull(event);
			System.out.println(event);
		}
	}
	
	public void eventParticipantInfoSearch(){
		EventParticipantInfoDTO event = eventDAO.eventParticipantInfoSearch("email", 2);
		Assert.notNull(event);
		System.out.println(event);
	}
	
	public void eventParticipantInfoSearchCode(){
		List<EventParticipantInfoDTO> events = eventDAO.eventParticipantInfoSearchCode(1);
		System.out.println(events.size());
		for(EventParticipantInfoDTO event : events){
			Assert.notNull(event);
			System.out.println(event);
		}
	}
	@Test
	public void eventModify(){
		eventDAO.eventModify(new EventDTO(2,"바뀐 제목","시작날짜용","종료날짜용","시작시간용","종료시간용","냉무","장소염"), new EventDTO("바뀐 제목","시작날짜용","종료날짜용","시작시간용","종료시간용","냉무","장소염"));
		eventSearch();
	}
	
	public void eventModifyCode(){
		eventDAO.eventModifyCode(1, new EventDTO("바뀐 제목","시작날짜용","종료날짜용","시작시간용","종료시간용","냉무","장소염"));
		eventSearch();
	}
	
}

