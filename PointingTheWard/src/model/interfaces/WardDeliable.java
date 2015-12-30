package model.interfaces;

import model.beans.Place;

public interface WardDeliable {
	public int deleteWardDate(String sDate, String eDate);
	public int deleteWardTime(String sTime, String eTime);
	public int deleteWardDateTime(String sDate, String eDate, String sTime, String eTime);
	public int deleteWardPlace(Place place);
}
