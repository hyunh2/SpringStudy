<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	
	function add(){
		location.href="add";
	}
	
	function list(){
		location.href="listJoin"
	}
</script>
<body>
	<button style="margin-left:auto" onclick="add()">추가</button>
	<button style="margin-left:auto" onclick="list()">목록</button>
	<table>
		<tr>
			<td>순서</td>
			<td>제목</td>
			<td>날짜</td>
		</tr>
		<c:choose>
		<c:when test="${bdDto ne null }">
			<c:forEach var="bd" items="${bdDto }">
			<tr>
				<td>${bd.idk }</td>
				<td><a href="show?idk=${bd.idk}">${bd.title }</a></td>
				<td>${bd.regdate }</td>
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