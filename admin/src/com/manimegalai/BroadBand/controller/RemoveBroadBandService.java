package com.manimegalai.BroadBand.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BroadBand;
import model.BroadBandmodel;


@WebServlet("/RemoveBroadBandService")
public class RemoveBroadBandService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int bid=Integer.parseInt(request.getParameter("ids"));
		
		BroadBandmodel model=new BroadBandmodel();
		model.setBid(bid);
		
		BroadBand dao=new BroadBand();
		int result=dao.removeBroadBandService(model);
		
		if(result >0)
		{
			request.setAttribute("status", "BroadBandServices Removed Successfully");
			request.getRequestDispatcher("ModifyBroadBandService").forward(request, response);
		}else
		{
			request.setAttribute("status", "Some Thing Went Wrong");
			request.getRequestDispatcher("ModifyBroadBandService").forward(request, response);

		}
		
	}

}
