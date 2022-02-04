<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title" /> </title>
</head>
<body>
	<div align="center">
		<table border='1'>
			<tr>
				<td><tiles:insertAttribute name="header" /></td>
			</tr>
			<tr height="500">
				<td><tiles:insertAttribute name="body" /></td>
			</tr>
			<tr>
				<td><tiles:insertAttribute name="footer" /></td>
			</tr>
		</table>
	</div>
	
</body>
</html>