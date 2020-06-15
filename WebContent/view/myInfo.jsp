<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보</title>
</head>

<body>
	<div class="jumbotron">
		<h1 class="text-center">내 정보</h1>
	</div>
	
	<div class="container">
	<form action="changePw" method="post">
		<div class="form-group row">
			<div class="col-sm-2 text-center"><label for="userId" class="col-form-label">ID</label></div>
			<div class="col-sm-10">
			<input class="form-control" type="text" name="id" id="userId" value="${id}" readonly/></div>
		</div>
		<div class="form-group row">
			<div class="col-sm-2 text-center"><label for="inputPassword">현재 비밀번호</label></div>
			<div class="col-sm-10">
				<input class="form-control" type="password" name="password" id="inputPassword" placeholder="비밀번호 입력" />
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-2 text-center"><label for="newPassword">새 비밀번호</label></div>
			<div class="col-sm-10">
				<input class="form-control" type="password" name="newPw" id="newPassword" placeholder="새 비밀번호 입력" />
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-2 text-center"><label for="confirmNewPassword">새 비밀번호 확인</label></div>
			<div class="col-sm-10">
				<input class="form-control" type="password" name="confirmNewPw" id="confirmNewPassword" placeholder="새 비밀번호 확인" />
			</div>
		</div>
		<button class="btn btn-primary float-right" type="submit">비밀번호 변경</button>
	</form>
	<br/>
	<br/>
	<br/>
	<form action="deleteUser" method="post">
		<input type="hidden" name="id" value="${id}" /> 
		<div class="form-group row">
			<div class="col-sm-2 text-center"><label for="inputPassword">현재 비밀번호</label></div>
			<div class="col-sm-10">
				<input class="form-control" type="password" name="password" id="inputPassword" placeholder="비밀번호 입력" />
			</div>
		</div>
		<button class="btn btn-primary float-right" type="submit">탈퇴</button>
	</form>
	</div>
</body>
</html>