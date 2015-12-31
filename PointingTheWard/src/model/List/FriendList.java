package model.List;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import model.beans.Friend;

/**
 * @author Samsung
 *
 */
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

	

	public Friend searchFriendEmail(String email){
		
		for(Friend f : friends){
			if(f.getEmail().equals(email))
				return f;
		}
		return null;
	}
	
	public List<Friend> searchFriendName(String name){
		
		List<Friend> fList = new ArrayList<Friend>();
		
		for(Friend f : friends){
			fList.add(f);
		}
		if(fList.isEmpty())
			return null;
		return fList;
	}
	
	public Friend searchFriend(Friend friend){
		for(Friend f : friends){
			if(f.getEmail().equals(friend.getEmail()))
				return f;
		}
		return null;
	}

	
	public boolean modifyFriendName(String email, String name){
		
		Friend f = searchFriendEmail(email);
		
		if(f != null){
			f.setName(name);
			return true;	
		}
		return false;
	}
	
	public boolean modifyFriendEmail(String email, String newMail){
		
		Friend f= searchFriendEmail(email);
		
		if(f != null){
			f.setEmail(email);
			return true;
		}
		return false;
	}
	
	public boolean modifyFriend(String email, Friend newFriend){
		
		Friend f= searchFriendEmail(email);
		
		if(f != null){
			f = newFriend;
			return true;
		}
		return false;
	}
	
	public boolean modifyFriend(Friend friend, Friend newFriend){
		
		Friend f= searchFriendEmail(friend.getEmail());
		
		if(f != null){
			f = newFriend;
			return true;
		}
		return false;
	}
	
	
	public int deleteFriendName(String name){
	
		int i  = 0;
		
		for(Friend f : friends){
			if(f.getName().equals(name)){
				remove(f);
				i++;
			}
		}
		
		return i;
	}
	
	public boolean deleteFriendEmail(String email){
		
		for(Friend f : friends){
			
			if(f.getEmail().equals(email)){
				remove(f);
				return true;
			}
		}
		return false;
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
