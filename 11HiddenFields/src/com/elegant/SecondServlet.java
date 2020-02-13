package com.elegant;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("fn");
		String lastName = req.getParameter("ln");
		String phno = req.getParameter("phno");
		String email = req.getParameter("email");
		req.setAttribute("fname", firstName);
		req.setAttribute("lname", lastName);
		req.setAttribute("pn", phno);
		req.setAttribute("em", email);
		req.getRequestDispatcher("/showdetails.jsp").forward(req, resp);

	}
}
