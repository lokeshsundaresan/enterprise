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

@WebServlet("/ModifyDTHConnection")
public class ModifyDTHConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		DTH dao=new DTH();
		ArrayList<DTHmodel> alist=dao.setboxload();
		ArrayList<DTHmodel> al=dao.load();
		HttpSession session=request.getSession();
		session.setAttribute("sbox", alist);
		session.setAttribute("data", al);
		RequestDispatcher rd=request.getRequestDispatcher("ModifyDTHConnection.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
