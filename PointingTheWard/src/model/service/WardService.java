package model.service;

import java.util.Collection;
import java.util.List;

import model.beans.Place;
import model.beans.Ward;

public class WardService {
	
	public boolean  add(int index, Ward element) {
		return false;
	}

	public boolean add(Ward e) {
		return false;
	}

	public List<Ward> searchWardDate(String sDate , String eDate){
		
		return null;
	}
	
	public List<Ward> searchWardTime(String sTime, String eTime){
		
		return null;
	}
	
	public List<Ward> searchWardDateTime(String sDate, String eDate
									   , String sTime, String eTime){
		
		return null;
	}
	
	public List<Ward> searchWardPlace(Place place){
		
		return null;
	}
	
	public Ward searchWard(Ward ward){
		return null;
	}
	
	public boolean modifyWard(Ward ward, Ward newWard){
		
		return false;
	}
	
	public int deleteWardDate(String sDate, String eDate){
		
		return 0;
	}
	
	public int deleteWardTime(String sTime, String eTime){
		return 0;
	}
	
	public int deleteWardDateTime(String sDate, String eDate, String sTime, String eTime){
		return 0;
	}
	
	public int deleteWardPlace(Place place){
		return 0;
	}
	
}
