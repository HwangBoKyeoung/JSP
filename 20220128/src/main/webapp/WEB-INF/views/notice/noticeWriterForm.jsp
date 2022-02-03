<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
</head>
<body>
	<div align="center">
		<jsp:include page="../main/header.jsp" />
		<div>
			<h2>글  작  성</h2>
		</div>
		<div>
			<form id="frm" action="noticeWriter.do" method="post">
				<div>
					<table border='1'>
						<tr>
							<th width="100">작성자</th>
							<td width="150">
								<input type="text" value="${name}" name="writer" id="writer" readonly>
							</td>
							<th width="100">작성일자</th>
							<td width="150">
								<input type="date" name="date" id="date">
							</td>
						</tr>
						<tr>
							<th>제목</th>
							<td colspan="3">
								<input type="text" size="59" id="title" name="title">
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td colspan="3">
								<textarea cols="70" rows="10" name="subject" id="subject"></textarea>
							</td>
						</tr>
					</table>
				</div><br>
				<div>
					<input type="submit" value="등록">&nbsp;&nbsp;
					<input type="reset" value="취소">
					<input type="button" value="목록" onclick="location.href='noticeList.do'">
				</div>
			</form>
		</div>
	</div>
	
	<script>
		document.getElementById('date').value = new Date().toISOString().substring(0, 10);
	</script>
</body>
</html>