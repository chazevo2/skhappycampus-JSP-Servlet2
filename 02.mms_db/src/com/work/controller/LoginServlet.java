package com.work.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.work.model.MemberService;

/**
 * Servlet implementation class Login
 * 
 * ## 서블릿(Controller) 역할
 * 1. 요청파악 : login
 * 2. 요청데이터추출 : 로그인 추출
 * 3. 요청데이터 검증
 * 4. Model 요청 의뢰 : 데이터 검증 완료후
 * 5. Model 요청 결과 받아서 응답위한 설정
 * 6. 응답페이지 이동
 * 7. 응답페이지 : 결과 가져와서 화면 이동
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 2. 요청 데이터 추출
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
//		System.out.println("id : " + memberId + ", 길이 : " + memberId.trim().length());
//		System.out.println("pw : " + memberPw + ", 길이 : " + memberPw.trim().length());
		
		// 3. 요청 데이터 검증
		// 아이디 : 필수 입력항목, 최소 4자리 이상
		// 비밀번호 : 필수 입력항목, 최소 6자리 이상
		// 페이지 이동 방식 : forward, redirect
		// html5 pattern 정규식 이용
		/*if(memberId==null || memberId.trim().length() < 6) {
			request.setAttribute("message", "아이디는 6자리 이상 입력하시기 바랍니다.");
			RequestDispatcher nextView = request.getRequestDispatcher("error.jsp");
			nextView.forward(request, response);
			return;
		}
		if(memberPw==null || memberPw.trim().length() < 8) {
			request.setAttribute("message", "비밀번호는 8자리 이상 입력하시기 바랍니다.");
			RequestDispatcher nextView = request.getRequestDispatcher("error.jsp");
			nextView.forward(request, response);
			return;
		}*/
		
		MemberService service = new MemberService();
		String grade = service.login(memberId, memberPw);
		
		if(grade != null) {
			// 로그인 성공
			HttpSession session = request.getSession(/*true*/);
			session.setAttribute("memberId", memberId);
			session.setAttribute("grade", grade);
			
			response.sendRedirect("main.jsp");
		} else {
			// 로그인 실패
			request.setAttribute("message", "로그인 실패하였습니다. 아이디와 비번을 확인하시기 바랍니다.");
			RequestDispatcher nextView = request.getRequestDispatcher("error.jsp");
			nextView.forward(request, response);
		}
	}

}
