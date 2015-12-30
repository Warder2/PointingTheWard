package model.service;

import java.util.ArrayList;
import java.util.List;

import model.Abstract.AbstractMemberService;
import model.beans.Member;
/**
 * 회원에 관한 서비스를 제공하는 클래스
 * @author SEONGBONG
 *
 */
public class MemberService extends AbstractMemberService{
	/**
	 * 로그인
	 * @param email
	 * @param pwd
	 * @return 로그인 성공여부
	 */
	public boolean SingIn(String email,String pwd){
		return false;
	}
	/**
	 * 회원가입
	 * @param member
	 * @return 회원가입 성공여부
	 */
	public boolean SingUp(Member member){
		return false;
	}
	/**
	 * 회원가입
	 * @param email
	 * @param name
	 * @param pwd
	 * @param location
	 * @param transportation
	 * @return 회원가입 성공여부
	 */
	public boolean SingUp(String email,String name,String pwd,String location,String transportation){
		return false;
	}
	/**
	 * 회원 검색
	 * @param member
	 * @return 검색한 회원정보
	 */
	public Member searchMember(Member member){
		//구현해야함
		return new Member();
	}
	/**
	 * 회원검색(email)
	 * @param email 이메일
	 * @return 검색한 회원정보
	 */
	public Member searchMemberEmail(String email){
		//구현해야함
		return new Member();
	}
	/**
	 * 회원검색
	 * @param name 이름
	 * @return 같은 이름을 가지는 모든 회원
	 */
	public List<Member> searchMemberName(String name){
		//구현해야함
		return new ArrayList<Member>();
	}
	/**
	 * 회원정보 수정
	 * @param member
	 * @param newMember
	 * @return 회원정보 수정 상태 성공-true 실패-false
	 */
	public boolean modifyMember(Member member, Member newMember){
		
		return false;
	}
	/**
	 * 회원정보 수정
	 * @param email 이메일
	 * @param newMember
	 * @return 회원정보 수정 상태 성공-true 실패-false
	 */
	public boolean modifyMemberEmail(String email, Member newMember){
		
		return false;
	}
	/**
	 * 회원 삭제
	 * @param member
	 * @return 회원정보 삭제 상태 성공-true 실패-false
	 */
	public boolean removeMember(Member member){
		return false;
	}
	/**
	 * 회원 삭제
	 * @param email 이메일
	 * @return 회원정보 삭제 상태 성공-true 실패-false
	 */
	public boolean removeMemberEmail(String email){
		return false;
	}
	/**
	 * 회원 삭제
	 * @param name 이름
	 * @return 성공적으로 삭제한 수
	 */
	public int removeMemberName(String name){
		return 1;
	}	
}
