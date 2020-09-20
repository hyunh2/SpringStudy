<%@page import="com.hyun.cafe.dto.DrinkDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/layout/header.jsp">
	<jsp:param value="${getTitle }" name="getTitle" />
</jsp:include>

<%
	request.setCharacterEncoding("utf-8");
	
	
%>


<style>
#box {
	margin-top: 61px;
	width: 1234px;
	overflow: hidden;
}

.menu_menubar {
	margin-left: 0px;
	width: 20%;
	height: 100%;
	float: left;
}

.menu_menubar ul {
	list-style: none;
}

.menu_menubar a {
	text-decoration: none;
}

.menu_menubar li {
	padding: 22px;
}

.main_drink {
	width: 76%;
	height: 100%;
	padding: 15px;
	float: left;
}

ul{
	list-style: none;
}
	.main_drink ul{
		overflow: hidden; 
	}
.mainlist {
	float:left;
	display:inline-block;
	position:relative;
	z-indent:0;
	text-align:center;
	margin-top:30px;
	margin: 15px;
}
/*  #drink_show {
 	text-align:center;
	width: 180px;
	height: 250px;
	
	margin-top:30px;
} */

	 img {
	width: 120px;
	height: 180px;
	
}

 #drink_ex {
	width: 120px;
	height: 180px;
	background-color: rgb(80, 80, 80, 0.5);
	text-align: center;
	opacity:0;
	z-index: 999;
	transition: all 1s;
	-webkit-transition: all 1s;
	-ms-transition: all 1s;
	-o-transition: all 1s;
	
}	



	.mainlist:hover #drink_ex{
	transform: translate(0px, -223px);
	-webkit-transform: translate(0px, -223px);
	-ms-transform: translate(0px, -223px);
	-o-transform: translate(0px, -223px);
	opacity: 1;
}
</style>
<div id="box">
	<div class="main_drink">

		<!-- 음료, 샌드위치, 베이커리 메뉴 바  -->
		<jsp:include page="/WEB-INF/views/layout/menu_header.jsp">
			<jsp:param value="${getTitle }" name="getTitle" />
		</jsp:include>
		
		<c:choose>
			<c:when test="${res ne 0 }">
			<c:if test="${getTitle eq '음료' }">
				<h1>전체</h1>
				<ul>
					<c:forEach var="d" items="${dDto }">
						<li class="mainlist">
						<!-- <div id="drink_show"> -->
							<c:choose>
							<c:when test="${d.dImg eq null }">
								<img src="resources/img/index.jpg" alt="이미지">
							</c:when>
							<c:otherwise>
								<img src="${pageContext.request.contextPath }/resources/upload/${d.dImg }"alt="이미지">
							</c:otherwise>
							</c:choose>
						<p>
						<c:if test="${d.isNew eq 'yes' }">NEW</c:if>
						<c:if test="${d.isNew eq 'no'}"></c:if>
						${d.dName }</p>
						<p style="text-align:center;">${d.dPrice }원</p>
					<!-- </div> -->
					<div id="drink_ex">
						<p>${d.dHotnIce }</p>
						<pre>${d.dComment }</pre>
					</div>
					</li>
					</c:forEach>
				</ul>
			</c:if>
			<c:if test="${getTitle ne '음료'}">
				<h1>${category}</h1>
				<ul>
					<c:forEach var="d" items="${dDto }">
						<li class="mainlist">
						<!-- <div id="drink_show"> -->
							<c:choose>
							<c:when test="${d.dImg eq null }">
								<img src="resources/img/index.jpg"alt="이미지">
							</c:when>
							<c:otherwise>
								<img src="${pageContext.request.contextPath }/resources/upload/${d.dImg }"alt="이미지">
							</c:otherwise>
							</c:choose>
							<p>
								<c:if test="${d.isNew eq 'yes' }">NEW</c:if>
								<c:if test="${d.isNew eq 'no'}"></c:if>
							${d.dName }</p>
							<p style="text-align:center;">${d.dPrice }원</p>
						<!-- </div> -->
						<div id="drink_ex">
							<p>${d.dHotnIce}</p>
							<pre>${d.dComment }</pre>
						</div>
						</li>
					</c:forEach>
					</ul>
				</c:if>
			</c:when>
			<c:otherwise>
				<c:if test="${getTitle eq '음료' }">
					<h1>전체</h1>
				</c:if>
				<c:if test="${getTitle ne '음료' }">
					<h1>${getTitle}</h1>
				</c:if>
				<h2>아직 등록된 음료가 없습니다.</h2>
			</c:otherwise>

		</c:choose>
	</div>


</div>
<%@ include file="/WEB-INF/views/layout/footer.jsp"%>
