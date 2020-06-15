<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String user = (String)session.getAttribute("id");
%>

<nav class="navbar navbar-dark bg-dark">
  <a class="navbar-brand" href=".">
    <img src="./public/img/logo.png" width="35" height="30" class="d-inline-block align-top" alt="">
    eLibrary
  </a>
  <ul class="nav">
  <c:set var="user" value="<%= user %>" />
  <c:if test="${user ne null}">
 	<li class="nav-item">
  		<a class="nav-link text-light" href="logoutUser">Logout</a>
 	</li> 
  </c:if>
  <c:if test="${user eq null}">
  	<li class="nav-item">
  		<a class="nav-link text-light" href="login">Login</a>
 	</li>
 	<li class="nav-item">
  		<a class="nav-link text-light" href="signup">Sign Up</a>
 	</li>
 	</c:if>
  </ul>
</nav>