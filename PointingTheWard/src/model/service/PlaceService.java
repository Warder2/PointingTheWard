package model.service;

import model.Abstract.AbstractPlaceService;
import model.beans.Place;
import model.beans.Point;

public class PlaceService extends AbstractPlaceService{
	public void placeCreate(int index, Place place) {

	}

	public boolean placeCreate(Place place) {
		return false;
	}

	public Place searchPlace(Place place) {

		return null;
	}

	public Place searchPlaceName(String name) {

		return null;

	}

	public Place searchPlacePoint(Point point) {

		return null;

	}

	public boolean modifyPlaceName(String name, String newName) {

		return false;

	}

	public boolean modifyPalcePoint(Point point, Point newPoint) {

		return false;
	}

	public boolean modifyPlace(Place place, Place newPlace) {

		return false;
	}

	public boolean deletePlacePoint(Point point) {

		return false;
	}

	public boolean deletePlaceName(String name) {

		return false;
	}

	public boolean deletePlace(Place place) {

		return false;
	}
}
