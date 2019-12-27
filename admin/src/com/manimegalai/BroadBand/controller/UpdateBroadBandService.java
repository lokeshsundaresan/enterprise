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


@WebServlet("/UpdateBroadBandService")
public class UpdateBroadBandService extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int bid=Integer.parseInt(request.getParameter("bid"));
		String bname=request.getParameter("cname");
		
	
		BroadBandmodel model=new BroadBandmodel();
		model.setBroadband(bname);
		model.setBid(bid);
		
		BroadBand dao=new BroadBand();
        int result=dao.updateBroadBandService(model);
    	 
       if(result >0)
        {
   		 request.setAttribute("status", "BroadBand Service Changed Successfully");
         RequestDispatcher rd = request.getRequestDispatcher("ModifyBroadBandService");
         rd.forward(request, response); 
        	
        }else
        {
        	 request.setAttribute("status", "Some Thing Went Wrong");
             RequestDispatcher rd = request.getRequestDispatcher("ModifyBroadBandService");
             rd.forward(request, response);
        }
        

	}

}
