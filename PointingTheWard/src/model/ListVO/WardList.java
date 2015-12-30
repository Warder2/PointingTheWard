package model.ListVO;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import model.beans.Ward;

public class WardList {
	private List<Ward> wards;

	public WardList() {
		super();
	}

	public WardList(List<Ward> wards) {
		super();
		this.wards = wards;
	}

	public List<Ward> getWards() {
		return wards;
	}

	public void add(int index, Ward element) {
		wards.add(index, element);
	}

	public boolean add(Ward e) {
		return wards.add(e);
	}

	public boolean addAll(Collection<? extends Ward> c) {
		return wards.addAll(c);
	}

	public boolean addAll(int index, Collection<? extends Ward> c) {
		return wards.addAll(index, c);
	}

	public void clear() {
		wards.clear();
	}

	public boolean contains(Object o) {
		return wards.contains(o);
	}

	public boolean equals(Object o) {
		return wards.equals(o);
	}

	public Ward get(int index) {
		return wards.get(index);
	}

	public int indexOf(Object o) {
		return wards.indexOf(o);
	}

	public boolean isEmpty() {
		return wards.isEmpty();
	}

	public Iterator<Ward> iterator() {
		return wards.iterator();
	}

	public int lastIndexOf(Object o) {
		return wards.lastIndexOf(o);
	}

	public Ward remove(int index) {
		return wards.remove(index);
	}

	public boolean remove(Object o) {
		return wards.remove(o);
	}

	public Ward set(int index, Ward element) {
		return wards.set(index, element);
	}

	public int size() {
		return wards.size();
	}

	public List<Ward> subList(int fromIndex, int toIndex) {
		return wards.subList(fromIndex, toIndex);
	}

	public void setWards(List<Ward> wards) {
		this.wards = wards;
	}

	@Override
	public String toString() {
		return "WardList [wards=" + wards + "]";
	}
	
}
