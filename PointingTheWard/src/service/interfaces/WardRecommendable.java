package service.interfaces;

import java.util.List;

import model.beans.Event;
import model.list.Calendar;
import model.list.WardList;

public interface WardRecommendable {
	/**
	 * 가능한 일정을 확인하는 메소드
	 * @param calendars 조합할 회원 별 일정들
	 * @return 가능한 일정들
	 */
	public List<Event> possibleEvent(List<Event> events);
	/**
	 * 일정들중에 가능한 장소를 확인하고 와드목록을 만들어 주는 메소드
	 * @param calendar 확인할 일정들
	 * @return 일정별 가능한 장소정보를 가진 와드들
	 */
	public WardList possiblePlace(List<Event> events);
	/**
	 * 와드목록 중에서 실제로 가능한 와드만 추출하는 메소드
	 * @param wardList 확인할 와드들
	 * @param calendar 비교할 일정들
	 * @return 가능한 와드들
	 */
	public WardList possibleWardListRecommend(WardList wardList,List<Event> events);
}
