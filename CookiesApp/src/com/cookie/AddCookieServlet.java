package com.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ac")
public class AddCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cname = request.getParameter("cn");
		String cvalue = request.getParameter("cv");
		Cookie cookie = new Cookie(cname, cvalue);
		cookie.setMaxAge(60 * 60 * 24 * 365);
		response.addCookie(cookie);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
