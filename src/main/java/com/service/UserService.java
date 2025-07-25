package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.UserDao;
import com.entity.User;

public class UserService {
	public boolean addUser(User user) {
		UserDao dao = new UserDao();
		int rowsAff = dao.addUser(user);
		if (rowsAff > 0) {
			return true;
		} else {
			return false;
		}

	}

	public boolean checkLogin(String email, String password) {
	    UserDao dao = new UserDao();
	    ResultSet rs = dao.checkLogin(email);
	    try {
	        if (rs.next()) {
	            String rsEmail = rs.getString("Eemail");
	            String rsPassword = rs.getString("Epassword");

	            if (rsEmail.equals(email) && rsPassword.equals(password)) {
	                return true;
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
}