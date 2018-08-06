<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%> 
<%@ page import="java.util.*"%>
<%@ page import="service.*"%>
<%@ page import="domain.*"%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>userUpdateResult</title>
</head>
<body>
<% 		
		MemberBean m = new MemberBean();
		m.setUserid(request.getParameter("userid"));
		m.setPassword(request.getParameter("password"));
		m.setUpdatePassword(request.getParameter("newpassword"));
		MemberServiceImpl.getInstance().updateMember(m);
		// if(MemberServiceImpl.getInstance().updateMember(m)){ 
			%> 
			<h3>비밀번호 변경 성공!!</h3>
			<%
		//}else{
			%> 
			<h3>비밀번호 변경 성공!!</h3>
			<%
		
%>
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
</html> --%>