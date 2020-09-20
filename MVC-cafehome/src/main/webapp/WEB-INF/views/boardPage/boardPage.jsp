<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <% request.setCharacterEncoding("utf-8");%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp">
	<jsp:param value="${getTitle }" name="getTitle"/>
</jsp:include>

<style>
	*{
		margin:0;
		padding:0;
		margin:auto;
	}
	
	.boardShow{
		text-align:center;
		padding: 50px;
	}
	.boardShow table{
		border-collapse: collapse;
		width:1000px;
		
	}
	.boardShow td{
		padding:6px;
	}
	.boardShow td:nth-of-type(1) {
		width:100px;
	}
	.boardShow td:nth-of-type(2) {
		width:200px;
	}
	.boardShow td:nth-of-type(3) {
		width:500px;
	}
	.boardShow td:nth-of-type(4) {
		width:200px;
	}
</style>


<div class="boardShow">
	<br><br>
	<h1>게시판</h1>
	<br><br>
	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>분류</td>
				<td>제목</td>
				<td>날짜</td>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${res eq 0 }">
					<tr>
						<td colspan="4">등록된 게시글이 없습니다.</td>
					</tr>
				</c:when>
				
				<c:otherwise>
					<c:forEach var="bd" items="${bdDto }">
						<tr>
							<td>${bd.bdIdx }</td>
							<td>${bd.bdCategory }</td>
							<td><a href="viewBoard?bdIdx=${bd.bdIdx}&currentPage=${currentPage}">${bd.bdTitle }</a></td>
							<td>${bd.bdDate }</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4">${paging }</td>
			</tr>
		</tfoot>
	</table>
</div>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>