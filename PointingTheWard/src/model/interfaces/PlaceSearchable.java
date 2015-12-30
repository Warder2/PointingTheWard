package model.interfaces;

import model.beans.Place;
import model.beans.Point;

public interface PlaceSearchable {
	public Place searchPlace(Place place);
	public Place searchPlaceName(String name);
	public Place searchPlacePoint(Point point);
}
