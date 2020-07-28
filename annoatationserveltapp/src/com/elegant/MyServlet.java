package com.elegant;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = "/asg", 
		loadOnStartup = 1,
		initParams = @WebInitParam(name = "name", value = "rama")
)
public class MyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		String value = config.getInitParameter("name");
		response.setContentType("text/html");
		response.getWriter().println("<h2> welcome Annocations " + value + "<h2>");
	}
}
