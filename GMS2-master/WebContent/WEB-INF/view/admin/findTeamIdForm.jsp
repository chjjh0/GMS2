<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>CHOSE A TEAM</h3>

ATEAM <input type="radio" id="myRadio" value="ATEAM"><br>
HTEAM <input type="radio" id="myRadio" value="HTEAM"><br>
STEAM <input type="radio" id="myRadio" value="STEAM"><br>
CTEAM <input type="radio" id="myRadio" value="CTEAM"><br>
<br>
<button onclick="test()">확인</button>

<script>
function test() {
    var x = document.getElementById("myRadio");
    x.checked = true;
    location.href =
		"${context}"
		+"/admin.do?action=search&page=findTeamIdResult&teamId=ATEAM";
};
</script>

</body>
</html>

</body>
</html>