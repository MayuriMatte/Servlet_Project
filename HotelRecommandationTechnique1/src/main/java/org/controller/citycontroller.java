package org.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.Adminmodel.citymodel;
import org.service.cityservice;


@WebServlet("/citycontroller")
public class citycontroller extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("nevbar.html");
		r.include(request, response);
		out.println("<br><br>");
		out.println("<center>");
		out.println("<form name='frm' action='' method='POST'>");
		out.println("<input type='text' name='name' value='' style='width:400px;height:40px;'/><br></br>");
		out.println("<input type='submit' name='s' value='Add New City'>");
		out.println("</form>");
		out.println("</center>");
		String btn=request.getParameter("s");
		if(btn!=null)
		{
			String name=request.getParameter("name");
			citymodel model=new citymodel();
			model.setName(name);
			cityservice citys=new cityservice();
			boolean b=citys.isAddcity(model);
			if(b)
			{
				out.println("<h1>city added sucessfully.......</h1>");
			}
			else
			{
				out.println("<h1>some problem is there......</h1>");
			}
					
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
