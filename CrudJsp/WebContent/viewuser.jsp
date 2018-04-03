<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Users</title>
<style>
table, th, td {
    border: 1px solid black;
}
</style>
</head>
<body>

<%@ page import="org.jsp.dao.UserDao, org.jsp.bean.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%  
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		if(session.getAttribute("username")==null)
	  	response.sendRedirect("login.jsp");
%>
<h1>User List</h1>

<%
List<User> list=UserDao.getAllRecord();
request.setAttribute("list",list);
%>
<table>
<tr>
<th>Id</th> <th>Name</th> <th>Password</th> <th>Email</th>  
<th>Gender</th> <th>Country</th ><th>Edit</th> <th>Delete</th></tr>  

<c:forEach items="${list}" var="u">
  
<tr><td>${u.getId()}</td> <td>${u.getName()}</td> <td>${u.getPassword()}</td>  
<td>${u.getEmail()}</td> <td>${u.getGender()}</td> <td>${u.getCountry()}</td>  
<td><a href="editform.jsp?id=${u.getId()}">Edit</a></td>  
<td><a href="deleteuser.jsp?id=${u.getId()}">Delete</a></td></tr>  
</c:forEach>  
</table>  

<br/><a href="adduserform.jsp">Add New User</a>  
<form action="Logout" >

 <input type="submit" value="Logout">
</form>
</body>
</html>