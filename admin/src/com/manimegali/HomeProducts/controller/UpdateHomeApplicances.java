package com.manimegali.HomeProducts.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HA;
import model.HAmodel;


@WebServlet("/UpdateHomeApplicances")
public class UpdateHomeApplicances extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String haname=request.getParameter("haname");
		int hid=Integer.parseInt(request.getParameter("hid"));
		
		HAmodel model=new HAmodel();
		model.setHome_applicances(haname);
		model.setHid(hid);
		
		HA dao=new HA();
		int result=dao.updateHomeApplicances(model);
		  if(result > 0 )
	 	   {
	 		   request.setAttribute("status", "Home Applicances modified Successfully");
	 		   request.getRequestDispatcher("ModifyHomeApplicances").forward(request, response);
	 	   }
	 	   else
	 	   {
	 		   request.setAttribute("status", "some thing went Wrong");
	 		   request.getRequestDispatcher("ModifyHomeApplicances").forward(request, response);
	 	
	 	   }

	}

}
