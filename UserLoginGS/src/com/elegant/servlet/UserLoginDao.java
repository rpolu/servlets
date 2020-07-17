package com.elegant.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLoginDao {

	public boolean loginUser(String userName, String passowrd) {
		boolean flag = false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String un = "system";
			String password = "tiger";
			Connection con = DriverManager.getConnection(url, un, password);

			String query = "select * from users where username=? and password=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, userName);
			pst.setString(2, passowrd);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				flag = true;
			}
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;

	}

}
