package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import model.beans.Transportation;
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
		eventsList.add(new EventDTO(0, "title1", "sD", "eD", "sT", "eT", "content", "place"));
		eventsList.add(new EventDTO(0, "title2", "sD", "eD", "sT", "eT", "content", "place"));
		eventsList.add(new EventDTO(0, "title3", "sD", "eD", "sT", "eT", "content", "place"));

		eventPsArray = new EventParticipantInfoDTO[] {
				new EventParticipantInfoDTO(1, "email1", "title", "sDate", "eDate", "sTime", "eTime", "content",
						"place", "name", "location", Transportation.DRIVING),
				new EventParticipantInfoDTO(2, "email1", "title2", "sDate", "eDate", "sTime", "eTime", "content",
						"place", "name", "location", Transportation.TRANSIT),
				new EventParticipantInfoDTO(3, "email3", "title3", "sDate", "eDate", "sTime", "eTime", "content",
						"place", "name", "location", Transportation.DRIVING),

		};

		eventsArray = new EventDTO[] { new EventDTO("sival", "sDate", "eDate", "sTime", "eTime", "content", "place"),
				new EventDTO(2, "title2", "sDate", "eDate", "sTime", "eTime", "content", "place"),
				new EventDTO(3, "title3", "sDate", "eDate", "sTime", "eTime", "content", "place"), };
	}

	public void eventSearch() {
		List<EventDTO> events = eventDAO.eventSearchAll();
		System.out.println(events.size());
		for (EventDTO event : events) {
			Assert.notNull(event);
			System.out.println(event);
		}

	}

	public void eventSearch2() {
		List<EventDTO> events = eventDAO
				.eventSearch(new EventDTO("바뀐 제목", "시작날짜용", "종료날짜용", "시작시간용", "종료시간용", "냉무", "장소염"));
		System.out.println(events.size());
		for (EventDTO event : events) {
			Assert.notNull(event);
			System.out.println(event);
		}
		eventSearch();
	}

	public void eventSearchCode() {
		EventDTO event = eventDAO.eventSearchCode(1);
		Assert.notNull(event);
		System.out.println(event);
	}

	public void eventParticipantSearchMail() {
		List<EventParticipantDTO> events = eventDAO.eventParticipantSearchMail("email");
		System.out.println(events.size());
		for (EventParticipantDTO event : events) {
			Assert.notNull(event);
			System.out.println(event);
		}
	}

	public void eventParticipantSearchCode() {
		List<EventParticipantDTO> events = eventDAO.eventParticipantSearchCode(2);
		System.out.println(events.size());
		for (EventParticipantDTO event : events) {
			Assert.notNull(event);
			System.out.println(event);
		}
	}

	public void eventParticipantSearch() {
		EventParticipantDTO event = eventDAO.eventParticipantSearch("email", 1);
		Assert.notNull(event);
		System.out.println(event);
	}

	public void eventParticipantInfoSearchMail() {
		List<EventParticipantInfoDTO> events = eventDAO.eventParticipantInfoSearchMail("email");
		System.out.println(events.size());
		for (EventParticipantInfoDTO event : events) {
			Assert.notNull(event);
			System.out.println(event);
		}
	}

	public void eventParticipantInfoSearch() {
		EventParticipantInfoDTO event = eventDAO.eventParticipantInfoSearch("email", 2);
		Assert.notNull(event);
		System.out.println(event);
	}
	@Test
	public void eventParticipantInfoSearchCode() {
		EventParticipantInfoDTO events = eventDAO.eventParticipantInfoSearchCode(8);
		System.out.println(events);
	}


	public void eventModify() {
		eventDAO.eventModify(new EventDTO(2, "바뀐 제목", "시작날짜용", "종료날짜용", "시작시간용", "종료시간용", "냉무", "장소염"),
				new EventDTO("바뀐 제목", "시작날짜용", "종료날짜용", "시작시간용", "종료시간용", "냉무", "장소염"));
		eventSearch();
	}

	public void eventModifyCode() {
		eventDAO.eventModifyCode(1, new EventDTO("바뀐 제목", "시작날짜용", "종료날짜용", "시작시간용", "종료시간용", "냉무", "장소염"));
		eventSearch();
	}

	public void eventRegist() {
		eventDAO.eventRegist(new EventDTO("추가 일정념", "시작날짜용", "종료날짜용", "시작시간용", "종료시간용", "냉무", "장소염"));
		eventSearch();
	}

	public void eventRegist2() {
		eventDAO.eventRegist("추가 일정념", "시작날짜용", "종료날짜용", "시작시간용", "종료시간용", "냉무", "장소염");
		eventSearch();
	}

	public void eventParticipantRegist() {
		eventDAO.eventParticipantRegist("SB",
				new EventDTO(8, "추가 일정념2", "시작날짜용", "종료날짜용", "시작시간용", "종료시간용", "냉무", "장소염"));
		eventParticipantInfoSearchCode();
	}

	public void eventDelete() {
		eventDAO.eventDelete(8);
		eventSearch();
	}

	public void eventSearchRangeDate() {
		List<EventDTO> eList = eventDAO.eventSearchRangeDate("2016-01-05", "2016-01-06");

		System.out.println(eList.size());

		for (EventDTO e : eList) {
			System.out.println(e);
		}
	}

	public void eventSearchScope() {
		List<EventDTO> eList = eventDAO.eventSearchScope(20);
		for (EventDTO e : eList) {
			System.out.println(e);
		}

	}

	public void eventSearchTime() {
		List<EventDTO> eList = eventDAO.eventSearchRangeTime("2016/01/07", "5:00", "22:00");
		for (EventDTO e : eList) {
			System.out.println(e);
		}
	}

	public void dateCompare() {
		String sDate = "17 - 00";
		String eDate = "18 - 30";

		String d1 = "16/12/31";

		SimpleDateFormat formatter = new SimpleDateFormat("yy/MM/dd");
		Calendar rightNow = Calendar.getInstance();
		rightNow.add(Calendar.DATE, 7);
		String currentDate = formatter.format(rightNow.getTime());

		System.out.println(currentDate);

		if (sDate.compareTo(eDate) > 0) {
			System.out.println("sDate >> eDate");
		} else {
			System.out.println("sDate << eDate");
		}
	}

	public void possibleTime() {
		List<EventDTO> eList = eventDAO.eventSearchRangeTime("2016/01/07", "5:00", "22:00");
		for (EventDTO e : eList) {
			System.out.println(e);
		}
	}

}
