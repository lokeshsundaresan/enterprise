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

import dao.offer;
import model.BroadBandmodel;
import model.DTHmodel;
import model.HAmodel;
import model.Offermodel;


@WebServlet("/CurrentBestSelling")
public class CurrentBestSelling extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		

		offer off=new offer();
		ResultSet rs=off.loadBestSeller();
		Offermodel model=new Offermodel();
		HttpSession session=request.getSession();
		ArrayList<HAmodel> list1=new ArrayList<HAmodel>();			
		ArrayList<BroadBandmodel> list2=new ArrayList<BroadBandmodel>();					
		ArrayList<DTHmodel> list3=new ArrayList<DTHmodel>();
		
		try {
			while(rs.next())
			{
					model.setProductid(rs.getInt(1));
					model.setPlanid(rs.getInt(2));
					model.setBoxid(rs.getInt(3));
					list1.addAll(off.bestHomeProduct(model));				
					list2.addAll(off.bestBroadBand(model));					
					list3.addAll(off.bestDTH(model));
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("bestBB", list2);
		session.setAttribute("bestDTH", list3);
		session.setAttribute("bestHA",list1);
		request.getRequestDispatcher("CurrentBestSelling.jsp").forward(request, response);

	}

}
