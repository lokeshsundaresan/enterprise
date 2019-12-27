package com.manimegalai.DTH.controller;

import java.io.IOException;
import java.io.InputStream;
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

@WebServlet("/AddDTHSetBox")
public class AddDTHSetBox extends HttpServlet {
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
		
        InputStream inputStream = null; // input stream of the upload file
         
        // obtains the upload file part in this multipart request
        /*    Part filePart = request.getPart("pics");
       if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }*/
        
        DTHmodel model=new DTHmodel();
        model.setSetBoxName(sbox);
        model.setPrize(rup);
        model.setConnection_Name(Cname);
        model.setSpecial_content(splcont);
        model.setFeatures(feature);
        model.setPhoto(inputStream);
        model.setBoxid(boxid);
        
        
        DTH dao=new DTH();
	//for a Session update on every page of Dth
        ArrayList<DTHmodel> res=dao.load();		
		ArrayList<DTHmodel> alist=dao.setboxload();
		HttpSession session=request.getSession();
		session.setAttribute("data", res);
		session.setAttribute("sbox", alist);
        
                
		try {
			  int  result=dao.newSetBox(model);
			   if(result > 0)
			   {
			
				   request.setAttribute("status", "SetBox Added Successfully");
	               RequestDispatcher rd = request.getRequestDispatcher("NewDTHSetBox");
	               rd.forward(request, response);          
			   }
			   else
			   {
				   
				   request.setAttribute("status", "Some Thing Went Wrong");
	               RequestDispatcher rd = request.getRequestDispatcher("NewDTHSetBox");
	               rd.forward(request, response);

			   }
	}catch (Exception e) {
		// TODO: handle exception
	}
	}
}
