package com.manimegalai.BroadBand.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BroadBand;
import model.BroadBandmodel;

@WebServlet("/EditBroadBandPlan")
public class EditBroadBandPlan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
       int planid=Integer.parseInt(request.getParameter("ids"));
		
		BroadBandmodel model=new BroadBandmodel();
		model.setPlanid(planid);
		
		BroadBand dao=new BroadBand();
		 ArrayList<BroadBandmodel> al =dao.preEditPlan(model);
		 ArrayList<BroadBandmodel> ar =dao.loadBroadBand();
		 HttpSession session=request.getSession();
		 session.setAttribute("editConnection",al);
		 session.setAttribute("bbdata",ar);
		RequestDispatcher rd=request.getRequestDispatcher("EditBroadBandPlan.jsp");
		rd.forward(request, response);


	}

}
