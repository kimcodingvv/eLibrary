<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="dao.BookInfoDao"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
</head>
<body>
	<h3>목록</h3>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>제목</th>
				<th>저자</th>
				<th>가격</th>
				<th>대여 가능</th>
				<th>대여 횟수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${bookList}" var="book">
				<tr>
					<td>${book.id}</td>
					<td>${book.title}</td>
					<td>${book.author}</td>
					<td>${book.price}</td>
					<td>
						<c:if test="${book.rental}">Y</c:if>
						<c:if test="${!book.rental}">N</c:if>
					</td>
					<td>${book.rentalCnt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>