<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/menu.css">
</head>
<body>
	<div align="center">
		<div>
			<br>
		</div>
		<div>
			<!-- 메뉴부분 -->
			<ul>
				<li><a class="active" href="main.do">Home</a></li>
				<c:choose>
					<c:when test="${empty id}">
						<li><a href="loginForm.do">Login</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="logout.do">LogOut</a></li>
					</c:otherwise>
				</c:choose>
				<li><a href="noticeList.do">Notice</a></li>
				<li><a href="#">About</a></li>
				<li><a href="#">Product</a></li>
				<li><a href="#">Service</a></li>
				<li><a href="#">Members</a></li>
			</ul>
		</div>
	</div>
</body>
</html>