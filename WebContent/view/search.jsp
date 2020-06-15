<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="UTF-8">
<title>검색</title>
</head>
<body>
	<div class="jumbotron">
	<h1 class="text-center">검색</h1>
	</div>
	<form action="search" method="get">
		<div class="form-group row text-center">
		<div class="col-lg-2"><select class="custom-select col-lg" name="column">
			<option value="id">ID</option>
			<option value="title">제목</option>
			<option value="author">저자</option>
		</select></div>
		<div class="col-lg-2"><label class="col-form-label"> 검색어를 입력하세요 : </label></div>
		<div class="col-lg-3 mr-2">
			<input class="form-control" type="text" name="value" required/>
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
					<td>
					<c:if test="${!book.rent}">
						<a href="rentBook?rentalID=${book.id}">대여</a>
					</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>