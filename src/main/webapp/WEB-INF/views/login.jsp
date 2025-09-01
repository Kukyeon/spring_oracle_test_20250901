<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 로그인</title>
</head>
<body>
	<h2>회원 로그인</h2>
	<hr>
	<form action="loginOk" method="post">
		아이디 : <br> <input type="text" name="memberid"> <br> <br>
		비 번 : <br> <input type="password" name="memberpw"> <br> <br>
		<input type="submit" value="로그인">
	</form>
	
		<c:if test="${not empty error}">
 		<h3 style="color: red;">아이디 또눈 비밀번호를 다시 작성해주세요</h3>
 	</c:if>
</body>
</html>