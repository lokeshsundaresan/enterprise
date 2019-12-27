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


@WebServlet("/HomeApplicances")
public class HomeApplicances extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HomeApplicances() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	    HA dao=new HA();
		ArrayList<HAmodel> mod=dao.homeappList();
		HttpSession session=request.getSession();
		session.setAttribute("bbdata", mod);
		request.getRequestDispatcher("AddProducts.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
