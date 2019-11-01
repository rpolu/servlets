package com.prathima;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AddingServlet extends GenericServlet {

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