package com.manimegalai.BroadBand.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BroadBand;
import model.BroadBandmodel;


@WebServlet("/UpdateBroadBandPlan")
public class UpdateBroadBandPlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String Broadbandname=request.getParameter("cname");
		String planname=request.getParameter("planname");
		int planid=Integer.parseInt(request.getParameter("ppid"));
		int prize=Integer.parseInt(request.getParameter("cash"));
		int range=Integer.parseInt(request.getParameter("speed"));
		int gb=Integer.parseInt(request.getParameter("gb"));
		String features=request.getParameter("features");
		
		
		BroadBandmodel model=new BroadBandmodel();
		model.setBroadband(Broadbandname);
		model.setPlanname(planname);
		model.setPlanid(planid);
		model.setPrize(prize);
		model.setSpeed(range);
		model.setFeatures(features);
		model.setGb(gb);
		
		BroadBand dao=new BroadBand();
		int result=dao.updateBroadBandPlan(model);
		   if(result >0)
	        {
	   		 request.setAttribute("status", "BroadBand Service Changed Successfully");
	         RequestDispatcher rd = request.getRequestDispatcher("ModifyBroadBandPlan");
	         rd.forward(request, response); 
	        	
	        }else
	        {
	        	 request.setAttribute("status", "Some Thing Went Wrong");
	             RequestDispatcher rd = request.getRequestDispatcher("ModifyBroadBandPlan");
	             rd.forward(request, response);
	        }
	    

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
