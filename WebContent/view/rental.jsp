<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대여</title>
</head>
<body>
	<h3>대여</h3>
	<form action="rentBook" method="post">
		대여할 책 ID를 입력하세요 :
		<input type="text" name="rentalID" required/>
		<button type="submit">확인</button>
	</form>
</body>
</html>