package com.user.prathima;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.user.dao.UserDao;
import com.user.prathima.model.UserVo;

public class UserServlet extends GenericServlet {
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {

		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String pswd = req.getParameter("psw");
		String rpass = req.getParameter("rpsw");

		UserVo userVo = new UserVo();
		userVo.setFname(fname);
		userVo.setLname(lname);
		userVo.setEmail(email);
		userVo.setPswd(pswd);
		userVo.setRpass(rpass);

		UserDao dao = new UserDao();
		dao.saveUser(userVo);

		// save trhe db

		RequestDispatcher rd = req.getRequestDispatcher("/output.jsp");
		rd.forward(req, resp);

	}

}
