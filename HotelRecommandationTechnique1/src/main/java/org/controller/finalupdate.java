package org.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Adminmodel.hotelmodel;
import org.service.hotelservice;


@WebServlet("/final")
public class finalupdate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int hotelId=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		hotelmodel model=new hotelmodel();
		model.setId(hotelId);
		model.setName(name);
		boolean b=new hotelservice().isupdatehotel(model);
		if(b)
		{
			RequestDispatcher r=request.getRequestDispatcher("newhotelcontroller");
			r.forward(request, response);
		}
		else
		{
			out.println("<h1>some problem is there....</h1>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
