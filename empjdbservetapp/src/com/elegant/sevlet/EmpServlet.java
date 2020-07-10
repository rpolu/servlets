package com.elegant.sevlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EmpServlet implements Servlet {

	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {

		String eid = req.getParameter("eid");
		String name = req.getParameter("name");
		String sal = req.getParameter("salary");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "tiger");

			String query = "insert into employee values(?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, eid);
			pst.setString(2, name);
			pst.setString(3, sal);
			pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setContentType("text/html");
		resp.getWriter().println("<h1>Data Saved successfully</h1>");

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

}
