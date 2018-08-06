<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="Login-box">
	<a onclick="common.move('member','move','userLoginForm')"> <!-- function -->
	LOGIN</a>
	&nbsp;&nbsp;&nbsp;
	<a onclick="common.move('member','move','joinForm')">JOIN</a>		
</div>
<script>
document.getElementById('moveLoginForm')
.addEventListener('click', function(){
	alert('클릭 이벤트 체크 !!');
	common.move('member', 'move', 'loginForm');
});
</script> --%>