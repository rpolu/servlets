package com.prathima;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OutPutServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int result = (int) req.getAttribute("sum");
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		pw.println("The Result is : " + result);
	}

}
