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
			<h1>로  그  인</h1>
		</div>
		<div>
			<form id="frm" action="memberLogin.do" method="post">
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
					</table>
				</div><br>
				<div>
					<input type="submit" value="로그인">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소">
				</div>
			</form>
		</div>
	</div>
</body>
</html>