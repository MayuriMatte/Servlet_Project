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
import org.Adminmodel.hotelmodel;
import org.service.hotelservice;


@WebServlet("/hotelinsert")
public class hotelinsertcontroller extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("nevbar.html");
		r.include(request, response);

		out.println("<br>");
		out.println("<form name= 'frm' action='' method='POST'>");
		out.println("<input type='text' name='email' value='' placeholder='Enter Email' style='width:400px;height:40px;'/><br><br>");
		out.println("<input type='text' name='contact' value='' placeholder='Enter Contact' style='width:400px;height:40px;'/><br><br>");
		out.println("<input type='text' name='location' value='' placeholder='Enter Location' style='width:400px;height:40px;'/><br><br>");
		out.println("<input type='text' name='address' value='' placeholder='Enter Address' style='width:400px;height:40px;'/><br><br>");
		hotelservice serv=new hotelservice();
		List<hotelmodel> list=serv.getAllHotels();
		out.println("<select name='hotelname' style='width:400px;height:40px;'>");
		out.println("<option>select hotel</option>");
		for(hotelmodel model:list)
		{
			out.println("<option>"+model.getName()+"</option>");
		}
		out.println("</select>");
		out.println("<input type='submit' name='s' value='Add hotel info' style='width:400px;height:40px; '/>");
		out.println("</form>");
		String btn=request.getParameter("s");
		if(btn!=null)
		{
			String email=request.getParameter("email");
			String contact=request.getParameter("contact");
			String address=request.getParameter("address");
			String location=request.getParameter("location");
			String hotelName=request.getParameter("hotelname");
			hotelinfomodel model=new hotelinfomodel();
			model.setEmail(email);
			model.setContact(contact);
			model.setAddress(address);
			model.setLocation(location);
			model.setName(hotelName);
			hotelservice hs=new hotelservice();
			boolean b=hs.isAddhotelinfo(model);
			if(b)
			{
				out.println("<h1>Hotel info added sucessfully........</h1>");
			}
			else
			{
				out.println("<h1>some problem is there........</h1>");
			}
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
