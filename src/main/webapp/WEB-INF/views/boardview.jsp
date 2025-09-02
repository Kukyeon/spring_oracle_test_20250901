<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 상세 글</title>
</head>
<body>
	<h2>게시판 상세 보기 및 수정</h2>
	<hr>
	<form action="boardmodify">
		<hr>
		제목 <br><input type="text" name="btitle" value="${boardDao.btitle}" > <br>
		내용<br> <textarea rows="10" cols="45" name="bcontent">${boardDao.bcontent}</textarea><br>
		작성자 <br><input type="text" name="bwriter" value="${boardDao.bwriter}"><br>
		작성일<br><input type="text" name="bdate" value="${boardDao.bdate}"><br>
		<input type="hidden" name="bnum" value="${boardDao.bnum}"><br>
		<hr><hr>
	<br>	<input type="submit" value="수정">
		<input type="button" value="글목록" onclick="javascript:window.location.href='blist'">
	</form>
</body>
</html>