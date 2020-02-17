package com.elegant;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fs")
public class FirstServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String firstName = req.getParameter("fn");
		String lastName = req.getParameter("ln");
		String encodedUrl = resp.encodeURL("./ss?fn=" + firstName + "&ln=" + lastName);
		resp.sendRedirect(encodedUrl);

	}
}
