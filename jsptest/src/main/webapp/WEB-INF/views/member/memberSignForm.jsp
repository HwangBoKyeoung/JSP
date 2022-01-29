<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>회  원  가  입</h1>
		</div>
		<div>
			<form id="frm" action="memberJoin.do" method="post">
				<div>
					<table border='1'>
						<tr>
							<th width='100'>아 이 디</th>
							<td width='150'><input type="text" name="id" id="id"></td>
						</tr>
						<tr>
							<th width='100'>비밀번호</th>
							<td width='150'><input type="password" name="password" id="password"></td>
						</tr>
						<tr>
							<th width='100'>이름</th>
							<td width='150'><input type="text" name="name" id="name"></td>
						</tr>
						<tr>
							<th width='100'>전화번호</th>
							<td width='150'><input type="text" name="tel" id="tel"></td>
						</tr>
						<tr>
							<th width='100'>주소</th>
							<td width='150'><input type="text" name="address" id="address"></td>
						</tr>
						<tr>
							<th width='100'>권한</th>
							<td width='150'><input type="text" name="author" id="author" readonly value="USER"></td>
						</tr>
					</table>
				</div><br>
				<div>
					<input type="submit" value="회원가입">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="초기화">
				</div>
			</form>
		</div>
	</div>
</body>
</html>