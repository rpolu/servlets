package com.elegant.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getUserDe")
public class UserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		UserDao userDao = new UserDao();
		StudentModel studentModel = userDao.getUserDeatils(email);
		req.setAttribute("sm", studentModel);
		req.getRequestDispatcher("/userDetails.jsp").forward(req, resp);

	}

}
