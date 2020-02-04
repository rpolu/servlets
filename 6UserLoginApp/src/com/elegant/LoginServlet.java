package com.elegant;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userName = req.getParameter("un");
		String password = req.getParameter("password");

		UserLoginDao userLoginDao = new UserLoginDao();
		boolean isValidUser = userLoginDao.validate(userName, password);

		if (isValidUser) {
			RequestDispatcher rd = req.getRequestDispatcher("/success.jsp");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			rd.forward(req, resp);
		}

	}
}
