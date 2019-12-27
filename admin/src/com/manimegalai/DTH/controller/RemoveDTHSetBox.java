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


@WebServlet("/RemoveDTHSetBox")
public class RemoveDTHSetBox extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int boxid=Integer.parseInt(request.getParameter("boxids"));
		DTHmodel model=new DTHmodel();
		model.setBoxid(boxid);
		HttpSession session=request.getSession();
		
		DTH dao=new DTH();
		int result=dao.deleteSetBox(model);
		   if(result > 0)
		   {
			ArrayList<DTHmodel> res=dao.load();		
			ArrayList<DTHmodel> alist=dao.setboxload();	
			session.setAttribute("data", res);
			session.setAttribute("sbox", alist);
			request.setAttribute("status", "SetBox Removed Successfully");
            RequestDispatcher rd = request.getRequestDispatcher("ModifyDTHSetBox");
            rd.forward(request, response);          
		   }
		   else
		   {
			   
			request.setAttribute("status", "Some Thing Went Wrong");
            RequestDispatcher rd = request.getRequestDispatcher("ModifyDTHSetBox");
            rd.forward(request, response);

		   }		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
