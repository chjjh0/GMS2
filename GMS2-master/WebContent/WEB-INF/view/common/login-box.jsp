<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="Login-box">
	<a id="moveLoginForm">LOGIN</a>
			&nbsp;&nbsp;
	<a id="moveJoin">JOIN</a>
</div>
<script>
document.getElementById('moveLoginForm')
.addEventListener('click', function(){
	router.move({
		context : '${context}',
		domain : 'member',
		action : 'move',
		page : 'userLoginForm'});
});
document.getElementById('moveJoin')
.addEventListener('click', function(){
	router.move({
		context : '${context}',
		domain : 'member',
		action : 'move',
		page : 'userJoinForm'});
});
/* document.getElementById('moveJoinForm')
.addEventListener('click', function(){
	router.move({
		context : '${context}',
		domain : 'member',
		action : 'move',
		page : 'userJoinForm'});
});
 */</script>