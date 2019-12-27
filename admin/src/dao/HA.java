package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.manimegalai.DTH.controller.ConnectionProvider;
import com.manimegalai.DTH.controller.DataBase;

import model.HAmodel;

public class HA implements DataBase{
	
	static Connection conn;
	static PreparedStatement ps,ps1;
	static String sql;
	static ResultSet rs;
	
	public int insertHomeApplicances(HAmodel model)
	{
		int res=0;
		sql="insert into ha values(?,?)";
		try {
			conn=ConnectionProvider.getCon();
			ps=conn.prepareStatement(sql);
			ps.setString(1, model.getHome_applicances());
			ps.setInt(2, model.getHid());
			res=ps.executeUpdate();
		   } catch (Exception e) {
			// TODO: handle exception
			   e.printStackTrace();
		}
		
		return res;
	}
	
	public ArrayList<HAmodel> homeappList()
	{
		ArrayList<HAmodel> arr=new ArrayList<HAmodel>();
		sql="select * from ha";
		HAmodel model;
		try {
			conn=ConnectionProvider.getCon();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				model=new HAmodel();
				model.setHome_applicances(rs.getString(1));
				model.setHid(rs.getInt(2));
				arr.add(model);
			}
		   } catch (Exception e) {
			// TODO: handle exception
			   e.printStackTrace();
		}
		
