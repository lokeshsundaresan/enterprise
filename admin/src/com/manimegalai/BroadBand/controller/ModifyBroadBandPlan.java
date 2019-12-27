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

@WebServlet("/ModifyBroadBandPlan")
public class ModifyBroadBandPlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		BroadBand dao=new BroadBand();
		ArrayList<BroadBandmodel> alist=dao.loadplans();
		ArrayList<BroadBandmodel> al=dao.loadBroadBand();
		HttpSession session=request.getSession();
		session.setAttribute("sbox", al);
		session.setAttribute("data", alist);
		RequestDispatcher rd=request.getRequestDispatcher("ModifyBroadBandPlan.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
