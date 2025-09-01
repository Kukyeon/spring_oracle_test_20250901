<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공 확인</title>
</head>
<body>
	<h2>로그인 성공</h2>
	<hr>
	<h3>${sessionScope.sessionId} 님 반갑습니다만 배고픕니다.</h3>
	<br><hr>
	<a href="logout"> 로그 아웃 </a> <br> <br>
	<a href="bwrite"> 게시판 글쓰기 </a> <br> <br>
	<a href="blist"> 게시판 목록가기 </a>
</body>
</html>