package model.List;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import model.beans.Place;
import model.beans.Point;

public class PlaceList {
	private List<Place> places;

	public PlaceList() {
		super();
	}

	public PlaceList(List<Place> places) {
		super();
		this.places = places;
	}
	
	public void add(int index, Place element) {
		places.add(index, element);
	}

	public boolean add(Place e) {
		return places.add(e);
	}

	public boolean addAll(Collection<? extends Place> c) {
		return places.addAll(c);
	}

	public boolean addAll(int index, Collection<? extends Place> c) {
		return places.addAll(index, c);
	}

	public Place searchPlace(Place place){
		
		for(Place p : places){
			if(p.equals(place)) return p;
		}
		
		return null;
	}
	
	public Place searchPlaceName(String name){
		
		
		for(Place p : places){
			if(p.getName().equals(name))
				return p;
		}
		
		return null;
		
	}
	
	public Place searchPlacePoint(Point point){
		
		for(Place p : places){
			if(p.getPoint().equals(point));
				return p;
		}
		return null;
		
	}
	
	public boolean modifyPlaceName(String name, String newName){
		
		Place p = searchPlaceName(name);
		
		if( p!= null){
			p.setName(newName);
			return true;
		}
		return false;
		
	}
	
	public boolean modifyPalcePoint(Point point , Point newPoint){
		
		Place p = searchPlacePoint(point);
		
		if( p!= null){
			p.setPoint(newPoint);
			return true;
		}
		return false;
	}
	
	public boolean modifyPlace(Place place, Place newPlace){
		
		Place p = searchPlace(place);
		
		if( p!= null){
			p = newPlace;
			return true;
		}
		
		return false;
	}
	
	public boolean deletePlacePoint(Point point){
		
		Place p = searchPlacePoint(point);
		
		if( p != null){
			remove(p);
			return true;
		}
		
		return false;
	}
	
	public boolean deletePlaceName(String name){
		
		Place p = searchPlaceName(name);
		
		if( p != null){
			remove(p);
			return true;
		}
		
		return false;
	}
	
	public boolean deletePlace(Place place){
		
		Place p = searchPlace(place);
		
		if( p != null){
			remove(p);
			return true;
		}
		
		return false;
	}
	
	
	
	
	public void clear() {
		places.clear();
	}

	public boolean contains(Object o) {
		return places.contains(o);
	}

	public boolean equals(Object o) {
		return places.equals(o);
	}

	public Place get(int index) {
		return places.get(index);
	}

	public int indexOf(Object o) {
		return places.indexOf(o);
	}

	public boolean isEmpty() {
		return places.isEmpty();
	}

	public Iterator<Place> iterator() {
		return places.iterator();
	}

	public int lastIndexOf(Object o) {
		return places.lastIndexOf(o);
	}

	public Place remove(int index) {
		return places.remove(index);
	}

	public boolean remove(Object o) {
		return places.remove(o);
	}

	public Place set(int index, Place element) {
		return places.set(index, element);
	}

	public int size() {
		return places.size();
	}

	public List<Place> subList(int fromIndex, int toIndex) {
		return places.subList(fromIndex, toIndex);
	}

	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}

	@Override
	public String toString() {
		return "PlaceList [places=" + places + "]";
	}
	
}
