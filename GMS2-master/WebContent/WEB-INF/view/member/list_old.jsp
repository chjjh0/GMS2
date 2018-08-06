<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%> 
<%@ page import="java.util.*"%>
<%@ page import="service.*"%>
<%@ page import="domain.*"%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>list</title>
</head>
<body>
<%
	List<MemberBean> lst = MemberServiceImpl
	.getInstance()
	.findList();
%>
	<table border = "1">
	<tr>
	<th>아이디</th>
	<th>이름</th>
	<th>비번</th>
	<th>팀명</th>
	<th>직책</th>
	</tr>
<%
for(MemberBean m : lst){
%>
<tr>
	<td><%=m.getUserid() %></td>
	<td><%=m.getName() %></td>
	<td><%=m.getPassword() %></td>
	<td><%=m.getTeamId() %></td>
	<td><%=m.getRoll() %></td>
</tr>
<%
}
%>
	</table>
	<!-- /* 
	-- 보안이 취약한 구시대 코딩법, 지금은 절대 쓰면 안되는 소스
	-- 지금은 service, DAO를 만들어 보안을 강화하여 관리
	
	String sql = String.format(
			" SELECT * FROM MEMBER "
			+ " WHERE MEMBER.ID LIKE '%s' "
			+ " AND MEMBER.PASSWORD '%s' ", userid, password
			
			);
	ResultSet rs = stmt.executeQuery(sql);
	if(rs.next()){
		List<String> list = new ArrayList<>();
	do {
	list.add(rs.getString("MEMID"));
	list.add(rs.getString("TEAMID"));
	list.add(rs.getString("NAME"));
	list.add(rs.getString("AGE"));
	list.add(rs.getString("ROLL"));
	list.add(rs.getString("PASSWORD")); */ -->
	
</body>
</html>

 --%>