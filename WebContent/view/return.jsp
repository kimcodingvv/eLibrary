<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반납</title>
</head>
<body>
	<div class="jumbotron">
		<h1 class="text-center">반납</h1>
	</div>
	<table class="table">
		<thead class="thead-light">
			<tr>
				<th scope="col">ID</th>
				<th scope="col">제목</th>
				<th scope="col">저자</th>
				<th scope="col">가격</th>
				<th scope="col">대여 가능</th>
				<th scope="col">대여 횟수</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${bookList}" var="book">
				<tr>
					<td scope="row">${book.id}</td>
					<td>${book.title}</td>
					<td>${book.author}</td>
					<td>${book.price}</td>
					<td><c:if test="${book.rent}">N</c:if> <c:if
							test="${!book.rent}">Y</c:if></td>
					<td>${book.rentCnt}</td>
					<td><c:if test="${book.rent}">
							<a href="returnBook?id=${book.id}">반납</a>
						</c:if></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>