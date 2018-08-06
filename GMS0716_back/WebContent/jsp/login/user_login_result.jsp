<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*"%>
<%@ page import ="java.util.*"%>
<%@ page import="service.*" %>
<%@ page import="domain.*" %>
<!-- "oracle.jdbc.driver.OracleDriver" -->
<!-- "jdbc:oracle:thin:@localhost:1521:xe","kstad", "1234" -->
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
<% 		
		MemberBean m = new MemberBean();
		m.setMemberId(request.getParameter("user-id"));
		m.setPass(request.getParameter("pass"));
		if(MemberServiceImpl.getInstance().login(m)){
			%> 
			<h3>로그인성공</h3>
			<%
		}else{
			%> 
			<h3>로그인실패</h3>
			<%
		}
%>
	
</body>
</html>