/**
 * 
 */
package com.work.model;

/**
 * <pre>
 * 회원 도메인 클래스
 * 
 * ## 적용기술
 * 1. 클래스 정의 : 선언순서 - 멤버변수, 생성자, 메서드, 재정의
 * 2. 멤버변수 정의 : 데이터 타입
 * 3. 생성자 정의 : 중복정의, this 참조변수, this();
 * 4. 메서드 정의
 * 5. toString(), equals(), hashCode() 재정의
 * 6. Encapsulation : 은닉성, 데이터&알고리즘 보호, 사용 편의성
 * 
 * </pre>
 * 
 * @author 박준혁
 * @version ver.1.0
 * @since jdk1.4
 */
public class Member {
	/** 회원아이디 정보 : 최소 6자리 최대 12자리, 식별키 **/
	private String memberId;
	/** 회원비밀번호 정보 : 최소 8자리 최대 12자리, 생략불가 **/
	private String memberPw;
	/** 회원 이름, 생략불가 **/
	private String memberName;
	/** 회원 휴대폰, 생략불가 **/
	private String mobile;
	/** 회원 이메일, 생략불가 **/
	private String email;
	/** 가입일 : 기입일 현재날짜, 날짜형식 년도 4자리. 월 2자리. 일2자리 **/
	private String entryDate;
	/** 회원 등급 : 일반회원 G, 우수회원 S, 관리자 회원 A **/
	private String grade;
	/** 회원 마일리지 : 일반회원 부여 **/
	private int mileage;
	/** 회원 당담자 이름 : 우수회원 배정, 마일리지 100,000 이상인 경우에 우수회원 등급 **/
	private String manager;

	/** 기본 생성자 **/
	public Member() {
	}

	/**
	 * <pre>
	 * 회원 가입 필수 데이터 초기화 생성자
	 * </pre>
	 * 
	 * @param memberId
	 * @param memberPw
	 * @param memberName
	 * @param mobile
	 * @param email
	 */
	public Member(String memberId, String memberPw, String memberName, String mobile, String email) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.mobile = mobile;
		this.email = email;
	}

	/**
	 * <pre>
	 * 회원 가입 전체 데이터 초기화 생성자
	 * </pre>
	 * 
	 * @param memberId
	 * @param memberPw
	 * @param memberName
	 * @param mobile
	 * @param email
	 * @param entryDate
	 * @param grade
	 * @param mileage
	 * @param manager
	 */
	public Member(String memberId, String memberPw, String memberName, String mobile, String email, String entryDate,
			String grade, int mileage, String manager) {
		this(memberId, memberPw, memberName, mobile, email);
		this.entryDate = entryDate;
		this.grade = grade;
		this.mileage = mileage;
		this.manager = manager;
	}

	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	/**
	 * @return the memberPw
	 */
	public String getMemberPw() {
		return memberPw;
	}

	/**
	 * @param memberPw the memberPw to set
	 */
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	/**
	 * @return the memberName
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * @param memberName the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the entryDate
	 */
	public String getEntryDate() {
		return entryDate;
	}

	/**
	 * @param entryDate the entryDate to set
	 */
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * @return the mileage
	 */
	public int getMileage() {
		return mileage;
	}

	/**
	 * @param mileage the mileage to set
	 */
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	/**
	 * @return the manager
	 */
	public String getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(String manager) {
		this.manager = manager;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(memberId);
		builder.append(", ");
		builder.append(memberPw);
		builder.append(", ");
		builder.append(memberName);
		builder.append(", ");
		builder.append(mobile);
		builder.append(", ");
		builder.append(email);
		builder.append(", ");
		builder.append(entryDate);
		builder.append(", ");
		builder.append(grade);
		builder.append(", ");
		builder.append(mileage);
		builder.append(", ");
		builder.append(manager);
		return builder.toString();
	}

}
