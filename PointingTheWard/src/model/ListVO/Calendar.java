package model.ListVO;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import model.beans.Event;

public class Calendar {
	private List<Event> Events;

	public Calendar() {
		super();
	}

	public Calendar(List<Event> events) {
		super();
		Events = events;
	}
	
	public boolean add(Event e) {
		return Events.add(e);
	}

	public void add(int index, Event element) {
		Events.add(index, element);
	}

	public boolean addAll(Collection<? extends Event> c) {
		return Events.addAll(c);
	}

	public boolean addAll(int index, Collection<? extends Event> c) {
		return Events.addAll(index, c);
	}

	public void clear() {
		Events.clear();
	}

	public boolean contains(Object o) {
		return Events.contains(o);
	}

	public boolean equals(Object o) {
		return Events.equals(o);
	}

	public Event get(int index) {
		return Events.get(index);
	}

	public int indexOf(Object o) {
		return Events.indexOf(o);
	}

	public boolean isEmpty() {
		return Events.isEmpty();
	}

	public Iterator<Event> iterator() {
		return Events.iterator();
	}

	public Event remove(int index) {
		return Events.remove(index);
	}

	public boolean remove(Object o) {
		return Events.remove(o);
	}

	public Event set(int index, Event element) {
		return Events.set(index, element);
	}

	public int size() {
		return Events.size();
	}

	public List<Event> subList(int fromIndex, int toIndex) {
		return Events.subList(fromIndex, toIndex);
	}

	public List<Event> getEvents() {
		return Events;
	}

	public void setEvents(List<Event> events) {
		Events = events;
	}

	@Override
	public String toString() {
		return "Calendar [Events=" + Events + "]";
	}	
}
