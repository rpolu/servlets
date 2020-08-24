package com.egegant;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDao userDao = new UserDao();
		String action = request.getParameter("action");

		if (action != null && action.equalsIgnoreCase("GetAll")) {
			List<UserModel> users=userDao.getUserModels();
			request.setAttribute("users", users);
			RequestDispatcher rd = request.getRequestDispatcher("/getusers.jsp");
			rd.forward(request, response);
		} else if (action != null && action.equalsIgnoreCase("add")) {
			RequestDispatcher rd = request.getRequestDispatcher("/adduser.jsp");
			rd.forward(request, response);
		} else if (action != null && action.equalsIgnoreCase("save")) {
			UserModel um = new UserModel();
			um.setUid(request.getParameter("uid"));
			um.setFname(request.getParameter("fn"));
			um.setlName(request.getParameter("ln"));
			um.setPh(request.getParameter("ph"));
			um.setAddress(request.getParameter("address"));

			userDao.saveUser(um);
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		} else if (action != null && action.equalsIgnoreCase("goback")) {
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
	}

}
