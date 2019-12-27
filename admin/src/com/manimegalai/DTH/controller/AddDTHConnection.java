package com.manimegalai.DTH.controller;

import java.io.IOException;
import java.sql.SQLException;
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


@WebServlet("/AddDTHConnection")
public class AddDTHConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
        int result=0;
		String connection=request.getParameter("cname");
		int cid=Integer.parseInt(request.getParameter("cid"));
		
		
		DTHmodel model=new DTHmodel();
		model.setConnection_Name(connection);
		model.setCID(cid);
		
		DTH dao=new DTH();
		ArrayList<DTHmodel> res=dao.load();
		
		ArrayList<DTHmodel> alist=dao.setboxload();
		
		HttpSession session=request.getSession();
		session.setAttribute("data", res);
		session.setAttribute("sbox", alist);
		try {
		   result=dao.connection(model);
		   if(result > 0)
		   {
			   request.setAttribute("errorMessage", "Added Successfully");
               RequestDispatcher rd = request.getRequestDispatcher("/NewDTHConnection.jsp");
               rd.forward(request, response);          
		   }
		   else
		   {
			    
			   request.setAttribute("errorMessage", "Some Thing Went Wrong");
               RequestDispatcher rd = request.getRequestDispatcher("/NewDTHConnection.jsp");
               rd.forward(request, response);

		   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
