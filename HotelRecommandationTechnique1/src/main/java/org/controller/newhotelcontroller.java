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

import org.Adminmodel.hotelmodel;
import org.service.hotelservice;


@WebServlet("/newhotelcontroller")
public class newhotelcontroller extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("nevbar.html");
		r.include(request, response);
		try
		{
		hotelservice hotel=new hotelservice();
		List<hotelmodel> list=hotel.getAllHotels();
		out.println("<table border='5' align='center' width='400px'>");
		out.println("<tr><th>HotelName</th><th>DELETE</th><th>UPDATE</th></tr>");
		for(hotelmodel h:list)
		{
			out.println("<tr>");
			out.println("<td>"+h.getName()+ "</td>");
			out.println("<td><a href='detele?hotelId="+h.getId()+"'>DELETE</a></td>");
			out.println("<td><a href='upd?hotelId="+h.getId()+"&hotelName="+h.getName()+"'>UPDATE</a></td>");
			
			out.println("</tr>");
		}
		out.println("</table>");
	
	}
	catch(Exception ex)
	{
		System.out.println(ex.toString());
	}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
