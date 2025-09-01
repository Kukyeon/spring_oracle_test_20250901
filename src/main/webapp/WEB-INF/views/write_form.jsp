<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 쓰기</title>
</head>
<body>
	<!-- 로그인 하지 않은 경우 로그인 페이지로 이동 -->
	<c:if test="${empty sessionScope.sessionId }">
		<c:redirect url="login" />
	</c:if>
	<h2>게시판 글 작성</h2>
	<hr>
	<form action="bwriteOk"> 
		제목 <br><input type="text" name="btitle" size="50"><br>
		내용 <br><textarea rows="10" cols="45" name="bcontent"></textarea><br>
		글쓴이 <br> <input type="text" value="${sessionScope.sessionId}" name="bwriter" readonly="readonly"> <br>
		<input type="submit" value="글쓰기">
	</form>
</body>
</html>