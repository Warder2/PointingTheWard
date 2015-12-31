package service;

import model.beans.Place;
import model.beans.Point;
import service.abstracts.AbstractPlaceService;
import service.interfaces.PlaceSearchable;

public class PlaceSearchService extends AbstractPlaceService implements PlaceSearchable{

	@Override
	public void execute(ServiceRequest request) {
		// TODO Auto-generated method stub
		String placeName = request.getObject("placeName");
		if(placeName != null){
			searchPlaceName(placeName);
		}
		
	}

	@Override
	public Place searchPlace(Place place) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Place searchPlaceName(String name) {
		// TODO Auto-generated method stub
		System.out.println(name);
		return null;
	}

	@Override
	public Place searchPlacePoint(Point point) {
		// TODO Auto-generated method stub
		return null;
	}

}
