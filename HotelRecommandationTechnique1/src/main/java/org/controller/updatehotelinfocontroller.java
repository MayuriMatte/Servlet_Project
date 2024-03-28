package org.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updatehotelinfo")
public class updatehotelinfocontroller extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("nevbar.html");
		r.include(request, response);
		int hid=Integer.parseInt(request.getParameter("hotelinfoid"));
		String name = request.getParameter("hotelname");
		String email=request.getParameter("hotelemail");
		String contact=request.getParameter("hotelcontact");
		String location=request.getParameter("hotellocation");
		String address=request.getParameter("hoteladdress");
		
		out.println("<center>");
		out.println("<form name='frm' action='finalinfoupdate' method='POST'>");
		out.println("<input type='hidden' name='id' value='"+hid+"' style='width:400px;height:40px;'/><br<<br>");
		out.println("<input type='hidden' name='name' value='"+name+"' style='width:400px;height:40px;'/><br<<br>");
		out.println("<input type='text' name='email' value='"+email+"' placeholder='Enter Email' style='width:400px;height:40px;'/><br<<br>");
		out.println("<input type='text' name='contact' value='"+contact+"' placeholder='Enter Contact' style='width:400px;height:40px;'/><br<<br>");
		out.println("<input type='text' name='location' value='"+location+"' placeholder='Enter Location' style='width:400px;height:40px;'/><br<<br>");
		out.println("<input type='text' name='address' value='"+address+"' placeholder='Enter Address' style='width:400px;height:40px;'/><br<<br>");
		out.println("<input type='submit' name='s' value='update hotel' style='width:400px;height:40px;'/><br<<br>");
		out.println("<form>");
		out.println("</center>");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
