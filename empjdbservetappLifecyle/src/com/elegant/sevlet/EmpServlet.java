package com.elegant.sevlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EmpServlet implements Servlet {
	Connection con = null;
	PreparedStatement pst = null;

	public void init(ServletConfig config) throws ServletException {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "tiger");
			String query = "insert into employee values(?,?,?)";
			pst = con.prepareStatement(query);
		} catch (Exception e) {
		}
		System.out.println("request came to init() method");
	}

	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		System.out.println("request came to service() method");

		String eid = req.getParameter("eid");
		String name = req.getParameter("name");
		String sal = req.getParameter("salary");

		try {

			pst.setString(1, eid);
			pst.setString(2, name);
			pst.setString(3, sal);
			pst.executeUpdate();
			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setContentType("text/html");
		resp.getWriter().println("<h1>Data Saved successfully</h1>");

	}

	public void destroy() {
		
		System.out.println(" Servlet. Rip to sevlet");

		try {
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return null;
	}

}
