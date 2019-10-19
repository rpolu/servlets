package com.ptathima.service.impl;

import com.prathima.dao.StudentDao;
import com.prathima.dao.impl.StudentDaoImpl;
import com.prathima.model.StudentModel;
import com.ptathima.service.StudentService;

public class StudentServiceImpl implements StudentService {

	public StudentModel getStudentDetails(int rollNum) {
		StudentDao dao = new StudentDaoImpl();
		StudentModel model = dao.getStudentDetails(rollNum);
		return model;
	}

}
