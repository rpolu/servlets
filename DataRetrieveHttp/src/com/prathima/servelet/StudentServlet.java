package com.prathima.servelet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prathima.model.StudentModel;
import com.ptathima.service.StudentService;
import com.ptathima.service.impl.StudentServiceImpl;

public class StudentServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rollNum = req.getParameter("rollnum");
		int rno = Integer.parseInt(rollNum);
		
		
		StudentService studentService = new StudentServiceImpl();
		StudentModel studentModel = studentService.getStudentDetails(rno);
		
		
		
		req.setAttribute("sm", studentModel);
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/studentdetails.jsp");
		rd.forward(req, resp);
		
		

	}

}
