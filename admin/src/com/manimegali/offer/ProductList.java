package com.manimegali.offer;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BroadBand;
import dao.DTH;
import dao.HA;
import dao.offer;
import model.BroadBandmodel;
import model.DTHmodel;
import model.HAmodel;
import model.Offermodel;

@WebServlet("/ProductList")
public class ProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		HA ha=new HA();
		DTH dth=new DTH();
		BroadBand bb=new BroadBand();
		
		HttpSession session=request.getSession();
		ArrayList<HAmodel> alist1=ha.productList();
		ArrayList<DTHmodel> alist2=dth.setboxload();
		ArrayList<BroadBandmodel> alist3=bb.loadplans();
		
	
		session.setAttribute("ha", alist1);
		session.setAttribute("dth", alist2);
		session.setAttribute("broadband",alist3);
		
		request.getRequestDispatcher("offer.jsp").forward(request, response);;
	}

}
