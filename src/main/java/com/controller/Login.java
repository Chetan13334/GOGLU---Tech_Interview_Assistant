package com.controller;

import java.io.IOException;

import com.dao.UserDao;
import com.entity.User;
import com.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("Eemail");
        String password = req.getParameter("Epassword");
        UserService service = new UserService();
        if (service.checkLogin(email,password) ) {

            resp.sendRedirect("profile.html"); // go to profile page
        } else {
            // login failed
            resp.sendRedirect("login.html?message=Invalid+Login");
        }
    }
}