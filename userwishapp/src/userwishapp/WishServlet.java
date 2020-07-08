package userwishapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class WishServlet implements Servlet {

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("un");
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.println("<h1>");
		pw.println("Welcome :" + name);
		pw.println("</h1>");
		pw.close();
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
