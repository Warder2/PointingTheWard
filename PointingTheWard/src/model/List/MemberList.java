package model.List;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import model.beans.Member;
/**
 * 회원을 List로 가지고 있는 클래스
 * @author SEONGBONG
 *
 */
public class MemberList {
	/**
	 * 회원 List
	 */
	private List<Member> members;
	/**
	 * 기본 생성자
	 */
	public MemberList() {
		super();
	}
	/**
	 * 생성자
	 * @param members
	 */
	public MemberList(List<Member> members) {
		super();
		this.members = members;
	}
	/**
	 * 특정 인데스에 회원을 추가하는 메소드
	 * @param index 삽입할 인덱스
	 * @param member 회원
	 */
	public void add(int index, Member member) {
		members.add(index, member);
	}
	/**
	 * 회원을 추가하는 메소드
	 * @param member 회원
	 * @return 회원추가 성공-true 실패-false
	 */
	public boolean add(Member member) {
		return members.add(member);
	}
	/**
	 * 회원을 추가하는 메소드
	 * @param member Member type의 회원
	 * @return 회원추가 성공-true 실패-false
	 */
	public boolean addAll(Collection<? extends Member> member) {
		return members.addAll(member);
	}
	/**
	 * 특정 인데스에 회원을 추가하는 메소드
	 * @param index 추가할 인덱스
	 * @param member Member type의 회원
	 * @return 회원추가 성공-true 실패-false
	 */
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
			if (m.getName().equals(name)){
				remove(m);
				i++;
			}
			
		}
		return i;
	}
	
	public boolean deleteMemberEmail(String email){
		
		for (Member m : members) {
			if (m.getEmail().equals(email)){
				remove(m);
				return true;
			}
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
