<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="content">
	<div id="content-box">
		<h1>ADMIN MANGEMENT</h1>
	<select name="option" id="idoption">
		<option value="none">검색조건</option>
        <option value="memid">ID</option>
        <option value="name">이름</option>
        <option value="teamid">팀명</option>
    </select>
      &nbsp;&nbsp;
      <input type="text" id="word" placeholder="keyword"></input>
      &nbsp;&nbsp;
      <input type="button" id="searchBtn" value="search"></input>
		<table id="contentBoxTab">
		<tr id="contentBoxMeta">
			<th>아이디</th>
			<th>이 름</th>
			<th>나 이</th>
			<th>성 별</th>
			<th>역 활</th>
			<th>팀 명</th>
		</tr>
		<c:forEach items="${list}" var="member">
		<tr>
			<td>${member.memId}</td>
			<%-- <td><a href="${context}/admin.do?action=retrieve&page=memberDetail&user_id=${member.memberId}" style="cursor: pointer;">${member.name}</a></td> --%> <!-- 이렇게 하지 말자 -->
			<td><a class="username" id="${member.memId}">${member.name}${user.name}</a></td>
			<td>${member.age}</td>
			<td>${member.gender}</td>
			<td>${member.roll}</td>
			<td>${member.teamId}</td>
		</tr>
		</c:forEach>
		<%-- ${count/5} --%>
		<tr>
			<td colspan="6">
				<ul class="pageBox">
					<c:forEach begin="${beginPage}" end="${endPage}" step="1" varStatus="i">
					<li>
						<a id="listPage">
							${i.index}
						</a>
					</li>
					</c:forEach>
					<c:if test="${count gt 25}">
						<li>다음</li>
					</c:if>
				</ul>
				<%-- <span class="pageNum" id="page${i}"> ${i} </span> --%>				
			</td>
		</tr>
		
	</table>
	</div>
</div>
<script>
admin.main('${context}');
document.getElementById('listPage')
.addEventListener('click', function(){
		location.href = "${context}"
			+"/admin.do?"
			+"action=list"
			+"&page=adminMain"
			+"&pageNum=${i.index}"
});


/* document.getElementById('searchBtn')
.addEventListener('click',function(){
	if(document.getElementById('idoption').value !== 'none'){
		if(document.getElementById('word').value!==""){
			var action = "";
			var page = "";
			switch(document.getElementById('idoption').value){
			case 'memid' :
				action = "retrieve";
				page = "memberDetail"
				break;
			case 'name' : case 'teamid' :
				action = "search";
				page = "adminMain";
				break;
			default : break;
			}
	location.href = "${context}"
	+"/admin.do?"
	+"action="+action
	+"&page="+popage
	+"&option="
	+document.getElementById('idoption').value
	+"&word="
	+document.getElementById('word').value
	+"&table=member"
	}else{
		alert('검색어를 입력하세요.');
	}
}else{
	 alert('검색조건을 선택하세요');
}
})();  */
/* admin.main('${context}'); */
/* document.getElementById('searchBtn')
.addEventListener('click',function(){
	var searchSel = document.getElementById('content-boxForm');
	var searchOpt = searchSel.searchSelect.value;
	/* alert(searchOpt);
	alert(searchSel.searchKeyword.value); 
	if(searchOpt === 'memid') {
		location.href =
			"${context}"
			+ "/admin.do?action=retrieve&page=adminMain&"
			+ "selectOpt=" + searchOpt
			+ "&keyword=" + searchSel.searchKeyword.value;
	} else if (searchOpt === 'teamid') {
		location.href =
			"${context}"
			+ "/admin.do?action=search&page=adminMain&"
			+ "selectOpt=" + searchOpt
			+ "&keyword=" + searchSel.searchKeyword.value;
	} else if (searchOpt === 'name') {
		location.href =
			"${context}"
			+ "/admin.do?action=search&page=adminMain&"
			+ "selectOpt=" + searchOpt
			+ "&keyword=" + searchSel.searchKeyword.value;
	}
});
 */

</script>