package com.elegant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.elegant.model.StudentModel;

public class StudentDao {
	Connection con = null;

	public StudentDao() {
		try {
			String driverClass = "com.mysql.cj.jdbc.Driver";
			String dbUrl = "jdbc:mysql://localhost:3306/SYSTEM";
			String dbun = "root";
			String dbPass = "Root@123";
			Class.forName(driverClass);
			this.con = DriverManager.getConnection(dbUrl, dbun, dbPass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int saveStudent(StudentModel studentModel) {
		int value = 0;
		String query = "INSERT INTO ELEGENT_STUDENTS"
				+ " (FIRSTNAME,LASTNAME,ADDRESS,CITY,STATE,ZIP,PHONENUM,EMAIL,GENDER) " + "VALUES (?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, studentModel.getFirstName());
			pst.setString(2, studentModel.getLastName());
			pst.setString(3, studentModel.getAddress());
			pst.setString(4, studentModel.getCity());
			pst.setString(5, studentModel.getState());
			pst.setString(6, studentModel.getZipcode());
			pst.setString(7, studentModel.getPhone());
			pst.setString(8, studentModel.getEmail());
			pst.setString(9, studentModel.getGender());
			value = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return value;
	}
}
