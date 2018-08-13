<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp"/>
<body>	
<div id="wrapper">
	<div id="header">
		<h1>관리자 페이지</h1>
		<jsp:include page="../common/menu-box.jsp"/>
	</div> <!-- header end -->
</div>
<div>
<jsp:include page="../member/search.jsp"/>
</div>
<div id="footer">주소</div>
<script>
	admin.main('${context}');
</script>
</body>
</html>