		return arr;
	}

	
	public int insertProduct(HAmodel model)
	{
		int res=0;
		int hid=0;
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Time sqlTime= new java.sql.Time(new java.util.Date().getTime());
		
		sql="insert into product values(?,?,?,?,?,?,?,?,?,?,?,?)";
		String pre="select * from ha where HomeApplicance=?";
		try {
			conn=ConnectionProvider.getCon();
			ps1=conn.prepareStatement(pre);
			ps1.setString(1, model.getHome_applicances());
		    rs=ps1.executeQuery();
		    while(rs.next())
		    {
		    	hid=rs.getInt(2);
		    }
		    ps=conn.prepareStatement(sql);
		    ps.setString(1, model.getHome_applicances());
		    ps.setInt(2, hid);
		    ps.setString(3, model.getProduct_name());
		    ps.setInt(4, model.getProduct_id());
		    ps.setString(5, model.getBrand());
		    ps.setInt(6, model.getPrize());
		    ps.setString(7,model.getSpl_1());
		    ps.setString(8,model.getSpl_2());
		    ps.setString(9,model.getSpl_3());
		    ps.setString(10,model.getSpecification());
			ps.setDate(11, sqlDate);
			ps.setTime(12, sqlTime);
		    res=ps.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}
	
	public int removeHomeApplicance(HAmodel model)
	{
		int res=0;
		sql="delete from ha where HID=?";
		String post="delete from product where HID=?";
		try {
			conn=ConnectionProvider.getCon();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, model.getHid());
			res=ps.executeUpdate();
			if(res > 0)
			{
				conn=ConnectionProvider.getCon();
				ps1=conn.prepareStatement(post);
				ps1.setInt(1, model.getHid());
				ps1.executeUpdate();
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	
				return res;
	}
	public int removeProduct(HAmodel model)
	{
		int res=0;
		sql="delete from product where ProductId=?";		
		try {
			conn=ConnectionProvider.getCon();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, model.getProduct_id());
			res=ps.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	
				return res;
	}
	
	public ArrayList<HAmodel> editHomeApplicances(HAmodel model)
	{
		ArrayList<HAmodel> arr=new ArrayList<HAmodel>();
		sql="select * from ha where HID=?";
		try {
			conn=ConnectionProvider.getCon();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, model.getHid());
			rs=ps.executeQuery();
			while(rs.next())
			{
				HAmodel mos=new HAmodel();
				mos.setHome_applicances(rs.getString(1));
				mos.setHid(rs.getInt(2));
				arr.add(mos);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return arr;
	}
	public int updateHomeApplicances(HAmodel model)
	{
		int res=0;
		sql="update ha set HomeApplicance=? where HID=?";
		String post="update product set HomeApplicance=? where HID=?";
		try {
			conn=ConnectionProvider.getCon();
			ps=conn.prepareStatement(sql);
			ps.setString(1, model.getHome_applicances());
			ps.setInt(2, model.getHid());
			res=ps.executeUpdate();
			if(res >0)
			{
				ps=conn.prepareStatement(post);
				ps.setString(1, model.getHome_applicances());
				ps.setInt(2, model.getHid());
				res=ps.executeUpdate();
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}
	
	public ArrayList<HAmodel> productList()
	{
		ArrayList<HAmodel> arr=new ArrayList<HAmodel>();
		sql="select * from product";
		HAmodel model;
		try {
			conn=ConnectionProvider.getCon();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				model=new HAmodel();
				model.setHome_applicances(rs.getString(1));
				model.setHid(rs.getInt(2));
				model.setProduct_name(rs.getString(3));
				model.setProduct_id(rs.getInt(4));
				model.setBrand(rs.getString(5));
				model.setPrize(rs.getInt(6));
				model.setSpl_1(rs.getString(7));
				model.setSpl_2(rs.getString(8));
				model.setSpl_3(rs.getString(9));
				model.setSpecification(rs.getString(10));
				arr.add(model);
			}
		   } catch (Exception e) {
			// TODO: handle exception
			   e.printStackTrace();
		}
		
		return arr;
	}

	 public ArrayList<HAmodel> editProduct(HAmodel mod)
	 {
		 ArrayList<HAmodel> arr=new ArrayList<HAmodel>();
		 sql="select * from product where ProductId=?";
		 HAmodel model;
			try {
				conn=ConnectionProvider.getCon();
				ps=conn.prepareStatement(sql);
				ps.setInt(1, mod.getProduct_id());
				rs=ps.executeQuery();
				
				while(rs.next())
				{
					model=new HAmodel();
					model.setHome_applicances(rs.getString(1));
					model.setHid(rs.getInt(2));
					model.setProduct_name(rs.getString(3));
					model.setProduct_id(rs.getInt(4));
					model.setBrand(rs.getString(5));
					model.setPrize(rs.getInt(6));
					model.setSpl_1(rs.getString(7));
					model.setSpl_2(rs.getString(8));
					model.setSpl_3(rs.getString(9));
					model.setSpecification(rs.getString(10));
					arr.add(model);
				}
			   } catch (Exception e) {
				// TODO: handle exception
				   e.printStackTrace();
			}
			
		 return arr;
	 }
	 
	 public int updateProduct(HAmodel model)
	 {
		 int res=0;
		 int hid=0;
			sql="update product set HomeApplicance=?,HID=?,ProductName=?,brand=?,prize=?,spl1=?,spl2=?,spl3=?,specification=? where ProductId=?";
			String pre="select * from ha where HomeApplicance=?";
			try {
				conn=ConnectionProvider.getCon();
				ps1=conn.prepareStatement(pre);
				ps1.setString(1, model.getHome_applicances());
			    rs=ps1.executeQuery();
			    while(rs.next())
			    {
			    	hid=rs.getInt(2);
			    }
			    ps=conn.prepareStatement(sql);
			    ps.setString(1, model.getHome_applicances());
			    ps.setInt(2, hid);
			    ps.setString(3, model.getProduct_name());
			    ps.setInt(10, model.getProduct_id());
			    ps.setString(4, model.getBrand());
			    ps.setInt(5, model.getPrize());
			    ps.setString(6,model.getSpl_1());
			    ps.setString(7,model.getSpl_2());
			    ps.setString(8,model.getSpl_3());
			    ps.setString(9,model.getSpecification());
			    res=ps.executeUpdate();
			}catch (Exception e) {
				// TODO: handle exception
			}
		
		 return res;
	 }
	

}
