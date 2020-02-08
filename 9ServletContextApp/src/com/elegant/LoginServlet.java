package com.elegant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = getServletContext();
		
		
		String cs = context.getInitParameter("coure");
		String topic = context.getInitParameter("topic");

		PrintWriter pw = resp.getWriter();
		pw.println(topic);
		pw.println(cs);

	}

}
