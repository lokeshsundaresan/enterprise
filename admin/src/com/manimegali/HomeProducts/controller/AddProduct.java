package com.manimegali.HomeProducts.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HA;
import model.HAmodel;

@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String HAname=request.getParameter("cname");
		String product_name=request.getParameter("appname");
		int product_id=Integer.parseInt(request.getParameter("appid"));
		int prize=Integer.parseInt(request.getParameter("cash"));
		String brand=request.getParameter("brandname");
		String spl_1=request.getParameter("spl1");
		String spl_2=request.getParameter("spl2");
		String spl_3=request.getParameter("spl3");
		String specification=request.getParameter("Specification");
		
		HAmodel model=new HAmodel();
		model.setHome_applicances(HAname);
		model.setProduct_name(product_name);
		model.setProduct_id(product_id);
		model.setPrize(prize);
		model.setBrand(brand);
		model.setSpl_1(spl_1);
        model.setSpl_2(spl_2);		
        model.setSpl_3(spl_3);
        model.setSpecification(specification);
        
        HA dao=new HA ();
        int result=dao.insertProduct(model);
        
        if(result > 0 )
 	   {
 		   request.setAttribute("status", "Home Applicances successfully added");
 		   request.getRequestDispatcher("AddProducts.jsp").forward(request, response);
 	   }
 	   else
 	   {
 		   request.setAttribute("status", "some thing went Wrong");
 		   request.getRequestDispatcher("AddProducts.jsp").forward(request, response);
 	
 	   }
	}

}
