<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

if(session.getAttribute("username")==null)
  response.sendRedirect("login.jsp");
%>
<h1>Welcome! ${username}</h1>

<a href="login.jsp">Login</a><br>
<a href="adduserform.jsp">Add User</a><br>
<a href="viewuser.jsp">View User</a><br>

<form action="Logout" >

 <input type="submit" value="Logout">
</form>
</body>
</html>