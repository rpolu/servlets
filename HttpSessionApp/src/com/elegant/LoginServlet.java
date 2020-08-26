package com.elegant;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("un");
		String age = req.getParameter("ag");
		HttpSession session = req.getSession();
		session.setAttribute("nm", name);
		session.setAttribute("ag", age);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);;
	}
}
