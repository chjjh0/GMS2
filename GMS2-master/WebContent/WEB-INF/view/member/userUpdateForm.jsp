<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*"%>
<%@ page import ="java.util.*"%>
<!-- "oracle.jdbc.driver.OracleDriver" -->
<!-- "jdbc:oracle:thin:@localhost:1521:xe","chjjh0", "c1c2" -->

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>userUpdateForm</title>
	<link rel="stylesheet" href="resources/css/style.css" />
</head>
<body>
	<form>
		  USERID<br>
		  <input type="text" name="userid"><br>
		  NEW PASSWORD<br>
		  <input type="text" name="newpassword"><br><br>
		  <input type="hidden" name="action" value="update" />
		  <input type="hidden" name="page" value="userLoginForm" />
		  <input type="submit" value="제출">
	</form>
<!-- <stript>
</stript> -->
</body>

</html>