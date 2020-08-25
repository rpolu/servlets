package com.elegant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class SecondServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String un = request.getParameter("name");
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<h1>Request Came here through Send Redirect</h1>");
		pw.println("<h2>User Name: "+un+"</h2>");
		
	}
}
