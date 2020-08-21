package com.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewCookies")
public class ViewCookieServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println("<table border='1'>");
		pw.println("<tr> <th>Name Of Cookie</th><th>Value Of Cookie</th></tr>");
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			pw.println("<tr> <td>" + c.getName() + "</td><td>" + c.getValue() + "</td></tr>");
		}
		pw.println("</table>");
		pw.println("<a href='./index.jsp'>Add More Cookies</a>");
		pw.close();

	}
}
