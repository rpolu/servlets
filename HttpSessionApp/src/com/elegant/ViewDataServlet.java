package com.elegant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		HttpSession httpSession = request.getSession();
		String name = (String) httpSession.getAttribute("nm");
		String age = (String) httpSession.getAttribute("ag");

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println(name + " : " + age);
		pw.println("<a href='./index.jsp'>Back To Home Page</a>");
		pw.close();
	}

}
