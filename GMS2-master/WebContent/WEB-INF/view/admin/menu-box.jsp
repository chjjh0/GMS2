<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu-box">
	<ul id="menu">
		<li><a href="${context}">HOME</a></li>
		<li><a href="${context}/admin.do?action=list&page=adminMain">ADMIN HOME</a></li>
		<li><a href="${context}/admin.do?action=search&page=adminMain">MEMBER LIST</a></li>
		<li><a id="findByTeam">FIND BY TEAM ID</a></li>
		<li><a href="${context}/admin.do?action=retrieve&page=adminMain">FIND BY ID</a></li>
	</ul>
</div>
<script >
document.getElementById('findByTeam')
.addEventListener('click',function(){
	var newWindow;
	 newWindow = window.open("${context}/admin.do?action=move&page=findTeamIdForm",
			 "myWindow", "width=500,height=500");
	 newWindow.focus();
});
/* 	location.href =
		"${context}"
		+"/admin.do?action=search&page=adminMain&teamId="
		+prompt('팀 이름을 입력하세요.');
		});
 */ 
/*  function(){
		location.href =
			"${context}"
			+"/admin.do?action=search&page=adminMain&teamId="
			+prompt('팀 이름을 입력하세요.');
			}); */
		
/* 		
	var admin = (()=>{
		return{
			check : x=>{
			var isAdmin = confirm('관리자입니까?');
				if(isAdmin){
					var password = prompt('관리자 비밀번호를 입력 바랍니다');
					if(password == 1){
						router.move({
							context : x,
							domain : 'admin',
							action : 'list',
							page : 'adminMain'});
					}
					} else {
						alert('관리자만 접근 가능합니다');
					}
				}
		};})();
 */
</script>