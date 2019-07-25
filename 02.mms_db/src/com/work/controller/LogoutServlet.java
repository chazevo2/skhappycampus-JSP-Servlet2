package com.work.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet(name="Logout", urlPatterns={"/logout", "/memberLogout"})
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null) {
			if(session.getAttribute("memberId") != null) {
				session.removeAttribute("memberId");
			}
			if(session.getAttribute("grade") != null) {
				session.removeAttribute("grade");
			}
			session.invalidate();
			
			response.sendRedirect("login.jsp");
		} else {
			request.setAttribute("message", "로그인 후 이용하시기 바랍니다.");
			RequestDispatcher nextView = request.getRequestDispatcher("error.jsp");
			nextView.forward(request, response);
		}
	}

}
