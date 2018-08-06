<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="findTeam">
	<div id="findTeamIdResult">
		<h3>FIND TEAMID RESULT</h3>
	<table>
		<tr>
			<th>아이디</th>
			<th>이 름</th>
			<th>나 이</th>
			<th>성 별</th>
			<th>역 활</th>
			<th>팀 명</th>
		</tr>
		<c:forEach items="${listbyTeamId}" var="team">
		<tr>
			<td>${team.memId}</td>
			<%-- <td><a href="${context}/admin.do?action=retrieve&page=teamDetail&user_id=${team.teamId}" style="cursor: pointer;">${team.name}</a></td> --%> <!-- 이렇게 하지 말자 -->
			<td>${team.name}</td>
			<td>${team.age}</td>
			<td>${team.gender}</td>
			<td>${team.roll}</td>
			<td>${team.teamId}</td>
		</tr>
		</c:forEach>
		
	</table>
</div>
</div>
<script>
</script>