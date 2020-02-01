package com.elegant;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elegant.dao.StudentDao;
import com.elegant.model.StudentModel;

public class StudentRegServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("first_name");
		String lastName = req.getParameter("last_name");
		String address = req.getParameter("address");
		String city = req.getParameter("city");
		String state = req.getParameter("state");
		String zipcode = req.getParameter("zip");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");

		StudentModel studentModel = new StudentModel();
		studentModel.setFirstName(firstName);
		studentModel.setLastName(lastName);
		studentModel.setAddress(address);
		studentModel.setCity(city);
		studentModel.setState(state);
		studentModel.setZipcode(zipcode);
		studentModel.setPhone(phone);
		studentModel.setEmail(email);
		studentModel.setGender(gender);

		StudentDao studentDao = new StudentDao();
		studentDao.saveStudent(studentModel);

		// save db.\\\TODO
		RequestDispatcher rd = req.getRequestDispatcher("/success.jsp");
		rd.forward(req, resp);
	}
}
