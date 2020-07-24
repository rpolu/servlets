package com.elegant;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyEmpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String empId = request.getParameter("eid");
		response.getWriter().println("<h1>" + empId + "Emp Details Got Sucess</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String e1=request.getParameter("n1");
		String e2=request.getParameter("n2");
		String e3=request.getParameter("n3");
		response.setContentType("text/html");
		response.getWriter().println("<h1>Emp Details Saved  Sucess "+ e1+" "+e2+" "+ e3+" "+"</h1>");
		

	}

}
