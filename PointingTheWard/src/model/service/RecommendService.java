package model.service;

import java.util.List;

import model.ListVO.Calendar;
import model.ListVO.PlaceList;
import model.ListVO.WardList;

public class RecommendService {
	/**
	 * 가능한 일정 조회
	 * @return
	 */
	public Calendar possibleEventSearch(List<Calendar> calendar) {
		return new Calendar();
	}
	/**
	 * 가능한 일정에서 가능한 장소 조회
	 * @return
	 */
	public PlaceList possiblePlaceSearch(Calendar calendar) {
		return new PlaceList();
	}
	/**
	 * 적합안 일정과 장소를 추천 
	 * @return
	 */
	public WardList wardListRecommend(List<Calendar> calendar, PlaceList places){
		return new WardList();
	}
}
