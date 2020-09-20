<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="/WEB-INF/views/layout/adminheader.jsp"/>


<style>
    *{
        margin: 0;
        padding:0;
    }
    
    form select{
        padding:3px;
    }
    form input{
        padding:3px;
    }
    form button{
        height: 27px;
        width: 50px;
        border-radius: 5px;
        border:none;
        background-color: darkgray;
    }
    form button:hover{
        background-color: darkviolet;
        color: white;
    }
    
    table{
        border-collapse: collapse;
        width: 500px;
    }
    thead, td:nth-of-type(3), td:nth-of-type(4), tfoot{
        text-align: center;
    }
    td:nth-of-type(1){
       width:  80px;
    }
    tbody tr{
        height: 32px;
    }
</style>
<script>


	function goSearch(f){
		var content = f.content.value;
		
		if(content == ""){
			alert("메뉴 이름 혹은 카테고리를 입력해주세요");
			return;
		}else if(content != ""){
			f.action = "searchMenu";
			f.submit();
		}
	}
	
	function deleteCheck(name, category, currentPage){
		if(confirm("메뉴를 삭제 하시겠습니까?") == true){
			location.href="deleteMenu?name="+name+"&category="+category+"&currentPage="+currentPage;
			
		}else{
			return;
			
		}
	}
</script>
	
<body>
    	<br>
    <h2>메뉴 수정 / 삭제</h2>
	    <br>
	    <br>
    <form method="get">
	    <select name="search">
	        <option value="amCategory">카테고리</option>
	        <option value="amName">이름</option>
	    </select>
	        <input type="text" id="content" name="content" >
	        <button onclick="goSearch(this.form)">검색</button>    
    </form>
    <%-- 등록된 메뉴 없음 --%> 
   	 <br>
   	 <c:if test="${res eq 0 }">
   	 	<table border="1">
        <thead>
            <tr>
                <td>카테고리</td>
                <td>이름</td>
                <td>수정</td>
                <td>삭제</td>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td colspan="4" style="text-align: center;">수정/삭제 가능한 메뉴가 없습니다.</td>
            </tr>
        </tbody>
        <tfoot>
            <td colspan="4">${paging}</td>
        </tfoot>
    </table>
   	 </c:if>
   	 <%--등록 메뉴 있음--%> 
   	 <c:if test="${res ne 0 }">
   	<%--검색결과 없음 --%> 
   	<c:choose>
   	<c:when test="${ IsSearch eq 1 && sh_res eq 0}">
   		<table border="1">
        <thead>
            <tr>
                <td>카테고리</td>
                <td>이름</td>
                <td>수정</td>
                <td>삭제</td>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td colspan="4" style="text-align: center;">검색하신 결과가 없습니다.</td>
            </tr>
        </tbody>
        <tfoot>
            <td colspan="4">${paging}</td>
        </tfoot>
    </table>
   	</c:when>
   	
   	<%--검색결과 있음 --%> 
    <c:when test="${ IsSearch eq 1  && sh_res ne 0}">
    <table border="1">
        <thead>
            <tr>
                <td>카테고리</td>
                <td>이름</td>
                <td>수정</td>
                <td>삭제</td>
            </tr>
        </thead>
        <tbody>
         <c:forEach var="am" items="${amDto }">
            <tr>
                <td>${am.amCategory}</td>
                <td>${am.amName}</td>
                <td><a href="menuUpdate?name=${am.amName}&category=${am.amCategory}&currentPage=${currentPage}&amIdx=${am.amIdx}"><img alt="수정"></a></td>
                <td><a href="javascript:deleteCheck('${am.amName }','${am.amCategory }','${currentPage}')"><img alt="삭제"></a></td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
            <td colspan="4">${paging}</td>
        </tfoot>
    </table>
   	</c:when>

<%--기본 페이지 --%>    	
    <c:otherwise>
     <table border="1">
        <thead>
            <tr>
                <td>카테고리</td>
                <td>이름</td>
                <td>수정</td>
                <td>삭제</td>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="am" items="${amDto }">
            <tr>
                <td>${am.amCategory}</td>
                <td>${am.amName}</td>
                <td><a href="menuUpdate?name=${am.amName}&category=${am.amCategory}&currentPage=${currentPage}&amIdx=${am.amIdx}"><img alt="수정"></a></td>
                <td><a href="javascript:deleteCheck('${am.amName }','${am.amCategory }','${currentPage}')"><img alt="삭제"></a></td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
            <td colspan="4">${paging}</td>
        </tfoot>
    </table>
    </c:otherwise>
   	</c:choose>
   	 </c:if>


    
             
       
         
         
         
         
         
         
         

</body>
</html>