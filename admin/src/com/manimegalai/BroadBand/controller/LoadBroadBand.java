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

@WebServlet("/LoadBroadBand")
public class LoadBroadBand extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		BroadBand dao=new BroadBand();
		ArrayList<BroadBandmodel> mod=dao.loadBroadBand();
		HttpSession session=request.getSession();
		session.setAttribute("bbdata", mod);
		request.getRequestDispatcher("AddBroadBandPlans.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
