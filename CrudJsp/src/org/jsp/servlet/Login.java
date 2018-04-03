package org.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsp.dao.LoginDao;


@WebServlet("/Login")
public class Login extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  LoginDao dao=new LoginDao();
	  String name = request.getParameter("name");
	  String password = request.getParameter("password");
	  PrintWriter out=response.getWriter();
	  
	  try{
		                                    //if(uname.equals("cb") && pass.equals("1234"))
		  if(dao.validate(name,password))
		  {
		    HttpSession session =request.getSession();
			session.setAttribute("username", name);
			session.setAttribute("password", password);
		    response.sendRedirect("welcome.jsp");
		  }
		  else
		  {
			  out.print("Error Occured");
			  response.sendRedirect("login.jsp");
		  }
		  
	  }catch(Exception e){out.print(e);}
	 
   }
}
