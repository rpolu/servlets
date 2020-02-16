package com.elegant;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FirstServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("fn");
		String lastName = req.getParameter("ln");
		
		HttpSession session=req.getSession();
		session.setAttribute("fn", firstName);
		session.setAttribute("ln", lastName);
		
		
		req.getRequestDispatcher("/input2.jsp").forward(req, resp);
	}

}
