package com.prathima;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AddingServlet implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		String num1 = req.getParameter("n1");
		String num2 = req.getParameter("n2");

		int a = Integer.parseInt(num1);
		int b = Integer.parseInt(num2);
		int c = a + b;
		
		
		req.setAttribute("sum", c);
		RequestDispatcher rd = req.getRequestDispatcher("/result.jsp");
		rd.forward(req, res);

	}

}