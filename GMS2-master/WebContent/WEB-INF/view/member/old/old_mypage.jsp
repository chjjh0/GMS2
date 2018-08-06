<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>mypage</title>
	<link rel="stylesheet" href="resources/css/style.css" />
</head>
<body>
	<div class="margin-200-auto text-align width-200 border">
		<h1 class="text-align">${user.userid} 마이 페이지</h1>
	<form>
		  USERID<br>
		  <input type="text" name="userid"><br>
		  NEW PASSWORD<br>
		  <input type="text" name="newpassword"><br><br>
		  <input type="hidden" name="action" value="update" />
		  <!-- <input type="hidden" name="page" value="userLoginForm" /> -->
		  <input type="submit" value="제출">
	</form>
	</div>
</body>
</html> --%>