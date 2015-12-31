package service;

import model.beans.Place;
import model.beans.Point;
import service.abstracts.AbstractPlaceService;
import service.interfaces.PlaceModifiable;

public class PlaceModifyService extends AbstractPlaceService implements PlaceModifiable{

	@Override
	public void execute(ServiceRequest request) {
		// TODO Auto-generated method stub
		Place placeInfo = request.getObject("placeInfo");
		Place newPlaceInfo = request.getObject("newPlaceInfo");
		if(placeInfo != null){
			modifyPlace(placeInfo, newPlaceInfo);
		}
		
	}

	@Override
	public boolean modifyPlaceName(String name, String newName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyPalcePoint(Point point, Point newPoint) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyPlace(Place place, Place newPlace) {
		// TODO Auto-generated method stub
		System.out.println(place);
		System.out.println(newPlace);
		return false;
	}

}
