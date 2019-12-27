package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.manimegalai.DTH.controller.ConnectionProvider;
import com.manimegalai.DTH.controller.DataBase;

import model.DTHmodel;

public class DTH implements DataBase{
	
	static Connection conn;
	static PreparedStatement ps,ps1;
	static String sql;
	static ResultSet rs;
	
	public  int connection(DTHmodel model) throws SQLException
	{
		sql="insert into dth values(?,?,?,?)";
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Time sqlTime= new java.sql.Time(new java.util.Date().getTime());
		int status=0;
		try {
			conn=ConnectionProvider.getCon();
			ps=conn.prepareStatement(sql);
			ps.setString(1, model.getConnection_Name());
			ps.setInt(2, model.getCID());
			ps.setDate(3, sqlDate);
			ps.setTime(4, sqlTime);
			status=ps.executeUpdate();
		   } catch (Exception e) {
			// TODO: handle exception
			   e.printStackTrace();
		}
		
		return status;
	}
	
	public ArrayList<DTHmodel> load()
	{
		sql="select * from dth";
		DTHmodel mol;
		ArrayList<DTHmodel> arr=new ArrayList<DTHmodel>();
		try {
			conn=ConnectionProvider.getCon();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				mol=new DTHmodel();
				mol.setConnection_Name(rs.getString(1));
				mol.setCID(rs.getInt(2));
				arr.add(mol);
			}
		   } catch (Exception e) {
			// TODO: handle exception
			   e.printStackTrace();
		}
	
		return arr;
	}
	
	
	public int newSetBox(DTHmodel model)
	{
		int sts=0;
		int cid=0;
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Time sqlTime= new java.sql.Time(new java.util.Date().getTime());

		String pre="select * from dth where ConnectionName=?";
		sql="insert into setbox values(?,?,?,?,?,?,?,?,?)";
		try {
			
			conn=ConnectionProvider.getCon();
			ps1=conn.prepareStatement(pre);
			ps1.setString(1, model.getConnection_Name());
			rs=ps1.executeQuery();
			while(rs.next())
			{
				cid=rs.getInt(2);
			}
			ps=conn.prepareStatement(sql);
			ps.setString(1, model.getConnection_Name());
			ps.setString(2,model.getSetBoxName());
			ps.setInt(3, model.getPrize());
			ps.setString(4, model.getFeatures());
			ps.setString(5,model.getSpecial_content());
			ps.setInt(6, model.getBoxid());
			ps.setInt(7,cid);
			ps.setDate(8, sqlDate);
			ps.setTime(9, sqlTime);
			sts=ps.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sts;
	}
	
	public ArrayList<DTHmodel> setboxload()
	{
		sql="select * from setbox";
		DTHmodel mol;
		ArrayList<DTHmodel> arr=new ArrayList<DTHmodel>();
		try {
			conn=ConnectionProvider.getCon();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				mol=new DTHmodel();
				mol.setConnection_Name(rs.getString(1));
				mol.setSetBoxName(rs.getString(2));
				mol.setPrize(rs.getInt(3));
				mol.setFeatures(rs.getString(4));
				mol.setSpecial_content(rs.getString(5));
				mol.setBoxid(rs.getInt(6));
				mol.setCID(rs.getInt(7));
				arr.add(mol);
			}
		   } catch (Exception e) {
			// TODO: handle exception
			   e.printStackTrace();
		}
		
		return arr;
	}
	
	public ArrayList<DTHmodel> preEdit(DTHmodel model)
	{
		sql="select * from setbox where BoxId=?";
		DTHmodel mol;
		ArrayList<DTHmodel> arr=new ArrayList<DTHmodel>();
		try {
			conn=ConnectionProvider.getCon();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, model.getBoxid());
			rs=ps.executeQuery();
			while(rs.next())
			{
				mol=new DTHmodel();
				mol.setConnection_Name(rs.getString(1));
				mol.setSetBoxName(rs.getString(2));
				mol.setPrize(rs.getInt(3));
				mol.setFeatures(rs.getString(4));
				mol.setSpecial_content(rs.getString(5));
				mol.setBoxid(rs.getInt(6));
				mol.setCID(rs.getInt(7));
				arr.add(mol);
			}
		   } catch (Exception e) {
			// TODO: handle exception
			   e.printStackTrace();
		}
		
		return arr;
	}
	public int updateSetBox(DTHmodel model)
	{
		String pre="select * from dth where ConnectionName=?";
		sql="update setbox set ConnectionName=?,SetBoxName=?,Prize=?,Features=?,splcontent=?,CID=? where BoxId=?";
		int status=0;
		int cid=0;
		try {
			conn=ConnectionProvider.getCon();
			ps1=conn.prepareStatement(pre);
			ps1.setString(1, model.getConnection_Name());
			rs=ps1.executeQuery();
			while(rs.next())
			{
				cid=rs.getInt(2);
			}
			ps=conn.prepareStatement(sql);
			ps.setString(1, model.getConnection_Name());
			ps.setString(2,model.getSetBoxName());
			ps.setInt(3, model.getPrize());
			ps.setString(4, model.getFeatures());
			ps.setString(5,model.getSpecial_content());
			ps.setInt(6, cid);
			ps.setInt(7, model.getBoxid());
			status=ps.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return status;
	}
	public int deleteSetBox(DTHmodel model)
	{
		int status=0;
		sql="delete from setbox where BoxId=?";
		try {
			conn=ConnectionProvider.getCon();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, model.getBoxid());
			status=ps.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return status;
	}
	public ArrayList<DTHmodel> preEditConnection(DTHmodel model)
	{
		sql="select * from dth where CID=?";
		DTHmodel mol;
		ArrayList<DTHmodel> arr=new ArrayList<DTHmodel>();
		try {
			conn=ConnectionProvider.getCon();
			ps=conn.prepareStatement(sql);
			ps.setInt(1,model.getCID());
			rs=ps.executeQuery();
			while(rs.next())
			{
				mol=new DTHmodel();
				mol.setConnection_Name(rs.getString(1));
				mol.setCID(rs.getInt(2));
				arr.add(mol);		
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return arr;
	}
	
	public int updateDTHConnection(DTHmodel model)
	{
		int res=0;
		sql="update dth set ConnectionName=? where CID=?";
		String post="update setbox set ConnectionName=? where CID=?";
		try {
			conn=ConnectionProvider.getCon();
			ps=conn.prepareStatement(sql);
			ps.setString(1, model.getConnection_Name());
			ps.setInt(2,model.getCID());
			res=ps.executeUpdate();
			if(res > 0)
			{
				ps1=conn.prepareStatement(post);
				ps1.setString(1, model.getConnection_Name());
				ps1.setInt(2,model.getCID());
				ps1.executeUpdate();
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}
	
	public int removeDTHConnection(DTHmodel model)
	{
		int status=0;
		
		sql="delete from dth where CID=?";
		try {
			conn=ConnectionProvider.getCon();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, model.getCID());
			status=ps.executeUpdate();
			if(status > 0)
			{   
				String sql1="delete from setbox where CID=?";
				PreparedStatement ps1=conn.prepareStatement(sql1);
				ps1.setInt(1, model.getCID());
				ps1.executeUpdate();
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return status;
	}
}

