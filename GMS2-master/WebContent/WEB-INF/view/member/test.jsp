<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*"%>
<%@ page import ="java.util.*"%>
<!-- "oracle.jdbc.driver.OracleDriver" -->
<!-- "jdbc:oracle:thin:@localhost:1521:xe","chjjh0", "c1c2" -->
<% 		
		String userid = request.getParameter("user-id");
		String pass = request.getParameter("pass");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.
				getConnection("jdbc:oracle:thin:@localhost:1521:xe"
						,"chjjh0", "c1c2");
		Statement stmt = conn.createStatement();
		String sql = String.format(
				"SELECT MEMID, "
						+" TEAMID, "
						+" NAME, "
						+" AGE, "
						+" ROLL, "
						+" PASSWORD "
						+" FROM MEMBER "
						+" WHERE MEMID LIKE '%s' "
						+" AND PASSWORD LIKE '%s' "
						, userid, pass);
		ResultSet rs = stmt.executeQuery(sql);
		List<String> list = new ArrayList<>();
		while(rs.next()){
		list.add(rs.getString("MEMID"));
		list.add(rs.getString("NAME"));
		}
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
	<h3>사용자가 입력한 ID : <%= list.get(0)%></h3>
	<h3>사용자가 입력한 PASS : <%= list.get(1)%></h3>
</body>
</html>