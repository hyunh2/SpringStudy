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
	<button style="margin-left:auto" onclick="history.back()">돌아가기</button>

	<table>
		<tr>
			<td>ID</td>
			<td>제목</td>
			<td>등록날짜</td>
		</tr>
		<c:choose>
		<c:when test="${memdto ne null }">
			<c:forEach var="dto" items="${memdto }">
			<tr>
				<td>${dto.id }</td>
				<td>${dto.board.title}</td>
				<td>${dto.board.regdate}</td>
			</tr>
			</c:forEach>
		</c:when>
		<c:otherwise >
		<tr>
			<td colspan="3">게시글 없습니다</td>
			</tr>
		</c:otherwise>
		</c:choose>
	</table>
	
</body>

</html>