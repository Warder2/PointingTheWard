package model.interfaces;

import model.beans.Place;
import model.beans.Point;

public interface PlaceDelible {
	public boolean deletePlacePoint(Point point);
	public boolean deletePlaceName(String name);
	public boolean deletePlace(Place place);
}
