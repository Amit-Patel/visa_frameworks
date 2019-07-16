package com.visa.prj.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class QuestionServlet
 */
@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ses = request.getSession(true);
		String answer = new String("Delhi");
		Integer lives = new Integer(5);
		String hidden = new String("*****");
		ses.setAttribute("lives", lives);
		ses.setAttribute("answer", answer); 
		ses.setAttribute("hidden", hidden);
		request.getRequestDispatcher("test.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		HttpSession ses = request.getSession(false);
		char s = request.getParameter("alpha").charAt(0);
		String ans = (String) ses.getAttribute("answer");
		String hidden = (String) ses.getAttribute("hidden");
		Integer lives = (Integer) ses.getAttribute("lives");
		StringBuilder sb = new StringBuilder(hidden);
		boolean match = false;
		
		for (int i = 0; i < ans.length(); i++) {
			if(ans.charAt(i) == s) {
				sb.setCharAt(i, s);
				match = true;
			}
		}
		if(match) {
			hidden = sb.toString();
			ses.setAttribute("hidden", hidden);	
			if(hidden.equals(ans)) {
				response.sendRedirect("home.html");
				return;
			}
		} else if(lives - 1 < 0) {
				response.sendRedirect("home.html");
				return;
			} else {
				ses.setAttribute("lives", lives-1);
			}	
		
		
		request.getRequestDispatcher("test.jsp").forward(request,response);
	}

}
