package com.manimegali.HomeProducts.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HA;
import model.HAmodel;

@WebServlet("/AddNewHomeApplicances")
public class AddNewHomeApplicances extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String homeapplicances=request.getParameter("haname");
		int hid=Integer.parseInt(request.getParameter("hid"));
		
		HAmodel model=new HAmodel();
		model.setHome_applicances(homeapplicances);
		model.setHid(hid);
		
		HA dao=new HA();
		
	   int result=dao.insertHomeApplicances(model);
	   
	   if(result > 0 )
	   {
		   request.setAttribute("status", "Home Applicances successfully added");
		   request.getRequestDispatcher("AddHomeApplicances.jsp").forward(request, response);
	   }
	   else
	   {
		   request.setAttribute("status", "some thing went Wrong");
		   request.getRequestDispatcher("AddHomeApplicances.jsp").forward(request, response);
	
	   }
	}

}
