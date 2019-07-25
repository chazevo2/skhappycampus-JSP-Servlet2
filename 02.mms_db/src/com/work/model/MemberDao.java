package com.work.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class MemberDao {
	// ConnectionPooling을 위한 DataSource 객체 멤버 변수 선언
	private DataSource ds;
	
	/** 기본 생성자 : DataSource lookup 설정 초기화
	 * %tomcat_home%\conf\context.xml
	 * => codeName = "java/comp/env/"
	 *  => name = "jdbc/Oracle"
	 */
	public MemberDao() {
		String dsName = "java:comp/env/jdbc/Oracle";
		try {
			ds = (DataSource) (new InitialContext().lookup(dsName));
		} catch (NamingException e) {
			System.out.println("error:ds lookup error");
			e.printStackTrace();
		}
	}
	
	// 회원 가입
	public int insertMember(Member m) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// db 서버 연결
			conn = ds.getConnection();
			// sql 통로 개설
			String sql = "insert into members values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getMobile());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getEntryDate());
//			pstmt.setDate(6, Utility.returnCurrentDate(m.getEntryDate()));
			pstmt.setString(7, m.getGrade());
			pstmt.setInt(8, m.getMileage());
			pstmt.setString(9, m.getManager());

			// sql 수행요청
			// sql 수행 결과 처리
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error : 레코드 추가시 오류 발생");
			e.printStackTrace();
		} finally {
			// 자원 해제
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println("Error : 자원 해제시 오류 발생");
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	// 로그인
	public String selectMember(String memberId, String memberPw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ds.getConnection();
			
			String sql = "select grade from members where member_id=? and member_pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getString("grade");
			}
		} catch (SQLException e) {
			System.out.println("Error : 로그인 오류 발생");
			e.printStackTrace();
		} finally {
			// 자원 해제
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println("Error : 자원 해제시 오류 발생");
				e.printStackTrace();
			}
		}
		return null;
	}
	
	// 내정보 조회
	public Member selectMyInfo(String memberId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ds.getConnection();
			
			String sql = "select * from members where member_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return new Member(rs.getString("member_id"), rs.getString("member_pw"), rs.getString("member_name"), rs.getString("mobile"), 
						rs.getString("email"), rs.getString("entry_date"), rs.getString("grade"), rs.getInt("mileage"), rs.getString("manager"));
			}
		} catch (SQLException e) {
			System.out.println("Error : 내정보 찾기 오류 발생");
			e.printStackTrace();
		} finally {
			// 자원 해제
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println("Error : 자원 해제시 오류 발생");
				e.printStackTrace();
			}
		}
		return null;
	}
	
	// 회원 목록
	public ArrayList<Member> selectMemberList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ArrayList<Member> list = new ArrayList<Member>();
		try {
			conn = ds.getConnection();
			
			String sql = "select * from members";
			pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new Member(rs.getString("member_id"), rs.getString("member_pw"), rs.getString("member_name"), rs.getString("mobile"), 
						rs.getString("email"), rs.getString("entry_date"), rs.getString("grade"), rs.getInt("mileage"), rs.getString("manager")));
			}
			return list;
		} catch (SQLException e) {
			System.out.println("Error : 내정보 찾기 오류 발생");
			e.printStackTrace();
		} finally {
			// 자원 해제
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println("Error : 자원 해제시 오류 발생");
				e.printStackTrace();
			}
		}
		return null;
	}
	
	// 아이디 찾기
	public String selectId(String memberName, String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ds.getConnection();
			
			String sql = "select * from members where member_name=? and email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberName);
			pstmt.setString(2, email);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getString("member_id");
			}
		} catch (SQLException e) {
			System.out.println("Error : 아이디 찾기 오류 발생");
			e.printStackTrace();
		} finally {
			// 자원 해제
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println("Error : 자원 해제시 오류 발생");
				e.printStackTrace();
			}
		}
		return null;
	}

	public int delMember(String delMemberId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// db 서버 연결
			conn = ds.getConnection();
			// sql 통로 개설
			String sql = "delete from members where member_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, delMemberId);

			// sql 수행요청
			// sql 수행 결과 처리
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error : 레코드 삭제시 오류 발생");
			e.printStackTrace();
		} finally {
			// 자원 해제
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println("Error : 자원 해제시 오류 발생");
				e.printStackTrace();
			}
		}
		return 0;
	}

}
