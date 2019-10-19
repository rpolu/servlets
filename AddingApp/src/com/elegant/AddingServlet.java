package com.elegant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddingServlet
 */
public class AddingServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num1 = request.getParameter("n1");
		String num2 = request.getParameter("n2");

		int n1 = Integer.parseInt(num1);
		int n2 = Integer.parseInt(num1);

		int c = n1 + n2;
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println("<h1>The result is :" + c + "<h1>");
	}

}
