package com.elegant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLoginDao {
	public boolean validate(String userName, String password) {
		boolean isValidUser = false;
		try {
			String driverClass = "com.mysql.cj.jdbc.Driver";
			String dbUrl = "jdbc:mysql://localhost:3306/SYSTEM";
			String dbun = "root";
			String dbPass = "Root@123";
			Class.forName(driverClass);
			Connection con = DriverManager.getConnection(dbUrl, dbun, dbPass);
			String query = "select * from elegant_users where email=? and password=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, userName);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				isValidUser = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isValidUser;
	}

}
