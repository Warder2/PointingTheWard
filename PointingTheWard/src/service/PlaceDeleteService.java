package service;

import model.beans.Place;
import model.beans.Point;
import service.abstracts.AbstractPlaceService;
import service.interfaces.PlaceDelible;

public class PlaceDeleteService extends AbstractPlaceService implements PlaceDelible {

	@Override
	public void execute(ServiceRequest request) {
		// TODO Auto-generated method stub
		Place placeInfo = request.getObject("placeInfo");
		if(placeInfo != null){
			deletePlace(placeInfo);
		}
	}

	@Override
	public boolean deletePlacePoint(Point point) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePlaceName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePlace(Place place) {
		// TODO Auto-generated method stub
		System.out.println("delete: " + place);
		return false;
	}

}
