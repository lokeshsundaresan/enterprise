package com.manimegalai.BroadBand.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BroadBand;
import model.BroadBandmodel;

@WebServlet("/AddBroadBandPlan")
public class AddBroadBandPlan extends HttpServlet {
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
		int result=dao.addBroadBandPlan(model);
		ArrayList<BroadBandmodel> al=dao.loadBroadBand();
		HttpSession session=request.getSession();
		if(result > 0)
		{
			session.setAttribute("bbdata",al);
			request.setAttribute("status"," BroadBand Plan Added Successfully ");
			request.getRequestDispatcher("AddBroadBandPlans.jsp").forward(request, response);
			
		}else
		{
			request.setAttribute("status","Some Thing went Wrong");
			request.getRequestDispatcher("AddBroadBandPlans.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
