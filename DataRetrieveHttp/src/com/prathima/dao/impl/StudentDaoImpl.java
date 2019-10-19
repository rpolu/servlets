package com.prathima.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.prathima.dao.StudentDao;
import com.prathima.model.StudentModel;

public class StudentDaoImpl implements StudentDao {

	public StudentModel getStudentDetails(int rollNum) {
		StudentModel studentModel = new StudentModel();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SYSTEM", "root", "Root@123");
			String query = "select * from student where rollNum=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, rollNum);
			ResultSet rst = pst.executeQuery();
			if (rst.next()) {
				studentModel.setName(rst.getString("NAME"));
				studentModel.setMarks(rst.getInt("MARKS"));
				studentModel.setAddress(rst.getString("ADDRESS"));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return studentModel;
	}

}
