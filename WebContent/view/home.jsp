<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<%
	String user = (String)session.getAttribute("id");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈</title>
</head>
<body>
	<div class="jumbotron">
		<h1 class="text-center">홈</h1>
	</div>
	<div class="container">
		<p class="h4">
			Welcome!
			<c:set var="user" value="<%= user %>" />
			<c:if test="${not empty user}"> ${user} </c:if>
			<br />
			<br />
			JSP &amp; Servlet &amp; Mysql을 사용한 MVC 구조의 전자도서관 페이지입니다.
		</p>
	</div>
</body>
</html>