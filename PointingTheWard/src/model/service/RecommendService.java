package model.service;

import java.util.List;

import model.ListVO.Calendar;
import model.ListVO.PlaceList;
import model.ListVO.WardList;
/**
 * 와드 추천 서비스 class
 * @author SEONGBONG
 *
 */
public class RecommendService {
	/**
	 * 가능한 일정 조회
	 * @return 가능한 일정들
	 */
	public Calendar possibleEventSearch(List<Calendar> calendar) {
		return new Calendar();
	}
	/**
	 * 가능한 일정에서 가능한 장소 조회
	 * @return 가능한 장소들
	 */
	public PlaceList possiblePlaceSearch(Calendar calendar) {
		return new PlaceList();
	}
	/**
	 * 적합안 일정과 장소를 추천 
	 * @return 실질적으로 가능한 시간과 장소 정보
	 */
	public WardList wardListRecommend(List<Calendar> calendar){
		return new WardList();
	}
	public WardList wardListRecomment(List<Calendar> calendar,PlaceList places){
		return new WardList();
	}
	
}
