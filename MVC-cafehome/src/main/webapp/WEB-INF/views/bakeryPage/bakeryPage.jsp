<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<jsp:include page="/WEB-INF/views/layout/header.jsp">
	<jsp:param value="${getTitle }" name="getTitle"/>
</jsp:include>
	
	<%
		request.setCharacterEncoding("utf-8");
			
		
	
	%>
	
	<script>
	
		
		
	
	</script>
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

img {
	width: 190px;
	height: 250px;
}

ul {
	list-style: none;
}

.main_drink ul {
	overflow: hidden;
}

.mainlist {
	float: left;
	display: inline-block;
	position: relative;
	z-indent: 0;
	text-align: center;
	margin-top: 30px;
	margin: 15px;
}

/* #bakery_show{
			width:100px;
			height: 150px;
			display:inline-block;
			position:relative;
			z-index: 0;
			border:1px solid black;
		
		} */
#bakery_ex {
	width: 190px;
	height: 250px;
	position: absolute;
	background-color: rgb(204, 204, 204, 0.6);
	text-align: center;
	opacity: 0;
	z-index: 999;
	transition: all 1s;
	-webkit-transition: all 1s;
	-ms-transition: all 1s;
	-o-transition: all 1s;
}

.mainlist:hover #bakery_ex {
	transform: translate(0px, -293px);
	-webkit-transform: translate(0px, -293px);
	-ms-transform: translate(0px, -293px);
	-o-transform: translate(0px, -293px);
	opacity: 1;
}
</style>
	<div id="box">
	<div class="main_drink">
	
	<!-- 음료, 샌드위치, 베이커리 메뉴 바 -->
<jsp:include page="/WEB-INF/views/layout/menu_header.jsp">
	<jsp:param value="${getTitle }" name="getTitle"/>
</jsp:include>	
	

		<h1>베이커리 / 디저트</h1>
		<c:choose>
		<c:when test="${res ne 0 }">
				<ul>
				<c:forEach var = "b" items="${bDto }">
					<li class="mainlist">
							<c:choose>
							<c:when test="${b.bImg eq null }">
								<img src="resources/img/index.jpg" alt="이미지">
							</c:when>
							<c:otherwise>
								<img src="${pageContext.request.contextPath }/resources/upload/${b.bImg }">
							</c:otherwise>
							</c:choose>
							<p>${b.bName }</p>
							<p>${b.bPrice }</p>
						<div id="bakery_ex">
							<br>
							<pre style="white-space: pre-wrap; font-weight: bolder;">${b.bComment }</pre>
						</div>
					</li>
				</c:forEach>
				</ul>
		</c:when>
		
		<c:otherwise>
			<h2>아직 등록된 베이커리 /디저트가 없습니다.</h2>
		</c:otherwise>
		
		</c:choose>
	</div>
	

		</div>	
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>
						