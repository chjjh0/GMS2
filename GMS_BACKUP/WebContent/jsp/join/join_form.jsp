<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "domain.*" %>
<!-- memberId,TeamId,name,age,roll,pass  -->
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원가입화면</title>
	<link rel="stylesheet" href="../../css/style.css" />
</head>
<body>
	<div class="margin-200-auto text-align width-200 border">
		<h2 class="text-align">회원가입</h2>
		<form action="join_result.jsp">
		ID<br>
		<input type="text" name="user-id" value="아이디"/><br>
		비밀번호<br>
		<input type="text" name="pass" value="비밀번호"/><br>
		이름 <br>
		<input type="text" name="name" value="이름"/><br>
		주민번호<br>
		<input type="text" name="ssn" value="주민번호"/><br>	
		<input type="submit" value="제출"/>
		</form>
	</div>
	
</body>
</html>