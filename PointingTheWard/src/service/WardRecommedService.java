package service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import model.beans.Point;
import model.beans.Time;
import model.beans.Ward;
import model.beans.WardStartEndLocation;
import model.list.WardList;
import model.openData.RequestInfo;
import model.openData.StoreZoneDataGetter;
import model.openData.dataForm.StoreZoneDataForm;
import model.openData.template.DataGetterTemplate;
import model.openDataVO.StoreZone;
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
		List<Ward> tempWards = null;
		Map<String, List<EventParticipantInfoDTO>> participantEventInfoMap = null;
		Map<Ward, List<WardStartEndLocation>> wardStartEndLocationMap = new HashMap<Ward, List<WardStartEndLocation>>();

		if (events != null) {// 참가자 일정 있을 경우
			// 2. 범위 내 일정 가져오기
			getScopeInEvents(events, Integer.parseInt(scope));
			// 3. 기간 나눠서 거르기(ver2)
			// 4. 일 단위로 리스트 나누기
			dayEventParticipantInfoMap = dayEventParticipantInfoList(events, Integer.parseInt(scope));
			// 5. ward리스트 뽑기
			tempWards = possiblePlace(dayEventParticipantInfoMap, runTime);
			// 6. 참가자별 일정을 나누기
			participantEventInfoMap = participantEventList(events, emails);
			// 7. ward 이전 시작점 / 이후 도착점 찾기
			wardStartEndLocationMap = getWardStartEndLocation(tempWards, participantEventInfoMap);
			// 8.

		}

	}

	public void possibleEventList(Map<String, List<EventParticipantInfoDTO>> events) {

		List<EventParticipantInfoDTO> list = events.get("2016-01-07");
		int[] hour = new int[25];
		hour[24] = 1;

		for (EventParticipantInfoDTO e : list) {
			int st = Integer.parseInt(e.getsTime().substring(0, 2));
			int et = Integer.parseInt(e.geteTime().substring(0, 2));

			for (int k = st; k < et; k++) {
				hour[k] = 1;
			}
		}

		List<Ward> wList = new ArrayList<Ward>();
		int c = 0;

		while (true) {

			for (int h : hour) {
				if (h == 0) {
					c++;
				}
			}
			if (c == 0)
				break;

			Ward w = new Ward();
			boolean sema = true;
			for (int i = 0; i < hour.length; i++) {
				if (hour[i] == 0) {
					hour[i] = 1;
					if (sema == true) {
						w.setsTime(String.valueOf(i));
						sema = false;
					}
				} else if (hour[i] == 1) {
					if (sema == false) {
						w.seteTime(String.valueOf(i));
						wList.add(w);
						break;
					}
				}
			}

			c = 0;
		}

		for (Ward w : wList) {
			if (w.getsTime().length() == 1)
				w.setsTime("0" + w.getsTime());

			if (w.geteTime().length() == 1)
				w.seteTime("0" + w.geteTime());

			for (EventParticipantInfoDTO e : list) {
				if (w.geteTime().equals(e.getsTime().substring(0, 2))) {
					w.seteTime(w.geteTime().concat(e.getsTime().substring(2, 5)));
				}

				if (w.getsTime().equals(e.geteTime().substring(0, 2))) {
					w.setsTime(w.getsTime().concat(e.geteTime().substring(2, 5)));
				}
			}

			if (w.geteTime().equals("24"))
				w.seteTime(w.geteTime().concat(":00"));
			if (w.getsTime().equals("00"))
				w.setsTime(w.getsTime().concat(":00"));
		}

		for (Ward w : wList)
			System.out.println(w);

	}

	@Test
	public void testttt() {
		List<StoreZone> szList;
		try {
			
			szList = getStreet(new Point(37.570421, 127.001630), "1000");

			for (StoreZone sz : szList) {
				System.out.println(sz.getCtprvnNm());
				System.out.println(sz.getSignguNm());
				System.out.println(sz.getMainTrarNm());
				System.out.println("lat : " +sz.getCoords().getPoints().get(0).getLat());
				System.out.println("lng : " +sz.getCoords().getPoints().get(0).getLng());
				
			//	for (Point p : sz.getCoords().getPoints())
				//	System.out.println("lat : " + p.getLat() + " lng : " + p.getLng());
			}

		} catch (Exception e) {
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
								event.getTitle(), event.getsDate(), event.getsDate(), event.getsTime(), "24:00",
								event.getContent(), event.getPlace(), event.getName(), event.getLocation(),
								event.getTransportation()));
						// System.out.println("나눠버리자!");
					} else {
						// System.out.println("문제 없다!");
						dayEventParticipantInfos.add(event);
					}
				} else if (event.geteDate().compareTo(scopeDate) == 0) {
					// System.out.println("엥 시작 날짜가 다르다!");
					dayEventParticipantInfos
							.add(new EventParticipantInfoDTO(event.getEventCode(), event.getEmail(), event.getTitle(),
									event.geteDate(), event.geteDate(), "00:00", event.geteTime(), event.getContent(),
									event.getPlace(), event.getName(), event.getLocation(), event.getTransportation()));
					// System.out.println("나눠서 넣자!");
				} else {
					// System.out.println("이날이 아니구나!");
				}
			}
			dayEventParticipantInfoMap.put(scopeDate, dayEventParticipantInfos);
		}

		// Set<String> keys = dayEventParticipantInfoMap.keySet();
		/*
		 * for (String key : keys) { for (EventParticipantInfoDTO event :
		 * dayEventParticipantInfoMap.get(key)) { System.out.println("========="
		 * + key + "========="); System.out.println(event); } }
		 */

		return dayEventParticipantInfoMap;
	}

	// 4. 가능한 일정 추출
	public List<Ward> possiblePlace(Map<String, List<EventParticipantInfoDTO>> dayEventParticipantInfoMap,
			String runTime) {
		Set<String> keys = dayEventParticipantInfoMap.keySet();
		List<Ward> wards = new ArrayList<Ward>();

		for (String key : keys) {// 날짜를 키값으로
			Time wardStartTime = new Time("00", "00");
			Time wardEndTime = new Time(wardStartTime);
			wardEndTime.increaseTime(runTime);
			/*
			 * System.out.println("현재 날짜 : " + key); System.out.println(
			 * "새 와드의 시작 시간 : " + wardStartTime); System.out.println(
			 * "새 와드의 종료 시간 :" + wardEndTime); System.out.println();
			 */
			// 24시까지 와드를 생성 할 수 있는 루프
			while (wardEndTime.getHourInt() < 24) {
				// 해당 날짜의 Event를 하나씩 가져와서 비교
				for (EventParticipantInfoDTO event : dayEventParticipantInfoMap.get(key)) {
					if (wardStartTime.compare(event.getsTime()) == 0) {
						wardStartTime.setTime(event.geteTime());
						wardEndTime.setTime(wardStartTime); // 새 와드의 종료 시간은 새와드의
															// 시작 시간 + runtime시간
						wardEndTime.increaseTime(runTime);
					} else if (wardEndTime.compare(event.getsTime()) == 0) {
						Ward ward = new Ward(key, key, wardStartTime.getTime(), wardEndTime.getTime());
						wards.add(ward);

						wardStartTime.setTime(event.geteTime());// 새 와드의 시작 시간은
																// 현재 이벤트의 종료시간
						wardEndTime.setTime(wardStartTime); // 새 와드의 종료 시간은 새와드의
															// 시작 시간 + runtime시간
						wardEndTime.increaseTime(runTime);

						break;
					}
					if (wardEndTime.compare(event.geteTime()) >= 0 && wardStartTime.compare(event.getsTime()) >= 0
							&& wardStartTime.compare(event.geteTime()) < 0) {
						wardStartTime.setTime(event.geteTime());
						wardEndTime.setTime(wardStartTime); // 새 와드의 종료 시간은 새와드의
															// 시작 시간 + runtime시간
						wardEndTime.increaseTime(runTime);
					}
					if (wardEndTime.compare(event.getsTime()) < 0 && wardStartTime.compare(event.getsTime()) < 0
							&& wardEndTime.compare(event.getsTime()) >= 0) {
						wardStartTime.setTime(event.geteTime());
						wardEndTime.setTime(wardStartTime); // 새 와드의 종료 시간은 새와드의
															// 시작 시간 + runtime시간
						wardEndTime.increaseTime(runTime);
					}

				}
				if (wardStartTime.compare("24:00") == 0) {
					break;
				}
				wardEndTime.increaseHalfTime();
				// System.out.println("변경된 새 와드의 종료시간 : " + wardEndTime);
				if (wardEndTime.compare("24:00") == 0) {
					// 와드를 생성
					Ward ward = new Ward(key, key, wardStartTime.getTime(), wardEndTime.getTime());
					wards.add(ward);
					break;
				}
			}
		}
		return wards;
	}

	// 5. 인원 별 일정 분류
	public Map<String, List<EventParticipantInfoDTO>> participantEventList(List<EventParticipantInfoDTO> events,
			List<String> emails) {
		Map<String, List<EventParticipantInfoDTO>> participantEvents = new HashMap<String, List<EventParticipantInfoDTO>>();

		for (String email : emails) {
			List<EventParticipantInfoDTO> eventList = new ArrayList<EventParticipantInfoDTO>();
			for (EventParticipantInfoDTO eventInfo : events) {
				if (eventInfo.getEmail().trim().equals(email)) {
					eventList.add(eventInfo);
				}
			}
			participantEvents.put(email, eventList);
			eventList = null;
		}
		return participantEvents;
	}

	// 6. 와드전 시작 위치와 끝 위치
	public Map<Ward, List<WardStartEndLocation>> getWardStartEndLocation(List<Ward> tempWards,
			Map<String, List<EventParticipantInfoDTO>> participantEventInfoMap) {
		Map<Ward, List<WardStartEndLocation>> wardStartEndLocationMap = new HashMap<Ward, List<WardStartEndLocation>>();
		List<WardStartEndLocation> location = null;

		Set<String> keys = participantEventInfoMap.keySet();
		// 와드들 검사
		for (Ward ward : tempWards) {
			System.out.println("ward : " + ward);
			location = new ArrayList<WardStartEndLocation>();
			// 참가인원대로
			for (String key : keys) {
				EventParticipantInfoDTO beforeEvent = null;
				EventParticipantInfoDTO afterEvent = null;
				String beforeEventLocation = null;
				String afterEventLocation = null;
				// 참가 인원의 이벤트들 검사
				for (EventParticipantInfoDTO event : participantEventInfoMap.get(key)) {
					System.out.println(event);
					beforeEventLocation = event.getLocation();
					afterEventLocation = event.getLocation();
					Time wardsT = new Time(ward.getsTime());
					Time wardeT = new Time(ward.geteTime());
					Time eventsT = new Time(event.getsTime());
					Time eventeT = new Time(event.geteTime());
					if (ward.getsDate().equals(event.getsDate()) && ward.geteDate().equals(event.geteDate())) {
						System.out.println("같은 날");
						if (wardsT.compare(eventeT.getTime()) >= 0) {
							System.out.println("와드전");
							if (beforeEvent == null) {
								beforeEvent = event;
							} else if (new Time(beforeEvent.geteTime()).compare(event.geteTime()) <= 0) {
								beforeEvent = event;
							}

						} else {
							System.out.println("와드후");
							if (afterEvent == null) {
								afterEvent = event;
							} else if (new Time(afterEvent.getsTime()).compare(event.getsTime()) >= 0) {
								afterEvent = event;
							}
						}
					} else
						if (ward.getsDate().equals(event.getsDate()) && !(ward.geteDate().equals(event.geteDate()))) {
						System.out.println("와드 후");
						if (afterEvent == null) {
							afterEvent = event;
						} else if (new Time(afterEvent.getsTime()).compare(event.getsTime()) >= 0) {
							afterEvent = event;
						}
					} else if (!(ward.getsDate().equals(event.getsDate()))
							&& ward.geteDate().equals(event.geteDate())) {
						System.out.println("와드 전");
						if (beforeEvent == null) {
							beforeEvent = event;
						} else if (new Time(beforeEvent.geteTime()).compare(event.geteTime()) <= 0) {
							beforeEvent = event;
						}
					} else {
						System.out.println("다른 날");
					}
				}
				// 한명의 참가인원의 모든 이벤트 검사 완료 다음 인원으로 넘어감
				if (beforeEvent != null) {
					beforeEventLocation = beforeEvent.getPlace();
				}
				if (afterEvent != null) {
					afterEventLocation = afterEvent.getPlace();
				}
				location.add(new WardStartEndLocation(beforeEventLocation, afterEventLocation));
			}
			// 한개 와드의 모든 인원 조사 완료
			wardStartEndLocationMap.put(ward, location);
		}
		// 모든 와드의 시작점 조사 완료
		// 확인

		Set<Ward> WardMapKeys = wardStartEndLocationMap.keySet();
		for (Ward key : WardMapKeys) {
			System.out.println("와드 정보" + key);
			for (WardStartEndLocation wardStartEndLocation : wardStartEndLocationMap.get(key)) {
				System.out.println(wardStartEndLocation);
			}
		}

		return wardStartEndLocationMap;
	}

	// 7. 범위 내 상권 리스트 및 좌표 다가져오기
	public List<StoreZone> getStreet(Point p, String radius) throws UnsupportedEncodingException, IOException {

		String lat = String.valueOf(p.getLat());
		String lng = String.valueOf(p.getLng());

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("type", "xml");
		parameters.put("numOfRows", "999");
		parameters.put("radius", "500");
		parameters.put("cx", lat);
		parameters.put("cy", lng);
		parameters.put("pageNo", "1");

		RequestInfo requestInfo = new RequestInfo("http://apis.data.go.kr/B553077/api/open/sdsc/storeZoneInRadius",
				parameters, "ServiceKey",
				"og2lJU4CeWL4ZEgfp3o%2F17D%2Fj9mbsbSCK4YTwWPF15sGHlakqZEKX8PA%2B6XyAs%2BD0%2FPe24pVucXQckQ%2Fw230tA%3D%3D");

		DataGetterTemplate templete = new StoreZoneDataGetter();
		List<StoreZoneDataForm> infos = templete.getData(requestInfo);

		for (StoreZoneDataForm dataForm : infos)
			System.out.println(dataForm);

		List<StoreZone> szList = new ArrayList<StoreZone>();

		for (StoreZoneDataForm dataForm : infos) {

			dataForm.setCoords(dataForm.getCoords().replace("POLYGON ((", ""));
			dataForm.setCoords(dataForm.getCoords().replace("))", ""));

			StoreZone sz = new StoreZone();

			sz.setCoordNum(Integer.parseInt(dataForm.getCoordNum()));
			sz.setcoordes(dataForm.getCoords());
			sz.setMainTrarNm(dataForm.getMainTrarNm());
			sz.setCtprvnNm((dataForm.getCtprvnNm()));
			sz.setSignguNm(dataForm.getSignguNm());

			szList.add(sz);
		}
		return szList;
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
