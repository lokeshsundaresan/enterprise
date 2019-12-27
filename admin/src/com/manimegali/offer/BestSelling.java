package com.manimegali.offer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.offer;
import model.BroadBandmodel;
import model.DTHmodel;
import model.HAmodel;


@WebServlet("/BestSelling")
public class BestSelling extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int doc=Integer.parseInt(request.getParameter("doc"));
		String cat=request.getParameter("cat");
		offer dao=new offer();
		int result=0;
		if(cat.equals("has"))
		{
			HAmodel model1=new HAmodel();
			model1.setProduct_id(doc);
			result=dao.insertBestSelling(model1,"HA");
			
		}
		if(cat.equals("bbpl"))
			{
	           BroadBandmodel model2=new BroadBandmodel();
	           model2.setPlanid(doc);
	           result=dao.insertBestSelling(model2,"BroadBand");
			}
		if(cat.equals("dth"))
		{
           DTHmodel model3=new DTHmodel();
           model3.setBoxid(doc);
           result=dao.insertBestSelling(model3,"DTH");
		}
		
		if(result > 0)
		{
			request.setAttribute("status","Product added to BestSeller  successfully ");
			request.getRequestDispatcher("AddBestSellingItem.jsp").forward(request, response);
		}else
		{
			request.setAttribute("status","Already Product added to Bestseller ");
			request.getRequestDispatcher("ProductList").forward(request, response);

		}
	}

}
