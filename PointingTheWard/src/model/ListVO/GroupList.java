package model.ListVO;

import java.security.acl.Group;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class GroupList {
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
