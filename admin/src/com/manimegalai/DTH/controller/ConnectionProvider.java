package com.manimegalai.DTH.controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider implements DataBase {
	
	private static Connection con=null;  
	static{  
	try{  
	Class.forName(Driver);  
	con=DriverManager.getConnection(Url,username,Password);  
	}catch(Exception e){}  
	}  
	  
	public static Connection getCon(){  
	    return con;  
	}  

}
