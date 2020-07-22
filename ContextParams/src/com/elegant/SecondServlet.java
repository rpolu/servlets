package com.elegant;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondServlet implements Servlet {

	ServletConfig servletConfig;

	public void init(ServletConfig config) throws ServletException {
		this.servletConfig = config;
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		ServletContext context = config.getServletContext();

		String un = context.getInitParameter("username");
		String pass = context.getInitParameter("password");

		response.getWriter().println(un + " : " + pass);

	}

	public void destroy() {
	}

	public ServletConfig getServletConfig() {
		return servletConfig;
	}

	public String getServletInfo() {
		return "This servelt is used for do something";
	}

}