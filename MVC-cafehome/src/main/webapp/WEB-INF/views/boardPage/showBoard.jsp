<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <% request.setCharacterEncoding("utf-8");%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp">
	<jsp:param value="${getTitle }" name="getTitle"/>
</jsp:include>
<style>
 *{
        margin: 0;
        padding: 0;
        
    }
    table{
        margin: auto;
        width: 850px;
        
    }
    .boardshow{
    	margin-top:80px;
    }
    
    .board td:nth-of-type(1), .list td:nth-of-type(1){
        width: 100px;
        text-align: center;
    }
    
    
    .board, .list, tr,td{
        border-collapse: collapse;
    }
    
    td{
        padding:15px;
    }
    
    .btns button{
        text-align: center;
        margin: auto;
        padding:10px;
        border-radius: 10px;
        border: 2px solid black;
    }
    .btns button:hover{
        background-color: aliceblue;
        border: 2px solid pink;
    }
    
    .list a{
        text-decoration: none;
        color:black;
    }
    .list a:hover{
        text-decoration: underline;
        color:blueviolet;
        font-weight: bolder;
    }
    </style>
<body>
    
<body>
    
    <div class="boardshow">
       <table border="1" class="board">
            <tr>
               <td>분류</td>
               <td>${bdDto.bdCategory}</td>
           </tr>         
           <tr>
               <td>제목</td>
               <td>${bdDto.bdTitle}</td>
           </tr>
           <tr>
               <td>등록일</td>
               <td>${bdDto.bdDate}</td>
           </tr>
           <tr>
               <td>내용</td>
               <td>
               <c:choose>
               <c:when test="${bdDto.bdImg eq null }">
	               <br>
               </c:when>
               <c:otherwise>
	               <p><img alt="이미지" src="${pageContext.request.contextPath }/resources/upload/${bdDto.bdImg}"  style="width:750px;"/></p>
	               <br>
               </c:otherwise>
               </c:choose>
               <pre style="font-weight: bolder; ">${bdDto.bdComment}</pre><br></td>
           </tr>
           <tr>
               <td colspan="2" class="btns">
                   <button onclick="location.href='boardPage'">목록</button>
                   <button onclick="history.back()"> 뒤로가기 </button>
               </td>
           </tr>
       </table>
        <table border="1" class="list">
        <c:choose>
        <c:when test="${res eq  1 }">
        </c:when>
        <c:when test="${forwardboard eq null }">
            <tr>
                <td>▲다음글</td>
                <td><a href="viewBoard?bdIdx=${nextboard.bdIdx}">${nextboard.bdTitle}</a></td>
            </tr>
        </c:when>
        <c:when test="${nextboard eq null }">
            <tr>
                <td>▼이전글</td>
                <td><a href="viewBoard?bdIdx=${forwardboard.bdIdx}">${forwardboard.bdTitle}</a></td>
            </tr>
        </c:when>
        <c:otherwise>
            <tr>
                <td>▲다음글</td>
                <td><a href="viewBoard?bdIdx=${nextboard.bdIdx}">${nextboard.bdTitle}</a></td>
            </tr>
            <tr>
                <td>▼이전글</td>
                <td><a href="viewBoard?bdIdx=${forwardboard.bdIdx}">${forwardboard.bdTitle}</a></td>
            </tr>
        </c:otherwise>
        </c:choose>
        </table>
        
    </div>
    
    
<%@ include file="/WEB-INF/views/layout/footer.jsp" %>