<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/header.jsp"%>
<meta charset="UTF-8">
<title>eLibrary</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/include/sidebar.jsp"%>
			<main class="col-md-9 col-lg-10">
				<!-- content -->
				<% String action = request.getAttribute("action").toString(); %>
				<c:import url='<%=action + ".jsp"%>'/>
			</main>
		</div>
	</div>
</body>
</html>