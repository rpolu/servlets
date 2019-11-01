package com.prathima;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddingServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num1 = req.getParameter("n1");
		String num2 = req.getParameter("n2");

		int a = Integer.parseInt(num1);
		int b = Integer.parseInt(num2);
		int c = a + b;

		req.setAttribute("sum", c);
		RequestDispatcher rd = req.getRequestDispatcher("/ossss");
		rd.forward(req, resp);
	}

}