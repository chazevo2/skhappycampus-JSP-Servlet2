package com.work.model;

import java.util.ArrayList;

import com.work.util.Utility;

/* 회원 관리를 위한 업무로직(서비스)을 모델링한 클래스 */
public class MemberService {
	private MemberDao dao;

	public MemberService() {
		dao = new MemberDao(); 
	}
	
	// 회원가입
	public boolean signup(Member m) {
		m.setEntryDate(Utility.getCurrentDate());
		m.setGrade("G");
		m.setMileage(0);
		m.setManager("");
		int result = dao.insertMember(m);
		if(result == 1) {
			return true;
		}
		return false;
	}

	// 로그인
	public String login(String memberId, String memberPw) {
		return dao.selectMember(memberId, memberPw);
	}

	// 내정보 조회
	public Member getMyInfo(String memberId) {
		return dao.selectMyInfo(memberId);
	}

	// 전체 회원 조회
	public ArrayList<Member> getMemberList() {
		return dao.selectMemberList();
	}

	public int delMember(String delMemberId) {
		return dao.delMember(delMemberId);
	}
}
