<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp"></jsp:include>


	<div id="menuScreen">
	</div>
	<br><br>
	<div id="homeMain">
		<div id="notice">
		<h3>공지사항</h3>
			<table>
				<c:if test="${res ne 0 }">
					<c:forEach var="bd" items="${bdDto }">
						<tr>
							<td><a href="readBoard?bdIdx=${bd.bdIdx}">${bd.bdTitle}</a></td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test = "${res eq 0 }">
					<h5>등록된 공지사항이 없습니다.</h5>
				</c:if>
					
			
			</table>
		</div>
		<div id="newMenu">
		</div>
		
	</div>
	
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>