package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.jasper.compiler.ErrorDispatcher;

import com.entity.User;
import com.service.UserService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.JspWriter;


@WebServlet("/subform")
public class Registration extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("Ename");
		String email = req.getParameter("Eemail");
		String pass = req.getParameter("Epassword");
		String phone = req.getParameter("Ephone");
		long phoneNo = Long.parseLong(phone);
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPass(pass);
		user.setPhoneno(phoneNo);
		
		UserService service = new UserService();
		boolean isAdded = service.addUser(user);
		System.out.println(isAdded);
		if(isAdded) {
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.forward(req, resp);
		}
		else {
			String message = URLEncoder.encode("You are already registered, please login to continue", "UTF-8");
			resp.sendRedirect("login.html?message=" + message);
		}
		
		
	}

}