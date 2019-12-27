package com.manimegali.HomeProducts.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.HA;
import model.HAmodel;

@WebServlet("/EditHomeApplicances")
public class EditHomeApplicances extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int hid=Integer.parseInt(request.getParameter("ids"));
		
		HAmodel model=new HAmodel();
		model.setHid(hid);
		
		HA dao=new HA();
		ArrayList<HAmodel> alist=dao.editHomeApplicances(model);
		
		HttpSession session=request.getSession();
		session.setAttribute("editConnection", alist);
		request.getRequestDispatcher("EditHomeApplicances.jsp").forward(request, response);
		
	}

}
