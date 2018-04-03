package org.jsp.dao;

import java.sql.*;

import org.jsp.Db.DBUtil;
import org.jsp.bean.User;


public class LoginDao 
{
	public  boolean validate(String name,String password){    	
		try{  
			DBUtil db=new DBUtil();
		String sql= "select * from register where name=? and password=?";  
		PreparedStatement pst=db.createPST(sql);
		pst.setString(1, name);
		pst.setString(2, password);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			return true;
		}
	}catch(Exception e){System.out.println(e);	}
	return false;
	}
//When we give User class's object

public static boolean validate(User u){

	try{  
		DBUtil db=new DBUtil();
	String sql= "select * from register where name=? and password=?";  
	PreparedStatement pst=db.createPST(sql);
	pst.setString(1,u.getName());
	pst.setString(2,u.getPassword());
	ResultSet rs=pst.executeQuery();
	while(rs.next()){
		return true;
	}
}catch(Exception e){System.out.println(e);	}
return false;
}
}