<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*"%>
<%@ page import ="java.util.*"%>
<!-- "oracle.jdbc.driver.OracleDriver" -->
<!-- "jdbc:oracle:thin:@localhost:1521:xe","chjjh0", "c1c2" -->
<%
	
%>		
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>userDeleteForm</title>
</head>
<body>
	<form action="userDeleteResult.jsp">
		     지울 이름을 입력하시오<br>
		  <input type="text" name="name"><br>
		  <input type="submit" value="CONFIRM">
	</form>
</body>
</html>
		