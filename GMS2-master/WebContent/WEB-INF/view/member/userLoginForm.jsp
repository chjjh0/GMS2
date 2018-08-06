<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>GMS</title>
	<link rel="stylesheet" href="${context}/resources/css/style.css" />
	<jsp:include page="../common/head.jsp"/>
</head>
<body>
	<div class="margin-200-auto text-align width-200 border">
	<h2 class="text-align">사용자 로그인</h2>	
		<form id="userLoginForm" name="jsonLoginForm">
		  USERID<br>
		  <input type="text" name="userid"><br>
		  PASSWORD<br>
		  <input type="text" name="password"><br><br>
		  <input type="hidden" name="action" value="login" />
		  <input type="hidden" name="page" value="mypage" />
		  <input type="button" id="userLoginFormBtn" value="LOGIN"/>
	</form><br>
	</div>
<script>
	document.getElementById('userLoginFormBtn')
	.addEventListener('click', function(){
		var x = service.nullChecker(
				{id:document.jsonLoginForm.userid.value,
				pwd:document.jsonLoginForm.password.value});
		if(x.checker){
			var form = document.getElementById("userLoginForm");
				form.action = "${context}/member.do";
				form.method = "post"; 
		   		form.submit();
		} else {
				alert(x.text);
		};	
	});
</script>
</body>
</html>