package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.entity.User;

public class UserDao {
	public Connection dbConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/goglumain", "root", "Chetan@123");
			return c;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public int addUser(User user) {
		Connection c = dbConnection();

		PreparedStatement ps;
		try {
			ps = c.prepareStatement("insert into goglu (Ename,Eemail,Epassword,Ephone)values(?,?,?,?)");
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPass());
			ps.setLong(4, user.getPhoneno());
			return ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
			return 0;
		}
		

	}
	
	public ResultSet checkLogin(String email) {
		Connection c = dbConnection();
		try {
			PreparedStatement ps = c.prepareStatement("select Eemail, Epassword from goglu where Eemail=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}