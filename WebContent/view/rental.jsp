<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="UTF-8">
<title>대여</title>
</head>
<body>
	<div class="jumbotron">
	<h1 class="text-center">대여</h1>
	</div>
	<form action="rentBook" method="post">
		<div class="form-group row text-center">
		<label class="col-form-label col col-lg-2"> 대여할 책 ID를 입력하세요 : </label>
		<div class="col col-lg-3 mr-2">
			<input class="form-control" type="text" name="rentalID" required/>
		</div>
		<button class="btn btn-primary" type="submit">확인</button>
		</div>
	</form>
	<table class="table">
		<thead class="thead-dark">
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
					<td>
						<c:if test="${book.rent}">N</c:if>
						<c:if test="${!book.rent}">Y</c:if>
					</td>
					<td>${book.rentCnt}</td>
					<td><a href="rentBook?rentalID=${book.id}">대여</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>