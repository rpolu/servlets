package com.egegant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	public void saveUser(UserModel userModel) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "tiger");
			String query = "INSERT INTO USERS VALUES (?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, userModel.getUid());
			pst.setString(2, userModel.getFname());
			pst.setString(3, userModel.getlName());
			pst.setString(4, userModel.getPh());
			pst.setString(5, userModel.getAddress());
			pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<UserModel> getUserModels() {
		List<UserModel> list = new ArrayList<UserModel>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "tiger");
			String query = "SELECT * from USERS";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				UserModel u = new UserModel();
				u.setUid(rs.getString(1));
				u.setFname(rs.getString(2));
				u.setlName(rs.getString(3));
				u.setPh(rs.getString(4));
				u.setAddress(rs.getString(5));
				list.add(u);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
