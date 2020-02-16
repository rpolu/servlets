package com.elegant;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecondServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String phno = req.getParameter("phno");
		String email = req.getParameter("email");
		
		HttpSession session = req.getSession();
		req.setAttribute("fname", session.getAttribute("fn"));
		req.setAttribute("lname", session.getAttribute("ln"));
		
		
		req.setAttribute("pn", phno);
		req.setAttribute("em", email);
		req.getRequestDispatcher("/showdetails.jsp").forward(req, resp);

	}
}
