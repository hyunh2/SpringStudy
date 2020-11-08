<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
 
<body>
<form action="boardadd">
	<table>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" id="title"></td>
		</tr>
		
		
		<tr>
			<td>내용</td>
			<td><textarea cols="20" rows="10" name="comment" id="comment"></textarea></td>
		</tr>
			
	</table>
	<input type="hidden" name="id" value="maru">
	<button type="submit">저장</button>
	<input type="button" onclick="history.back()" value="돌아가기"></button>
</form>
	

</body>
</html>