package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.manimegalai.DTH.controller.ConnectionProvider;

import model.BroadBandmodel;
import model.DTHmodel;
import model.HAmodel;
import model.Offermodel;

public class offer {
	
	static Connection conn;
	static PreparedStatement ps,ps1;
	static String sql;
	static ResultSet rs;
	
	public int insertBestSelling(Object a,String b)
	{
		int result=0;
		if(b.equals("HA"))
		{
			HAmodel model=(HAmodel)a;
			sql="insert into offer values(?,?,?)";
			try {
				conn=ConnectionProvider.getCon();
				ps=conn.prepareStatement(sql);
				ps.setInt(1, model.getProduct_id());
				ps.setInt(2, model.getPrize());
				ps.setInt(3, model.getHid());
				result=ps.executeUpdate();
			   } catch (Exception e) {
				// TODO: handle exception
				   e.printStackTrace();
			}
			
			
		}else if(b.equals("BroadBand"))
		{
			BroadBandmodel model=(BroadBandmodel)a;
			sql="insert into offer values(?,?,?)";
			try {
				conn=ConnectionProvider.getCon();
				ps=conn.prepareStatement(sql);
				ps.setInt(1, model.getPrize());
				ps.setInt(2, model.getPlanid());
				ps.setInt(3,model.getGb());
				result=ps.executeUpdate();
			   } catch (Exception e) {
				// TODO: handle exception
				   e.printStackTrace();
			}
			
			
		}else
		{
			DTHmodel model=(DTHmodel)a;
			sql="insert into offer values(?,?,?)";
			try {
				conn=ConnectionProvider.getCon();
				ps=conn.prepareStatement(sql);
				ps.setInt(1, model.getCID());
				ps.setInt(2, model.getCID());
				ps.setInt(3, model.getBoxid());
				result=ps.executeUpdate();
			   } catch (Exception e) {
				// TODO: handle exception
				   e.printStackTrace();
			}
			
			
		}
		return result;
	}
	
	public ResultSet loadBestSeller()
	{
		sql="select * from offer";
		try {
			conn=ConnectionProvider.getCon();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
		   } catch (Exception e) {
			// TODO: handle exception
			   e.printStackTrace();
		}
		

		return rs;
	}
	
	public ArrayList<HAmodel> bestHomeProduct(Offermodel model)
	{
		int product_id=model.getProductid();
		HAmodel mod=new HAmodel();
		mod.setProduct_id(product_id);
		HA dao=new HA();
		return dao.editProduct(mod);
	}
	
	public ArrayList<BroadBandmodel> bestBroadBand(Offermodel model)
	{
		int plan_id=model.getPlanid();
		BroadBandmodel mod=new BroadBandmodel();
		mod.setPlanid(plan_id);
		BroadBand dao=new BroadBand();
		return dao.preEditPlan(mod);
	}
	
	public ArrayList<DTHmodel> bestDTH(Offermodel model)
	{
		int box_id=model.getBoxid();
	    DTHmodel mod=new DTHmodel();
		mod.setBoxid(box_id);;
		DTH dao=new DTH();
		return dao.preEdit(mod);
	}


}
