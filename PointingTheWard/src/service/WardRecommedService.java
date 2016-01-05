package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import model.beans.Event;
import model.list.WardList;
import persistance.dao.EventDAO;
import persistance.dto.EventDTO;
import persistance.dto.EventParticipantInfoDTO;
import service.abstracts.AbstractWardService;
import service.interfaces.WardRecommendable;

public class WardRecommedService extends AbstractWardService implements WardRecommendable {

	
	private EventDAO eventDAO;
	
	@Override
	public void execute(ServiceRequest request) {

		
			List<String> particiantsEmails = request.getObject("particiants");
			String scope = request.getObject("scope");
			String period = request.getObject("period");
			String runTime = request.getObject("runTime");
			
			getParticiantEvents(particiantsEmails);
	}
	
	//1. 참가자들의 모든 일정 가져오기 
	@Test
	public void test(){
		List<String> emails = new ArrayList<String>();
		emails.add("jangsb7113@naver.com");
		emails.add("akjin47@naver.com");
		emails.add("nj186@naver.com");
		 getParticiantEvents(emails);
		
	}
	
	public List<EventParticipantInfoDTO> getParticiantEvents(List<String> particiantsEmails){
		
		Map<String , List<EventParticipantInfoDTO>> participantEvent = new HashMap<String, List<EventParticipantInfoDTO> >();
		
		List<EventParticipantInfoDTO> events = new ArrayList<EventParticipantInfoDTO>();
		
		EventParticipantInfoDTO e = eventDAO.eventParticipantInfoSearchCode(0);
		
		System.out.println(e);
		
		for(String email : particiantsEmails){
			
			events.addAll(eventDAO.eventParticipantInfoSearchMail(email));
		}

		return events;
	}
	
	//2. 범위 내 일정 가져오기 
	public void getScopeInEvents(List<EventParticipantInfoDTO> events , int scope){

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar rightNow = Calendar.getInstance();
		String currentDate = formatter.format(rightNow.getTime());
		
		rightNow.add(Calendar.DATE, scope);
		
		String scopeDate = formatter.format(rightNow.getTime());
		
		for(EventParticipantInfoDTO e : events){
			if( !(e.getsDate().compareTo(currentDate) > 0 && e.geteDate().compareTo(scopeDate) < 0) ){
				
				System.out.println(e);
				events.remove(e);
			}
		}
	}
	
	public List<String> possibleEventList(List<EventParticipantInfoDTO> events){
		
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
