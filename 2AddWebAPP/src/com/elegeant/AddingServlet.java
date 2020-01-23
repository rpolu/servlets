package com.elegeant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AddingServlet implements Servlet {
	public AddingServlet() {
		System.out.println(" from Constructor");
	}

	public void destroy() {
	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return null;
	}

	public void init(ServletConfig config) throws ServletException {

	}

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String a = req.getParameter("n1");
		String b = req.getParameter("n2");

		int x = Integer.parseInt(a);
		int y = Integer.parseInt(b);
		int result = x + y;

		PrintWriter pw = res.getWriter();
		pw.println(" The Result is : " + result);

	}
}
