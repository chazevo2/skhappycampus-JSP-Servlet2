package com.work.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
//			response.sendRedirect("login.jsp");
			
			// 회원가입완료 안내 메세지를 경고창 메세지로 띄어주고 확인버튼을 클릭하면 login.jsp 페이지로 이동하도록 변경
			// 1. 응답을 위한 mime type과 charset 설정
			response.setContentType("text/html;charset=utf-8");
			// 2. text/html 형식의 응답 출력을 위한 출력 스트림 생성
			PrintWriter out = response.getWriter();
			// 3. 출력스트림을 이용해서 사용자 브라우저에 html 형식의 
			out.println("<script type='text/javascript'>");
			out.println("alert('"+memberId+"님 회원가입이 완료되었습니다. 로그인후 이용바랍니다.')");
			out.println("location.href='login.jsp'");
			out.println("</script>");
		} else {
			// 회원가입 실패
			request.setAttribute("message", "회원가입이 정상적으로 수행되지 않았습니다. 다시 확인하시기 바랍니다.");
			RequestDispatcher nextView = request.getRequestDispatcher("error.jsp");
			nextView.forward(request, response);
		}
		
	}

}
