<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% request.setCharacterEncoding("utf-8");%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/adminheader.jsp"/>

<style>
    
    .mainShow table{
        margin-top: 30px;
        text-align: center;
        width:500px;
        border-collapse: collapse;
    }
     .mainShow tr,td{
        padding:5px;
    }
    
      .AllMenuShow{
       	width:518px;
    	height:150px;
    	overflow-y: auto;
    }
    
   
 	
  .board td:nth-of-type(1){
        width:100px;
    }
    .board td:nth-of-type(2){
        width:260px;
    }
    .board td:nth-of-type(3){
        width:140px;
    }
    
    .menu td:nth-of-type(1){
        width:200px;
    }
    .menu td:nth-of-type(2){
        width:300px;
    }
    
    
</style>


            <h2>게시글 총 ${boardRes}개</h2>
            <table border="1" class="board">
                    <tr>
                       <td>카테고리</td>
                        <td>제목</td>
                        <td>날짜</td>
                    </tr>
             </table>
             <div class="AllMenuShow">
             <table border="1" class="board" style="margin:0;">
                <c:choose>
                <c:when test="${boardRes ne 0 }">
                	<c:forEach var="b" items="${bDto }">
                	<tr>
	                    <td>${b.bdCategory}</td>
	                    <td>${b.bdTitle}</td>
	                    <td>${b.bdDate}</td>
	                </tr>
                	</c:forEach>
                </c:when>
                <c:otherwise>
                	<td colspan="3">등록된 게시글이 없습니다.</td>
                </c:otherwise>
                </c:choose>
            </table>
            </div>
            <br><br><br><br>
            <h2>메뉴 총 ${menuRes}개</h2>
	            <table border="1" class="menu">
	                    <tr>
	                       <td>카테고리</td>
	                        <td>이름</td>
	                    </tr>
	             </table> 
            <div class="AllMenuShow">
            	<table border="1" class="menu" style="margin:0;">
	                <c:choose>
	                <c:when test="${menuRes ne 0 }">
	                	<c:forEach var="am" items="${amDto }">
		                	<tr>
		                    	<td>${am.amCategory}</td>
		                    	<td>${am.amName}</td>
		                    </tr>
	                	</c:forEach>
	                </c:when>
	                <c:otherwise>
	                	<td colspan="2">등록된 메뉴가 없습니다.</td>
	                </c:otherwise>
	                </c:choose>
	            </table>
            </div>
            <br><br><br><br>
        </div>
        
    </div>
    
    
</div>
</body>
</html>