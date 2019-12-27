package com.manimegalai.DTH.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.DTH;
import model.DTHmodel;


@WebServlet("/UpdateDTHConection")
public class UpdateDTHConection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int cid=Integer.parseInt(request.getParameter("cid"));
		String cname=request.getParameter("cname");
		
		
		DTHmodel model=new DTHmodel();
		model.setCID(cid);
		model.setConnection_Name(cname);
		
		DTH dao=new DTH();
        int result=dao.updateDTHConnection(model);
    	 
       if(result >0)
        {
    	
   		 request.setAttribute("status", "Connection Changed Successfully");
         RequestDispatcher rd = request.getRequestDispatcher("ModifyDTHConnection");
         rd.forward(request, response); 
        	
        }else
        {
        	 request.setAttribute("status", "Some Thing Went Wrong");
             RequestDispatcher rd = request.getRequestDispatcher("ModifyDTHConnection");
             rd.forward(request, response);
        }
        
        
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
