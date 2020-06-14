<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추가</title>
</head>
<body>
	<div class="jumbotron">
		<h1 class="text-center">추가</h1>
	</div>
	
	<div class="container">
	<form action="addBook">
		<div class="form-group row">
			<div class="col-sm-1 text-center"><label for="inputID col-form-label">ID</label></div>
			<div class="col-sm-11">
			<input class="form-control" type="text" name="id" id="inputID" placeholder="아이디 입력"/></div>
		</div>
		<div class="form-group row">
			<div class="col-sm-1 text-center"><label for="inputTitle">제목</label></div>
			<div class="col-sm-11">
				<input class="form-control" type="text" name="title" id="inputTitle" placeholder="제목 입력" />
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-1 text-center"><label for="inputAuthor">저자</label></div>
			<div class="col-sm-11">
				<input class="form-control" type="text" name="author" id="inputAuthor" placeholder="저자 입력" />
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-1 text-center"><label for="inputPrice">가격</label></div>
			<div class="col-sm-11">
				<input class="form-control" type="text" name="price" id="inputPrice" placeholder="가격 입력" />
			</div>
		</div>
		<button class="btn btn-primary" type="submit">저장</button>
	</form>
	</div>
</body>
</html>