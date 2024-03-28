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

import org.Adminmodel.citymodel;
import org.Adminmodel.hotelmodel;
import org.service.cityservice;
import org.service.hotelservice;


@WebServlet("/assignhotel")
public class assignhoteltocity extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("nevbar.html");
		r.include(request, response);
		
		out.println("<center>");
		out.println("<form name='frm' action='' method='POST'>");
		out.println("<input type='submit' name='s' value='fetch hotel' style='width:400px;height;40px'><br><br>");
		out.println("<select name='hotelname'style='width:400px;height:40px'>");
		out.println("<option>select hotel</option>");
		hotelservice hs=new hotelservice();
		List<hotelmodel> list=hs.getAllHotels();
	    for(hotelmodel model:list)
		{
			out.println("<option value='"+model.getId()+"'>"+model.getName()+"</option>");
		}
	    out.println("</select>");
	    out.println("&nbsp;&nbsp;");
		out.println("<select style='width:400px;height:40px'>");
		out.println("<option>select hotel</option>");
		List<citymodel> citylist=new cityservice().getAllcity();
		for(citymodel model:citylist)
		{
			out.println("<option>"+model.getName()+"</option>");
		}
		out.println("</select>");
		out.println("</form>");
		String btn=request.getParameter("s");
		if(btn!=null)
		{
			int hid=Integer.parseInt(request.getParameter("hotelname"));
			out.println(hid);
		}
		out.println("</center>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
