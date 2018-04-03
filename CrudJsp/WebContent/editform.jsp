<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ page import="org.jsp.dao.UserDao, org.jsp.bean.*,java.util.*"%>

<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

if(session.getAttribute("username")==null)
  response.sendRedirect("login.jsp");
%>

<%
String id=request.getParameter("id");
User u=UserDao.getRecordById(Integer.parseInt(id));
%>

<h1>Edit Form</h1>
<form action="edituser.jsp" method="get">
<input type="hidden" name="id" value="<%=u.getId() %>"/>

<table>
<tr><td>Name</td> <td><input type="text" name="name" value="<%=u.getName() %>"/></td></tr>
<tr><td>Password</td> <td><input type="text" name="password" value="<%=u.getPassword() %>"/></td></tr>
<tr><td>Email</td> <td><input type="email" name="email" value="<%=u.getEmail() %>"/></td></tr>
<tr><td>Gender</td>
  <td><input type="radio" name="gender" value="male" checked> Male
  	  <input type="radio" name="gender" value="female"> Female</td></tr>
<tr><td>Country</td>
  <td><select name="country">
  <option >India</option>
  <option >Australia</option>
  <option >Africa</option>
  <option >USA</option>
  <option>Other</option>
</select></td>
<tr><td><input type="submit" value="Edit User"></td></tr>
</table>
</form>
<form action="Logout" >

 <input type="submit" value="Logout">
</form>
</body>
</html>