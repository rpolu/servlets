package com.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.user.prathima.model.UserVo;

public class UserDao {
	public void saveUser(UserVo user) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "tiger");
			String query = "insert into users values (?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, user.getFname());
			pst.setString(2, user.getLname());
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getPswd());
			pst.setString(5, user.getRpass());
			pst.executeUpdate();
			pst.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
