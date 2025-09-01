<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
 	<c:if test="${not empty error}">
 		<h3 style="color: red;">아이디를 다시 작성해주세요</h3>
 	</c:if>
</body>
</html>