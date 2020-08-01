package com.elegent;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter2 implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("from filter init method");

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response.getWriter().println("from Filter 2 before servlet request");
		chain.doFilter(request, response);// invoke the Servlet
		response.getWriter().println("from Filter 2 after the  servlet Response");
	}

	public void destroy() {
		System.out.println("from Filter destory method");
	}

}
