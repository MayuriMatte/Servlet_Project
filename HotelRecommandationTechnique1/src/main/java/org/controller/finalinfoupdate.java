package org.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Adminmodel.hotelinfomodel;
import org.service.hotelservice;


@WebServlet("/finalinfoupdate")
public class finalinfoupdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int hotelId=Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		String location=request.getParameter("location");
		String address=request.getParameter("address");
		hotelinfomodel model=new hotelinfomodel();
		model.setInfoid(hotelId);
		model.setName(name);
		model.setEmail(email);
		model.setContact(contact);
		model.setLocation(location);
		model.setAddress(address);
		
		hotelservice hotelserv = new hotelservice();
		boolean b=hotelserv.isupdateinfohotel(model);
			if(b)
			{
				RequestDispatcher r=request.getRequestDispatcher("viewhotelinfo");
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
