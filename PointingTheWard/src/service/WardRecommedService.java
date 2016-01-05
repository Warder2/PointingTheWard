package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.beans.Event;
import model.list.WardList;
import persistance.dao.EventDAO;
import persistance.dto.EventDTO;
import persistance.dto.EventParticipantInfoDTO;
import service.abstracts.AbstractWardService;
import service.interfaces.WardRecommendable;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/daoContext.xml")
public class WardRecommedService extends AbstractWardService implements WardRecommendable {

	@Autowired
	private EventDAO eventDAO;

	@Override
	public void execute(ServiceRequest request) {

		List<String> particiantsEmails = request.getObject("particiants");
		String scope = request.getObject("scope");
		String period = request.getObject("period");
		String runTime = request.getObject("runTime");

		getParticiantEvents(particiantsEmails);
	}

	
	@Test
	public void test() {
		List<String> emails = new ArrayList<String>();
		emails.add("jangsb7113@naver.com");
		emails.add("akjin47@naver.com");
		List<EventParticipantInfoDTO> events = getParticiantEvents(emails);
		if(events!= null)// 참가자 일정 있을 경우 
			getScopeInEvents(events, 2); 
	}
	
	// 1. 참가자들의 모든 일정 가져오기
	public List<EventParticipantInfoDTO> getParticiantEvents(List<String> particiantsEmails) {

		List<EventParticipantInfoDTO> events = new ArrayList<EventParticipantInfoDTO>();

		for (String email : particiantsEmails) {

			events.addAll(eventDAO.eventParticipantInfoSearchMail(email));
		}
		System.out.println(events.size());
		
		return events;
	}

	// 2. 범위 내 일정 가져오기
	public void getScopeInEvents(List<EventParticipantInfoDTO> events, int scope) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar rightNow = Calendar.getInstance();
		String currentDate = formatter.format(rightNow.getTime());	// 오늘 날짜 

		System.out.println("오늘날짜 : " + currentDate);
		
		rightNow.add(Calendar.DATE, scope);

		String scopeDate = formatter.format(rightNow.getTime()); 	// 범위 날짜
		
		System.out.println("오늘날짜 : " + scopeDate);

		for (EventParticipantInfoDTO e : events) {
			if (e.getsDate().compareTo(currentDate) > 0 && e.geteDate().compareTo(scopeDate) <= 0) {
				System.out.println(e);
			}
		}
	}

	public List<String> possibleEventList(List<EventParticipantInfoDTO> events) {

		List<EventDTO> eList = new ArrayList<EventDTO>();

		return null;
	}

	@Override
	public List<Event> possibleEvent(List<Event> events) {

		return null;
	}

	@Override
	public WardList possiblePlace(List<Event> events) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WardList possibleWardListRecommend(WardList wardList, List<Event> events) {
		// TODO Auto-generated method stub
		return null;
	}

}
