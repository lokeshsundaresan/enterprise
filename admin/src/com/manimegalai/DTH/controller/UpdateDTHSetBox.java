package com.manimegalai.DTH.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DTH;
import model.DTHmodel;


@WebServlet("/UpdateDTHSetBox")
public class UpdateDTHSetBox extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String Cname=request.getParameter("cname");
		String sbox=request.getParameter("sbox");
		String splcont=request.getParameter("small");
		int rup=Integer.parseInt(request.getParameter("cash"));
		String feature=request.getParameter("features");
		int boxid=Integer.parseInt(request.getParameter("boxid")) ;
		
		 DTHmodel model=new DTHmodel();
	        model.setSetBoxName(sbox);
	        model.setPrize(rup);
	        model.setConnection_Name(Cname);
	        model.setSpecial_content(splcont);
	        model.setFeatures(feature);
	        model.setBoxid(boxid);
	        
	        
	        DTH dao=new DTH();
	        	//for a Session update on every page of Dth
	        ArrayList<DTHmodel> res=dao.load();		
			ArrayList<DTHmodel> alist=dao.setboxload();
			HttpSession session=request.getSession();
			session.setAttribute("data", res);
			session.setAttribute("sbox", alist);
	        
	                
			try {
				  int  result=dao.updateSetBox(model);
				   if(result > 0)
				   {
				
					   request.setAttribute("status", "SetBox Modified Successfully");
		               RequestDispatcher rd = request.getRequestDispatcher("ModifyDTHSetBox");
		               rd.forward(request, response);          
				   }
				   else
				   {
					   
					   request.setAttribute("status", "Some Thing Went Wrong");
		               RequestDispatcher rd = request.getRequestDispatcher("ModifyDTHSetBox");
		               rd.forward(request, response);

				   }
		}catch (Exception e) {
			// TODO: handle exception
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
