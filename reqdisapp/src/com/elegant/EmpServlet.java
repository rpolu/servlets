package com.elegant;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EmpServlet extends GenericServlet {

	public void init(ServletConfig config) throws ServletException {

		String nameInstute = config.getInitParameter("in");
		String adddress = config.getInitParameter("address");

		System.out.println(adddress + " " + nameInstute);

	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		String eid = request.getParameter("e1");
		String name = request.getParameter("e2");
		String salary = request.getParameter("e3");

		request.setAttribute("s1", eid);
		request.setAttribute("s2", name);
		request.setAttribute("s3", salary);

		RequestDispatcher rd = request.getRequestDispatcher("/empoutput.jsp");
		rd.forward(request, response);

	}

}
