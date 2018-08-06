<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*"%>
<%@ page import ="java.util.*"%>
<%@ page import ="domain.*"%>
<%@ page import ="service.*"%>
<!-- "oracle.jdbc.driver.OracleDriver" -->
<!-- "jdbc:oracle:thin:@localhost:1521:xe","chjjh0", "c1c2" -->
<%
	String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>listForm</title>
</head>
<body>
	<form action="<%=ctx %>/member/list/.do">
		  <input type="submit" value="전체리스트">
	</form>
	<form action="listbyname.jsp">
		  <input type="text" name="name" value="이름">
		  <input type="submit" value="이름으로 찾기">
	</form>
	<form action="listbyId.jsp">
		  <input type="text" name="userid" value="ID">
		  <input type="submit" value="ID로 찾기">
	</form>
</body>
</html>
		