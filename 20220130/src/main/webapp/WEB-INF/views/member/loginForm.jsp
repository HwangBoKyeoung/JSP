<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<div align="center">
		<jsp:include page="../main/header.jsp" />
		<div>
			<h2>로 그 인</h2>
		</div>
		<form action="login.do" method="post">
			<div>
				<table border='1'>
					<tr>
						<th width="200px">아이디</th>
						<td width="200px"><input type="text" name="id" id="id" required></td>
					</tr>
					<tr>
						<th width="200px">비밀번호</th>
						<td width="200px"><input type="password" name="password" id="password" required></td>
					</tr>
				</table>
			</div>
			<br>
			<div>
				<input type="submit" value="로그인"> 
				<input type="reset" value="초기화">
			</div>
		</form>
	</div>
</body>
</html>