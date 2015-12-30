package model.ListVO;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import model.beans.Place;

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
