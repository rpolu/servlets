package com.user.login;
import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginServlet extends GenericServlet {

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String userName = req.getParameter("un");
		String password = req.getParameter("ps");
		if (userName.equalsIgnoreCase(password)) {
			res.getWriter().println("Login sucess");
		} else {
			res.getWriter().println("Login Fail");
		}

	}
}
