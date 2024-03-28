package org.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.service.hotelservice;


@WebServlet("/deleteinfocontroller")
public class deleteinfocontroller extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int hid=Integer.parseInt(request.getParameter("hotelinfoid"));
		boolean b=new hotelservice().isDeletehotelinfo(hid);
		if(b)
		{
				RequestDispatcher r=request.getRequestDispatcher("viewhotelinfo");
				r.forward(request, response);
		}
		else
		{
			out.println("<h1>some problem is here</h1>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
