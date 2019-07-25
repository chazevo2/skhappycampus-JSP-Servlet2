package com.work.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.work.model.Member;
import com.work.model.MemberService;

/**
 * Servlet implementation class Signup
 * 
 * memberId
 * memberPw
 * memberName
 * mobile
 * email
 */
@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// get 방식
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 방식 한글 인코딩
		request.setCharacterEncoding("utf-8");
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		
//		System.out.println(memberId);
//		System.out.println(memberPw);
//		System.out.println(memberName);
//		System.out.println(mobile);
//		System.out.println(email);
		
		MemberService service = new MemberService();
		Member m = new Member(memberId, memberPw, memberName, mobile, email);
		Boolean isSignup= service.signup(m);
		System.out.println(isSignup);
		
		if(isSignup) {
			// 회원가입 성공
			response.sendRedirect("login.jsp");
		} else {
			// 회원가입 실패
			request.setAttribute("message", "회원가입이 정상적으로 수행되지 않았습니다. 다시 확인하시기 바랍니다.");
			RequestDispatcher nextView = request.getRequestDispatcher("error.jsp");
			nextView.forward(request, response);
		}
		
	}

}
