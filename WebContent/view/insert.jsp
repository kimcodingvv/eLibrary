<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추가</title>
</head>
<body>
	<h3>추가</h3>
	<form action="addBook">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id"/>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title"/>
			</tr>
			<tr>
				<td>저자</td>
				<td><input type="text" name="author"/>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="price"/>
			</tr>
		</table>
		<button type="submit">저장</button>
	</form>
</body>
</html>