package service;

import java.util.List;

import model.list.Calendar;
import model.list.WardList;
import service.abstracts.AbstractWardService;
import service.interfaces.WardRecommendable;

public class WardRecommedService extends AbstractWardService implements WardRecommendable{

	@Override
	public void execute(ServiceRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Calendar possibleEvent(List<Calendar> calendars) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WardList possiblePlace(Calendar calendar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WardList possibleWardListRecommend(WardList wardList, Calendar calendar) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
