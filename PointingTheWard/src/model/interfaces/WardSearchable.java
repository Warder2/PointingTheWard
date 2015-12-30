package model.interfaces;

import java.util.List;

import model.beans.Place;
import model.beans.Ward;

public interface WardSearchable {
	public List<Ward> searchWardDate(String sDate , String eDate);
	public List<Ward> searchWardTime(String sTime, String eTime);
	public List<Ward> searchWardDateTime(String sDate, String eDate, String sTime, String eTime);
	public List<Ward> searchWardPlace(Place place);
	public Ward searchWard(Ward ward);
}
