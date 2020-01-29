package com.elegant;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class InitServlet implements Servlet {
	private ServletConfig config;

	public InitServlet() {
		System.out.println("from Constructor");
	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("from Init");
		this.config = config;
		String nameOfTheCourse = config.getInitParameter("course");
		String topic = config.getInitParameter("topic");
		System.out.println(nameOfTheCourse + " ---- " + topic);
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		ServletConfig config = getServletConfig();
		String nameOfTheCourse = config.getInitParameter("course");
		String topic = config.getInitParameter("topic");
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<html><body  bgcolor=\"#E0FFFF\"><center>");
		pw.println(nameOfTheCourse + "<br>");
		pw.println(request.getParameter("un") + "<br>");
		pw.println(topic);
		pw.println("</body></center></html>");
		pw.close();
	}

	public void destroy() {
	}

	public ServletConfig getServletConfig() {
		return config;
	}

	public String getServletInfo() {
		return " This is i have return for Learn the initi parameters";
	}

}
