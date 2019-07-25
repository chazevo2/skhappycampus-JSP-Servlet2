package com.work.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.work.model.Member;
import com.work.model.MemberService;

/**
 * 내정보조회 요청
 * ## 서블릿 : url pattern 설정 방법
 * 1. @WebServlet("/myInfo")
 * 2. @WebServlet(value = "/myInfo")
 * 3. @WebServlet(urlPatterns={"/myInfo", "/member/myInfo"})
 */
@WebServlet(urlPatterns="/myInfo", name="MyInfo", loadOnStartup=1)
public class MyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	public void init() {
//		System.out.println("### loadOnStartup 서블릿 : " + this.getClass().getName());
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null) {
			request.setAttribute("message", "로그인후 회원전용 서비스를 이용하시기 바랍니다.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}
		
		if(session.getAttribute("memberId") != null) {
			String memberId = (String) session.getAttribute("memberId");			
			MemberService service = new MemberService();
			Member member = service.getMyInfo(memberId);
			if(member != null) {
				request.setAttribute("member", member);
				request.getRequestDispatcher("myInfo.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("message", "로그인후 회원전용 서비스를 이용하시기 바랍니다.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}
		
	}

}
