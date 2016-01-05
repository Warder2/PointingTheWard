package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.beans.Event;
import model.beans.Place;
import model.beans.Time;
import model.beans.Ward;
import model.list.WardList;
import persistance.dao.EventDAO;
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
		emails.add("nj186@naver.com");
		String scope = "2";
		String period = "";
		String runTime = "01:00";

		// 1.참가자들의 모든 일정을 가져온다.
		List<EventParticipantInfoDTO> events = getParticiantEvents(emails);
		Map<String, List<EventParticipantInfoDTO>> dayEventParticipantInfoMap = null;

		if (events != null) {// 참가자 일정 있을 경우
			// 2. 범위 내 일정 가져오기
			getScopeInEvents(events, Integer.parseInt(scope));
			// 3. 기간 나눠서 거르기(ver2)
			// 4. 일 단위로 리스트 나누기
			dayEventParticipantInfoMap = dayEventParticipantInfoList(events, Integer.parseInt(scope));
			// 4. ward리스트 뽑기
		}
		
		Set<String> keys = dayEventParticipantInfoMap.keySet();
		List<Ward> wards = new ArrayList<Ward>();

		for (String key : keys) {// 날짜를 키값으로
			Time wardStartTime = new Time("00", "00");
			Time wardEndTime = new Time(wardStartTime);
			wardEndTime.increaseTime(runTime);
			System.out.println("현재 날짜 : " + key);
			System.out.println("새 와드의 시작 시간 : " + wardStartTime);
			System.out.println("새 와드의 종료 시간 :" + wardEndTime);
			System.out.println();
			// 24시까지 와드를 생성 할 수 있는 루프
			while (wardEndTime.getHourInt() < 24) {
				// 해당 날짜의 Event를 하나씩 가져와서 비교
				for (EventParticipantInfoDTO event : dayEventParticipantInfoMap.get(key)) {
					if(wardStartTime.compare(event.getsTime()) >=0 && wardEndTime.compare(event.geteTime()) <= 0){
						wardStartTime.setTime(event.geteTime());
						wardEndTime.setTime(wardStartTime); // 새 와드의 종료 시간은 새와드의 시작 시간 + runtime시간
						wardEndTime.increaseTime(runTime);
					}else if (wardEndTime.compare(event.getsTime()) == 0) { // 와드의 종료시간과 이벤트의 시작 시간이 겹침
						// 와드를 생성
						Ward ward = new Ward(key, key, wardStartTime.getTime(), wardEndTime.getTime());
						wards.add(ward);

						wardStartTime.setTime(event.geteTime());// 새 와드의 시작 시간은
																// 현재 이벤트의 종료시간
						wardEndTime.setTime(wardStartTime); // 새 와드의 종료 시간은 새와드의
															// 시작 시간 + runtime시간
						wardEndTime.increaseTime(runTime);
						break;
					}
				}
				if(wardStartTime.compare("24:00") == 0){
					break;
				}
				wardEndTime.increaseHalfTime();
				System.out.println("변경된 새 와드의 종료시간 : " + wardEndTime);
				if(wardEndTime.compare("24:00") == 0){
					// 와드를 생성
					Ward ward = new Ward(key, key, wardStartTime.getTime(), wardEndTime.getTime());
					wards.add(ward);
					break;
				}
			}
		}
		System.out.println(wards.size());
		for(Ward w : wards){
			System.out.println(w);
		}
	}

	// 1. 참가자들의 모든 일정 가져오기
	public List<EventParticipantInfoDTO> getParticiantEvents(List<String> particiantsEmails) {

		List<EventParticipantInfoDTO> events = new ArrayList<EventParticipantInfoDTO>();

		for (String email : particiantsEmails) {

			events.addAll(eventDAO.eventParticipantInfoSearchMail(email));
		}

		return events;
	}

	// 2. 범위 내 일정 가져오기
	public void getScopeInEvents(List<EventParticipantInfoDTO> events, int scope) {

		// 오늘 날짜
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar rightNow = Calendar.getInstance();
		String currentDate = formatter.format(rightNow.getTime());
		// 범위 종료날짜
		rightNow.add(Calendar.DATE, scope);
		String scopeDate = formatter.format(rightNow.getTime()); // 범위 날짜

		for (Iterator<EventParticipantInfoDTO> it = events.iterator(); it.hasNext();) {
			EventParticipantInfoDTO value = it.next();
			if (value.getsDate().compareTo(currentDate) < 0 || value.getsDate().compareTo(scopeDate) > 0) {
				it.remove();
			} else if (value.geteDate().compareTo(currentDate) == 0) {
				it.remove();
			}
		}

	}

	// 3. 일단위로 일정 나누기
	public Map<String, List<EventParticipantInfoDTO>> dayEventParticipantInfoList(List<EventParticipantInfoDTO> events,
			int scope) {
		// 오늘 날짜
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar day = Calendar.getInstance();

		Map<String, List<EventParticipantInfoDTO>> dayEventParticipantInfoMap = new HashMap<String, List<EventParticipantInfoDTO>>();
		for (int i = 1; i <= scope; i++) {
			List<EventParticipantInfoDTO> dayEventParticipantInfos = new ArrayList<EventParticipantInfoDTO>();

			// 모을 날짜

			day.add(Calendar.DATE, 1);
			String scopeDate = formatter.format(day.getTime());
			// System.out.println("for :" + i + "scopeDate : " + scopeDate);

			// 날짜에 해당하는 일정을 모음
			for (EventParticipantInfoDTO event : events) {
				// System.out.println("시작날 : " + event.getsDate() + "끝날 :" +
				// event.geteDate() + "scopeDate : " + scopeDate);
				if (event.getsDate().compareTo(scopeDate) == 0) {
					// System.out.println("시작 날짜가 같다!");
					if (event.geteDate().compareTo(scopeDate) != 0) {
						// System.out.println("엥 근데 끝날짜가 다르다?");
						// 종료날짜가 시작 날짜와 같지 않다는 것은 다음날로 이어진다는 것이므로
						dayEventParticipantInfos.add(new EventParticipantInfoDTO(event.getEventCode(), event.getEmail(),
								event.getTitle(), event.getsDate(), event.getsDate(), // 같은
																						// 날짜를
																						// 넣음,
																						// 즉,
																						// 일정을
																						// 둘로
																						// 쪼개어
																						// 넣음
								event.getsTime(), "24:00", event.getContent(), event.getPlace()));
						// System.out.println("나눠버리자!");
					} else {
						// System.out.println("문제 없다!");
						dayEventParticipantInfos.add(event);
					}
				} else if (event.geteDate().compareTo(scopeDate) == 0) {// 날짜의
																		// 시작 날은
																		// 달라도
																		// 끝이 같은
																		// 날일 경우
					// System.out.println("엥 시작 날짜가 다르다!");
					dayEventParticipantInfos.add(new EventParticipantInfoDTO(event.getEventCode(), event.getEmail(),
							event.getTitle(), event.geteDate(), event.geteDate(), // 같은
																					// 날짜를
																					// 넣음,
																					// 즉,
																					// 일정을
																					// 둘로
																					// 쪼개어
																					// 넣음
							"00:00", event.geteTime(), event.getContent(), event.getPlace()));
					// System.out.println("나눠서 넣자!");
				} else {
					// System.out.println("이날이 아니구나!");
				}
			}
			dayEventParticipantInfoMap.put(scopeDate, dayEventParticipantInfos);
		}

		/*
		 * Set<String> keys = dayEventParticipantInfoMap.keySet(); for (String
		 * key : keys) { for (EventParticipantInfoDTO event :
		 * dayEventParticipantInfoMap.get(key)) { System.out.println("========="
		 * + key + "========="); System.out.println(event); } }
		 */
		// --------------------------------------------------------------------------------------------------

		return dayEventParticipantInfoMap;
	}

	public List<String> possibleEventList(List<EventParticipantInfoDTO> events) {

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
