package org.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Adminmodel.Registermodel;
import org.service.userservice;


@WebServlet("/userReg")
public class userResistercontroller extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Registermodel model=new Registermodel();
		model.setName(name);
		model.setEmail(email);
		model.setContact(contact);
		model.setUsername(username);
		model.setPassword(password);
		userservice us=new userservice();
		boolean b=us.isRegisterUser(model);
		if(b)
		{
			out.println("<h1>user Register Sucessfully......</h1>");
			out.println("<h3>now you can login to application &nbsp;&nbsp;<a href='userlogin.jsp'>Login</a></h3>");
		}
		else
		{
			out.println("<center><h1>Registation failed...</h1></center>");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
