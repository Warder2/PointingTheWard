package model.interfaces;

import model.beans.Place;
import model.beans.Point;

public interface PlaceModifiable {
	public boolean modifyPlaceName(String name, String newName);
	public boolean modifyPalcePoint(Point point, Point newPoint);
	public boolean modifyPlace(Place place, Place newPlace);
}
