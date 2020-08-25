package com.elegnat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		String n = request.getParameter("name");
		String p = request.getParameter("password");

		if (p.equals("admin123")) {
			printWriter.println("Welcome, " + n);
			HttpSession session = request.getSession();
			session.setAttribute("name", n);
			request.getRequestDispatcher("link.jsp").include(request, response);
		} else {
			printWriter.println("Sorry, username or password error!");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}

	}
}
