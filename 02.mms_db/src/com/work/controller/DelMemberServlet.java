package com.work.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.work.model.Member;
import com.work.model.MemberService;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet("/delMember")
public class DelMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		
		if(session.getAttribute("memberId") != null && session.getAttribute("grade").equals("A")) {
			String delMemberId = request.getParameter("memberId");
			MemberService service = new MemberService();
			int result = service.delMember(delMemberId);
			
			// 회원 삭제 후 다시 회원 리스트 출력 요청
			response.sendRedirect("memberList");
		} else {
			request.setAttribute("message", "관리자 전용 서비스입니다. 관리자 로그인후 서비스를 이용하시기 바랍니다.");
			if(session.getAttribute("memberId") != null) {
				session.removeAttribute("memberId");
			}
			if(session.getAttribute("grade") != null) {
				session.removeAttribute("grade");
			}
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}
	}

}
