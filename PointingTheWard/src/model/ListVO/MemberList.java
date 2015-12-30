package model.ListVO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import model.beans.Member;

public class MemberList {

	private List<Member> members;

	public MemberList() {
		super();
	}

	public MemberList(List<Member> members) {
		super();
		this.members = members;
	}

	public void add(int index, Member member) {
		members.add(index, member);
	}

	public boolean add(Member member) {
		return members.add(member);
	}

	public boolean addAll(Collection<? extends Member> member) {
		return members.addAll(member);
	}

	public boolean addAll(int index, Collection<? extends Member> member) {
		return members.addAll(index, member);
	}

	public List<Member> searchMemberName(String name) {

		List<Member> mList = new ArrayList<Member>();
		for (Member m : members) {
			if (m.getName().equals(name))
				mList.add(m);
		}
		if (mList.isEmpty())
			return null;
		return mList;
	}

	public Member searchMemberEmail(String email) {

		for (Member m : members) {
			if (m.getEmail().equals(email))
				return m;
		}
		return null;
	}

	public Member searchMemberIDPW(String email, String pwd) {
		for (Member m : members) {
			if (m.getEmail().equals(email) && m.getPwd().equals(pwd))
				return m;
		}
		return null;
	}

	public Member searchMember(Member member) {
		for (Member m : members) {
			if (m.getEmail().equals(member.getEmail()))
				return m;
		}
		return null;
	}

	public boolean modifyMemberName(Member member, String name) {

		Member m = searchMember(member);

		if (m != null) {
			m.setName(name);
			return true;
		}

		return false;
	}

	public boolean modifyMemberEmail(Member member, String email) {

		Member m = searchMember(member);

		if (m != null) {
			m.setEmail(email);
			return true;
		}
		return false;
	}

	public boolean modifyMemberPwd(Member member, String pwd) {

		Member m = searchMember(member);

		if (m != null) {
			m.setPwd(pwd);
			return true;
		}
		return false;
	}

	public boolean modifyMemberLocation(Member member, String location) {

		Member m = searchMember(member);

		if (m != null) {
			m.setLocation(location);
			return true;
		}
		return false;
	}

	public boolean modifyMemberTransportation(Member member, String transportation) {

		Member m = searchMember(member);

		if (m != null) {
			m.setTransportaion(transportation);
			return true;
		}
		return false;
	}

	public boolean modifyMember(Member member, Member newMember) {

		Member m = searchMember(member);

		if (m != null) {
			m = newMember;
			return true;
		}
		return false;
	}

	public int deleteMemberName(String name){
		int i = 0;
		for (Member m : members) {
			if (m.getName().equals(name))
				remove(m);
			i++;
		}
		return i;
	}
	
	public boolean deleteMemberEmail(String email){
		
		for (Member m : members) {
			if (m.getEmail().equals(email))
				remove(m);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberList other = (MemberList) obj;
		if (members == null) {
			if (other.members != null)
				return false;
		} else if (!members.equals(other.members))
			return false;
		return true;
	}

	public int indexOf(Object o) {
		return members.indexOf(o);
	}

	public Member get(int index) {
		return members.get(index);
	}

	public Member set(int index, Member member) {
		return members.set(index, member);
	}

	public boolean contains(Object o) {
		return members.contains(o);
	}

	public int size() {
		return members.size();
	}

	public boolean isEmpty() {
		return members.isEmpty();
	}

	public Iterator<Member> iterator() {
		return members.iterator();
	}

	public int lastIndexOf(Object o) {
		return members.lastIndexOf(o);
	}

	public Member remove(int index) {
		return members.remove(index);
	}

	public boolean remove(Object o) {
		return members.remove(o);
	}

	public void clear() {
		members.clear();
	}

	public List<Member> subList(int fromIndex, int toIndex) {
		return members.subList(fromIndex, toIndex);
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "MemberList [members=" + members + "]";
	}

}
