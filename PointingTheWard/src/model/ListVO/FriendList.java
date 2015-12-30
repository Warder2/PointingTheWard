package model.ListVO;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import model.beans.Friend;

public class FriendList {
	private List<Friend> friends;

	public FriendList() {
		super();
	}

	public FriendList(List<Friend> friends) {
		super();
		this.friends = friends;
	}

	public boolean add(Friend e) {
		return friends.add(e);
	}

	public void add(int index, Friend element) {
		friends.add(index, element);
	}

	public boolean addAll(Collection<? extends Friend> c) {
		return friends.addAll(c);
	}

	public boolean addAll(int index, Collection<? extends Friend> c) {
		return friends.addAll(index, c);
	}

	public void clear() {
		friends.clear();
	}

	public boolean contains(Object o) {
		return friends.contains(o);
	}

	public boolean equals(Object o) {
		return friends.equals(o);
	}

	public Friend get(int index) {
		return friends.get(index);
	}

	public int indexOf(Object o) {
		return friends.indexOf(o);
	}

	public boolean isEmpty() {
		return friends.isEmpty();
	}

	public Iterator<Friend> iterator() {
		return friends.iterator();
	}

	public int lastIndexOf(Object o) {
		return friends.lastIndexOf(o);
	}

	public Friend remove(int index) {
		return friends.remove(index);
	}

	public boolean remove(Object o) {
		return friends.remove(o);
	}

	public Friend set(int index, Friend element) {
		return friends.set(index, element);
	}

	public int size() {
		return friends.size();
	}

	public List<Friend> subList(int fromIndex, int toIndex) {
		return friends.subList(fromIndex, toIndex);
	}

	public List<Friend> getFriends() {
		return friends;
	}

	public void setFriends(List<Friend> friends) {
		this.friends = friends;
	}

	@Override
	public String toString() {
		return "FriendList [friends=" + friends + "]";
	}
	
}
