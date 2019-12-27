package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.manimegalai.DTH.controller.ConnectionProvider;

import model.BroadBandmodel;

public class BroadBand {
	
	
	static Connection conn;
	static PreparedStatement ps,ps1;
	static String sql;
	static ResultSet rs;
	
	
	public int addBroadBand(BroadBandmodel model)
	{
		sql="insert into broadband values(?,?)";
		int status=0;
		try {
			conn=ConnectionProvider.getCon();
			ps=conn.prepareStatement(sql);
			ps.setString(1, model.getBroadband());
			ps.setInt(2, model.getBid());
			status=ps.executeUpdate();
		   } catch (Exception e) {
			// TODO: handle exception
			   e.printStackTrace();
		}

		
		return status;
	}
	public ArrayList<BroadBandmodel> loadBroadBand()
	{
		sql="select * from broadband";
		ArrayList<BroadBandmodel> al=new ArrayList<BroadBandmodel>();
		BroadBandmodel model;
		try {
			conn=ConnectionProvider.getCon();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				model=new BroadBandmodel();
				model.setBroadband(rs.getString(1));
				model.setBid(rs.getInt(2));
				al.add(model);
			}
		   } catch (Exception e) {
			// TODO: handle exception
			   e.printStackTrace();
		}
		
		return al;
	}
	
	public int addBroadBandPlan(BroadBandmodel model)
	{
		int stat=0;
		int bid=0;
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Time sqlTime= new java.sql.Time(new java.util.Date().getTime());

		String pre="select * from broadband where BroadBandName=?";
		sql="insert into bbplan values(?,?,?,?,?,?,?,?,?,?)";
		try {
			conn=ConnectionProvider.getCon();
			ps1=conn.prepareStatement(pre);
			ps1.setString(1, model.getBroadband());
			rs=ps1.executeQuery();
			while(rs.next())
			{
				bid=rs.getInt(2);
			}
			ps=conn.prepareStatement(sql);
			ps.setString(1, model.getBroadband());
			ps.setInt(2, bid);
			ps.setString(3, model.getPlanname());
			ps.setInt(4, model.getPlanid());
			ps.setInt(5, model.getPrize());
			ps.setInt(6, model.getSpeed());
			ps.setInt(7,model.getGb());
			ps.setString(8, model.getFeatures());
			ps.setDate(9, sqlDate);
			ps.setTime(10, sqlTime);
			stat=ps.executeUpdate();
		   } catch (Exception e) {
			// TODO: handle exception
			   e.printStackTrace();
		}
		return stat;
	}

	public int removeBroadBandService(BroadBandmodel model)
	{
		int res=0;
		sql="delete from broadband where BID=?";
		String post="delete from bbplan where BID=?";
		try {
			conn=ConnectionProvider.getCon();
			ps1=conn.prepareStatement(sql);
			ps1.setInt(1, model.getBid());
			res=ps1.executeUpdate();
			
			if(res > 0)
			{
				ps=conn.prepareStatement(post);
				ps.setInt(1, model.getBid());
				ps.executeUpdate();
			}
			}catch (Exception e) {
				// TODO: handle exception
			}
		
		return res;
	}
	
	public ArrayList<BroadBandmodel> preEdit(BroadBandmodel model)
	{
		ArrayList<BroadBandmodel> arr=new ArrayList<BroadBandmodel>();
		sql="select * from broadband where BID=?";
		BroadBandmodel mod;
		try {
			conn=ConnectionProvider.getCon();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, model.getBid());
			rs=ps.executeQuery();
			while(rs.next())
			{
				mod=new BroadBandmodel();
				mod.setBroadband(rs.getString(1));
				mod.setBid(rs.getInt(2));
				arr.add(mod);
			}
		   } catch (Exception e) {
			// TODO: handle exception
			   e.printStackTrace();
		}
		
		return arr;
	}
	
	public int updateBroadBandService(BroadBandmodel model)
	{
		int res=0;		
		sql="update broadband set BroadBandName=? where BID=?";
		String post="update bbplan set BroadBandName=? where BID=?";
		try {
			conn=ConnectionProvider.getCon();
			ps1=conn.prepareStatement(sql);
			ps1.setString(1, model.getBroadband());
			ps1.setInt(2, model.getBid());
			res=ps1.executeUpdate();
			if(res > 0)
			{
				ps=conn.prepareStatement(post);
				ps.setString(1, model.getBroadband());
				ps.setInt(2, model.getBid());		
				ps.executeUpdate();
			}
			}catch (Exception e) {
				// TODO: handle exception
			}	
		return res;
	}
	public ArrayList<BroadBandmodel> loadplans()
	{
		ArrayList<BroadBandmodel> arr=new ArrayList<BroadBandmodel>();
		sql="select * from bbplan";
		BroadBandmodel model;
		try {
			conn=ConnectionProvider.getCon();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				model=new BroadBandmodel();
				model.setBroadband(rs.getString(1));
				model.setBid(rs.getInt(2));
				model.setPlanname(rs.getString(3));
				model.setPlanid(rs.getInt(4));
				model.setPrize(rs.getInt(5));
				model.setSpeed(rs.getInt(6));
				model.setGb(rs.getInt(7));
				model.setFeatures(rs.getString(8));
				arr.add(model);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return arr;
	}
	
	public int removeBroadBandPlan(BroadBandmodel model)
	{
		int ress=0;
	
		sql="delete from bbplan where PlanId=?";
		try {
			conn=ConnectionProvider.getCon();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, model.getPlanid());
			ress=ps.executeUpdate();	
			}catch (Exception e) {
				// TODO: handle exception
			}
		
		return ress;
	}
	
	public ArrayList<BroadBandmodel> preEditPlan(BroadBandmodel mod)
	{
		sql="select * from bbplan where PlanId=?";
		ArrayList<BroadBandmodel> arr=new ArrayList<BroadBandmodel>();
		BroadBandmodel model;
		try {
			conn=ConnectionProvider.getCon();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, mod.getPlanid());
			rs=ps.executeQuery();
			while(rs.next())
			{
				model=new BroadBandmodel();
				model.setBroadband(rs.getString(1));
				model.setBid(rs.getInt(2));
				model.setPlanname(rs.getString(3));
				model.setPlanid(rs.getInt(4));
				model.setPrize(rs.getInt(5));
				model.setSpeed(rs.getInt(6));
				model.setGb(rs.getInt(7));
				model.setFeatures(rs.getString(8));
				arr.add(model);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return arr;
		
	}
	
	public int updateBroadBandPlan(BroadBandmodel model)
	{
		int bid=0;
		int rss=0;
		String pre="select * from broadband where BroadBandName=?";
		sql="update bbplan set BroadBandName=?,BID=?,PlanName=?,Prize=?,Speed=?,Gb=?,Features=? where PlanId=?";
		try {
			conn=ConnectionProvider.getCon();
			ps1=conn.prepareStatement(pre);
			ps1.setString(1, model.getBroadband());
			rs=ps1.executeQuery();
			while(rs.next())
			{
				bid=rs.getInt(2);
			}
			ps=conn.prepareStatement(sql);
			ps.setString(1, model.getBroadband());
			ps.setInt(2, bid);
			ps.setString(3, model.getPlanname());
			ps.setInt(8, model.getPlanid());
			ps.setInt(4, model.getPrize());
			ps.setInt(5, model.getSpeed());
			ps.setInt(6,model.getGb());
			ps.setString(7, model.getFeatures());
			rss=ps.executeUpdate();
		   } catch (Exception e) {
			// TODO: handle exception
			   e.printStackTrace();
		}

		return rss;
	}

}
