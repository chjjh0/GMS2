<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="menu-box">
	<ul id="menu">
		<li><a id="moveHome">HOME</a></li>
		<li><a id="moveAbout">ABOUT</a></li>
		<li><a id="moveAdmin">ADMIN</a></li>
	</ul>
</div>
<script>
document.getElementById('moveHome')
.addEventListener('click', function(){
	location.href = '${context}'+'/common.do'});
document.getElementById('moveAdmin')	
.addEventListener('click', function(){
	alert("${context}");
	admin.check('${context}');
	});
/* .addEventListener('click', function(){
	location.href = '${context}'+'/common.do'}); */
/* location.pathname */
</script>