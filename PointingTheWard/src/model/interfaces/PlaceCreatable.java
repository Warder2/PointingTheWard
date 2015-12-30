package model.interfaces;

import model.beans.Place;

public interface PlaceCreatable {
	public void placeCreate(int index, Place place);
	public boolean placeCreate(Place place);
}
