package org.jsp.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.jsp.Db.DBUtil;
import org.jsp.bean.User;

public class UserDao {
	
/*public static Connection getConnection(){
	
	Connection con=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jspcrut","root","root");
		
	}catch(Exception e){
		System.out.println(e);
	}
return con;	
}*/

/*public boolean validate(User u){
	boolean status=false;
	try{
		DBUtil db=new DBUtil();
		String sql="select * from register where name=?,password=?";
		PreparedStatement pst=db.createPST(sql);
		pst.setString(1, u.getName());
		pst.setString(2,u.getPassword());
		ResultSet rs=pst.executeQuery();
		status=rs.next();
	}catch(Exception e){System.out.println(e);	}
	return status;
	
}*/	
	
public static int save(User u){
	int status=0;
	try{
		
		//Connection con=getConnection();
		DBUtil db= new DBUtil();
		
		
		String	sql="insert into register (name,password,email,gender,country) values(?,?,?,?,?)";
	    PreparedStatement pst= db.createPST(sql);
	    pst.setString(1,u.getName());
	    pst.setString(2,u.getPassword());
	    pst.setString(3,u.getEmail());
	    pst.setString(4,u.getGender());
	    pst.setString(5,u.getCountry());
	    status=pst.executeUpdate();		
		}catch(Exception e){System.out.println(e);}
		return status;	
}
public static int update(User u){
	int status=0;
	try{
		//Connection con=getConnection();
		DBUtil db= new DBUtil();
		String	sql="update register set name=?,password=?,email=?,gender=?,country=? where id=?";
	  //  PreparedStatement pst= con.prepareStatement(sql);
		  PreparedStatement pst= db.createPST(sql);
		  pst.setString(1,u.getName());
	    pst.setString(2,u.getPassword());
	    pst.setString(3,u.getEmail());
	    pst.setString(4,u.getGender());
	    pst.setString(5,u.getCountry());
	    pst.setInt(6,u.getId());
	    status=pst.executeUpdate();		
		}catch(Exception e){System.out.println(e);}
		return status;
}
public static int delete(User u){
	int status=0;
	try{
//		Connection con=getConnection();
		DBUtil db= new DBUtil();
		String	sql="delete from register where id=?";
		//PreparedStatement pst=con.prepareStatement(sql);
		  PreparedStatement pst= db.createPST(sql);
		  pst.setInt(1,u.getId());
		status=pst.executeUpdate();
	}catch(Exception e){
		System.out.println(e);
	}	
	return status;
}

public static List<User> getAllRecord(){

	List<User> list=new ArrayList<User>();
	
	try{
//		Connection con=getConnection();
		DBUtil db= new DBUtil();
		String sql="select * from register";
		//PreparedStatement pst=con.prepareStatement(sql);
		  PreparedStatement pst= db.createPST(sql);
		  ResultSet rs=pst.executeQuery();
		while(rs.next()){
			User u=new User();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setPassword(rs.getString("password"));
			u.setEmail(rs.getString("email"));
			u.setGender(rs.getString("gender"));
			u.setCountry(rs.getString("country"));
			list.add(u);
		}
	}catch(Exception e){System.out.println(e);}
	return list;
}

public static User getRecordById(int id){
	
	User u=null;
	try{
//		Connection con=getConnection();
		DBUtil db= new DBUtil();
		String sql="select * from register where id=?";
		//PreparedStatement pst=con.prepareStatement(sql);
		  PreparedStatement pst= db.createPST(sql);
		  pst.setInt(1,id);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			u=new User();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setPassword(rs.getString("password"));
			u.setEmail(rs.getString("email"));
			u.setGender(rs.getString("gender"));
			u.setCountry(rs.getString("country"));
        }
	}catch(Exception e){System.out.println(e);}
	return u;
	}

public boolean validate(String name, String password) {
	// TODO Auto-generated method stub
	return false;
}
}




