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

@WebServlet("/EditDTHConnection")
public class EditDTHConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	    int cid=Integer.parseInt(request.getParameter("ids"));
		DTHmodel model=new DTHmodel();
		model.setCID(cid);
		
		
		DTH dao=new DTH();
		ArrayList<DTHmodel> al=dao.preEditConnection(model);
		ArrayList<DTHmodel> res=dao.load();		
		ArrayList<DTHmodel> alist=dao.setboxload();
		HttpSession session=request.getSession();
		session.setAttribute("data", res);
		session.setAttribute("sbox", alist);
		session.setAttribute("editConnection",al);
		RequestDispatcher rd=request.getRequestDispatcher("EditDTHConnection.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
