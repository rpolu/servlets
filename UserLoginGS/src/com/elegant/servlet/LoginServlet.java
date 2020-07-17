package com.elegant.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginServlet extends GenericServlet {
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		String un = req.getParameter("uno");
		String password = req.getParameter("pass");

		UserLoginDao userLoginDao = new UserLoginDao();
		boolean flag = userLoginDao.loginUser(un, password);
		resp.setContentType("text/html");
		if (flag) {
			resp.getWriter().println("<h2>Login Success<h2>");
		} else {
			resp.getWriter().println("<h2>Invalid User<h2>");
		}
	}

}