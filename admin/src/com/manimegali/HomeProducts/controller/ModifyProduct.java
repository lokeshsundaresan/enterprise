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


@WebServlet("/ModifyProduct")
public class ModifyProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
HA dao=new HA();
		
	    ArrayList<HAmodel> alist=dao.productList();
	    
	    HttpSession session=request.getSession();
	    
	    session.setAttribute("data", alist);
	    request.getRequestDispatcher("ModifyProducts.jsp").forward(request, response);

	}

}
