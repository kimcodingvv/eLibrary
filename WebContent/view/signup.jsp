<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<div class="jumbotron">
		<h1 class="text-center">회원 가입</h1>
	</div>
	
	<div class="container">
	<form action="addUser" method="post">
		<div class="form-group row">
			<div class="col-sm-2 text-center"><label for="inputID col-form-label">ID</label></div>
			<div class="col-sm-10">
			<input class="form-control" type="text" name="id" id="inputID" placeholder="아이디 입력"/></div>
		</div>
		<div class="form-group row">
			<div class="col-sm-2 text-center"><label for="inputPassword">비밀번호</label></div>
			<div class="col-sm-10">
				<input class="form-control" type="password" name="password" id="inputPassword" placeholder="비밀번호 입력" />
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-2 text-center"><label for="inputConfirmPw">비밀번호 확인</label></div>
			<div class="col-sm-10">
				<input class="form-control" type="password" name="confirmPw" id="inputConfirmPw" placeholder="비밀번호 확인" />
			</div>
		</div>
		<button class="btn btn-primary float-right" type="submit">가입</button>
	</form>
	</div>
</body>
</html>