<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<link rel="stylesheet" href="resources/css/style.css" />
</head>
<body>
	<div class="margin-200-auto text-align width-200 border">
	<h3 class="text-align">회원탈퇴</h3>
		<form action="${context}/member.do">
		ID <br>
		<input type="text" name="user-id"/><br>
		비밀번호 <br>
		<input type="text" name="pass"/><br>
		<input type="hidden" name="action" value="delete"/>
		<input type="hidden" name="page" value=""/>
		<input type="submit" value="제출" />
		</form>
	</div>
	<jsp:include page="../common/gateFunction.jsp"/>
</body>
</html>