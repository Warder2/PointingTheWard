package model.Abstract;

import model.ListVO.FriendList;
import model.ListVO.WardList;

public class AbstractWardService {
	private static WardList wards;
	
	static{
		AbstractWardService.wards = new WardList();
	}
	public static synchronized WardList getWards() {
		return wards;
	}
	public static void setWards(WardList wards) {
		AbstractWardService.wards = wards;
	}	
}
