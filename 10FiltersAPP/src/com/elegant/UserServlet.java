package com.elegant;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("fn");
		String lastName = req.getParameter("ln");

		req.setAttribute("fname", firstName);
		req.setAttribute("lname", lastName);

		RequestDispatcher rd = req.getRequestDispatcher("/showdetails.jsp");
		rd.forward(req, resp);
	}
}
