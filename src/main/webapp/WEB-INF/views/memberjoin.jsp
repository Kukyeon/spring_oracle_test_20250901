<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
 	<h2>회 원 가 입</h2>
 	<hr>
 	<form action="joinOk" method="post"> 
 		아이디<br> <input type="text" name="memberid"><br>
 		비밀번호	<br><input type="text" name="memberpw"><br>
 		이름<br>	<input type="text" name="membername"><br>
 		<input type="submit" value="회원가입">
 	</form>
</body>
</html>