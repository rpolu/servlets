package com.elegant;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UserFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("from init()");
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Pre process the Request");
		String firstName = req.getParameter("fn");
        System.out.println(firstName);
        
        
		chain.doFilter(req, resp);// Request goes to servlet .
		
		System.out.println("Post process the Resonse.");
		
		
		
		
		
		
	}

	public void destroy() {
		System.out.println("from destory()");
	}

}
