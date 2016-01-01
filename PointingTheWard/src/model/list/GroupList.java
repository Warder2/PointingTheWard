package model.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import model.beans.Group;;

public class GroupList{
	private List<Group> groups;

	public GroupList() {
		super();
	}

	public GroupList(List<Group> groups) {
		super();
		this.groups = groups;
	}

	public boolean add(Group e) {
		return groups.add(e);
	}

	public void add(int index, Group element) {
		groups.add(index, element);
	}

	public boolean addAll(Collection<? extends Group> c) {
		return groups.addAll(c);
	}

	public boolean addAll(int index, Collection<? extends Group> c) {
		return groups.addAll(index, c);
	}

	
	public Group searchGroupName(String name){
		
		for(Group g : groups){
			if(g.getName().equals(name))
				return g;
		}
		return null;
	}	
	public Group searchGroup(Group group){
		for(Group g : groups){
			if(g.getName().equals(group.getName()))
				return g;
		}
		return null;
	}
	
	
	public boolean modifyGroupName(String name, String newName){
		
		Group g = searchGroupName(name);
		
		if(g != null){
			g.setName(newName);
			return true;
		}
		return false;
	}
	
	public boolean modifyGroup(String name, Group newGroup){
		
		Group g = searchGroupName(name);
		
		if(g != null){
			g = newGroup;
			return true;
		}
		
		return false;
	}
	
	public boolean modifyGroup(Group group, Group newGroup){
		
		Group g = searchGroupName(group.getName());
		
		if(g != null){
			g = newGroup;
			return true;
		}
		
		return false;
	}
	
	public boolean deleteGroupName(String name){
		
		Group g = searchGroupName(name);
		
		if(g != null){
			remove(g);
			return true;
		}
		return false;
		
	}
	
	public boolean deleteGroup(Group group){
		
		Group g = searchGroup(group);
		
		if(g!= null){
			remove(g);
			return true;
		}
		return false;
	}
	
	public void clear() {
		groups.clear();
	}

	public boolean contains(Object o) {
		return groups.contains(o);
	}

	public boolean equals(Object o) {
		return groups.equals(o);
	}

	public Group get(int index) {
		return groups.get(index);
	}

	public int indexOf(Object o) {
		return groups.indexOf(o);
	}

	public boolean isEmpty() {
		return groups.isEmpty();
	}

	public Iterator<Group> iterator() {
		return groups.iterator();
	}

	public int lastIndexOf(Object o) {
		return groups.lastIndexOf(o);
	}

	public Group remove(int index) {
		return groups.remove(index);
	}

	public boolean remove(Object o) {
		return groups.remove(o);
	}

	public Group set(int index, Group element) {
		return groups.set(index, element);
	}

	public int size() {
		return groups.size();
	}

	public List<Group> subList(int fromIndex, int toIndex) {
		return groups.subList(fromIndex, toIndex);
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	@Override
	public String toString() {
		return "GroupList [groups=" + groups + "]";
	}
	
}
