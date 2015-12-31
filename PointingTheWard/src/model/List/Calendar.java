package model.List;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import model.beans.Event;
import model.beans.Member;
import model.beans.Place;

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
	public Event searchEvent(Event event){
		return new Event();
	}
	public List<Event> searchEventTitle(String title){
		return new ArrayList<Event>();		
	}
	public List<Event> searchEventSdate(String sDate){
		return new ArrayList<Event>();
	}
	public List<Event> searchEventSdateEdate(String sDate,String eDate){
		return new ArrayList<Event>();
	}
	public List<Event> searchEventStime(String stime){
		return new ArrayList<Event>();
	}
	public List<Event> searchEventStimeEtime(String sTime,String etime){
		return new ArrayList<Event>();
	}
	public List<Event> searchEventPlace(Place place){
		return new ArrayList<Event>();
	}
	public List<Event> searchEventParticipants(List<Member> participants){
		return new ArrayList<Event>();
	}
	public boolean modifyEvent(Event event,Event newEvent){
		return false;
	}
	public boolean modifyEventTitle(Event event,String newTitle){
		return false;
	}
	public boolean modifyEventTitle(String sDate,String eDate,String sTime,String eTime,String newTitle){
		return false;
	}
	public boolean modifyEventDate(Event event,String newSdate,String newEdate){
		return false;
	}
	public boolean modifyEventDate(String sDate,String eDate,String sTime,String eTime,String newSdate,String newEdate){
		return false;
	}
	public boolean modifyEventDateTime(Event event,String newStime,String newEtime){
		return false;
	}
	public boolean modifyEventDateTime(String sDate,String eDate,String sTime,String eTime,String newSdate,String newEdate){
		return false;
	}
	public boolean modifyEventContent(Event event,String newContent){
		return false;
	}
	public boolean modifyEventContent(String sDate,String eDate,String sTime,String eTime,String newContent){
		return false;
	}
	public boolean modifyEventPlace(Event event,Place place){
		return false;
	}
	public boolean modifyEventPlace(String sDate,String eDate,String sTime,String eTime,Place place){
		return false;
	}
	public boolean modifyEventParticipants(Event event,List<Member> participants){
		return false;
	}
	public boolean modifyEventParticipants(String sDate,String eDate,String sTime,String eTime,List<Member> participants){
		return false;
	}
	public boolean deleteEvent(Event event){
		return false;
	}
	public boolean deleteEventTitle(String title){
		return false;
	}
	public boolean deleteEventDate(String sDate,String eDate){
		return false;
	}
	public boolean deleteEventDateTime(String sDate,String eDate,String sTime,String eTime){
		return false;
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
