package org.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Adminmodel.hotelinfomodel;
import org.service.hotelservice;


@WebServlet("/viewhotelinfo")
public class viewhotelcontroller extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("nevbar.html");
		r.include(request, response);
		out.println("<br><br>");
		out.println("<table border='5' align='center' width='70%'>");
		out.println("<tr><th>NAME</th><th>EMAIL</th><th>CONTACT</th><th>LOCATION</th><th>ADDRESS</th><th>DELETE</th><th>UPDATE</th></tr>");
		List<hotelinfomodel> list=new hotelservice().gethotelList();
		for(hotelinfomodel m:list)
		{
			out.println("<tr>");
			out.println("<td>"+m.getName()+"</td>");
			out.println("<td>"+m.getEmail()+"</td>");
			out.println("<td>"+m.getContact()+"</td>");
			out.println("<td>"+m.getLocation()+"</td>");
			out.println("<td>"+m.getAddress()+"</td>");
			out.println("<td><a href='deleteinfocontroller?hotelinfoid="+m.getInfoid()+"'>DELETE</a></td>");
			out.println("<td><a href='updatehotelinfo?hotelinfoid="+m.getInfoid()+"&hotelname="+m.getName()+"&hotelemail="+m.getEmail()+"&hotelcontact="+m.getContact()+"&hotellocation="+m.getLocation()+"&hoteladdress="+m.getAddress()+"'>UPDATE</a></td>");
			out.println("</tr>");
			
		}
		
		
		out.println("</table>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
