package com.elegant;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addCookie")
public class AddCookie extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String value = req.getParameter("value");
		
		
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(24*60*60);
		
		resp.addCookie(cookie);
		
		resp.sendRedirect("./addCookie.jsp");

	}
}
