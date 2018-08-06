<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<link rel="stylesheet" href="${context}/resources/css/style.css" />
<jsp:include page="../common/head.jsp"/>
<body>
	<div class="margin-200-auto text-align width-200 border">
	<h2 class="text-align">회원가입</h2>
		<form id="userJoinForm" name="jsonJoinForm">
		  USERID<br>
		  <input type="text" name="userid"><br><br>
		  PASSWORD<br>
		  <input type="text" name="password"><br><br>
		  NAME<br>
		  <input type="text" name="name"><br><br>
		  SSN<br>
		  <input type="text" name="ssn"><br><br>
		  <input type="hidden" name="action" value="create"/>
		  <input type="hidden" name="page" value="userLoginForm"/>
		  <!-- <input type="hidden" name="gender" />
		  <input type="hidden" name="age" /> -->
	<br>
	소속팀
		<input type="radio" name="teamid" 
			value="none" checked="checked"/>없음
		<input type="radio" name="teamid" 
			value="ATEAM" />걍놀자
		<input type="radio" name="teamid" 
			value="HTEAM" />지은이네
		<input type="radio" name="teamid" 
			value="CTEAM" />왕거북이
		<input type="radio" name="teamid" 
			value="STEAM" />코딩짱
	<br>	
	프로젝트역활
		<select name="roll" id="roll">
			<option value="leader">팀장</option>
			<option value="front">프론트개발</option>
			<option value="back">백단개발</option>
			<option value="android">안드로이드개발</option>
			<option value="minfe">민폐</option>
		</select>		
	<br>
	수강과목
		<input type="checkbox" name="subject" value="java" checked="checked"/> Java
		<input type="checkbox" name="subject" value="clang"/> C언어
		<input type="checkbox" name="subject" value="JSPlang"/> JSP
		<input type="checkbox" name="subject" value="PHP"/> PHP
		<input type="checkbox" name="subject" value="nodejs"/> NodeJS
		<input type="checkbox" name="subject" value="linux"/> Linux
		<input type="checkbox" name="subject" value="html"/> HTML
		<input type="checkbox" name="subject" value="spring"/> Spring
		<br><br>	
		<input type="button" id="userJoinBth" value="제출">
		</form>
	</div>
<script>
document.getElementById('userJoinBth')
.addEventListener('click',function(){
	var x = (service.nullChecker({
		 memId : document.jsonJoinForm.userid.value,
		 password : document.jsonJoinForm.password.value,
		 name : document.jsonJoinForm.name.value,
		 ssn : document.jsonJoinForm.ssn.value}));
	if(x.checker){
		var form = document.getElementById('userJoinForm');
		form.action = "${context}/member.do";
		form.method = "POST";
		member.join({
			 memId : form.userid.value,
			 password : form.password.value,
			 name : form.name.value,
			 ssn : form.ssn.value});
		/* document.joinForm.gender.value = member.getGender();
		document.joinForm.age.value = member.getAge(); */
		form.submit();
	} else {
		alert(x.text);
	}
});
</script>
</body>
</html>