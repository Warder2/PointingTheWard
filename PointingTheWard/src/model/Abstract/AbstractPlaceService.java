package model.Abstract;

import model.ListVO.PlaceList;
import model.interfaces.PlaceCreatable;
import model.interfaces.PlaceDelible;
import model.interfaces.PlaceModifiable;
import model.interfaces.PlaceSearchable;

public abstract class AbstractPlaceService implements PlaceCreatable, PlaceSearchable, PlaceModifiable, PlaceDelible {
	private static PlaceList places;

	static {
		AbstractPlaceService.places = new PlaceList();
	}

	public static PlaceList getPlaces() {
		return places;
	}

	public static void setPlaces(PlaceList places) {
		AbstractPlaceService.places = places;
	}
}
