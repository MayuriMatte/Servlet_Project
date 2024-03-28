package org.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Adminmodel.loginmodel;
import org.service.AdminLoginService;


@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username").trim();
		String password=request.getParameter("password").trim();
	    loginmodel m1=new loginmodel();
	    m1.setUsername(username);
	    m1.setPassword(password);
	    AdminLoginService adservice=new AdminLoginService();
	    boolean b=adservice.isAdminLogin(m1);
	    if(b)
	    {
	    	RequestDispatcher r=request.getRequestDispatcher("nevbar.html");
	    	r.forward(request, response);
	    	
	    }
	    else
	    {
	    	RequestDispatcher r=request.getRequestDispatcher("admin.html");
	    	r.include(request, response);
	    	out.println("Admin login failed.......");
	    }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
