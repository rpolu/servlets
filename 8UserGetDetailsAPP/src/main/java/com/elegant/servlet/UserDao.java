package com.elegant.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	Connection con;

	public static final String GET_STUDENT_DETAILS = "SELECT * FROM ELEGENT_STUDENTS WHERE EMAIL=? ";

	public UserDao() {
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

	public StudentModel getUserDeatils(String email) {

		StudentModel model = new StudentModel();

		try {
			PreparedStatement pst = con.prepareStatement(GET_STUDENT_DETAILS);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				model.setFirstName(rs.getString("FIRSTNAME"));
				model.setLastName(rs.getString("LASTNAME"));
				model.setAddress(rs.getString("ADDRESS"));
				model.setCity(rs.getString("CITY"));
				model.setState(rs.getString("STATE"));
				model.setZipcode(rs.getString("ZIP"));
				model.setPhone(rs.getString("PHONENUM"));
				model.setGender(rs.getString("GENDER"));

			}
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return model;

	}

}
