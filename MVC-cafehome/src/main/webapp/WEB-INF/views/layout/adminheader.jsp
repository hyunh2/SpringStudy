<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>관리자 페이지</title>
</head>
<style>
	*{
       margin: 0;
       padding: 0;
       
    }    
    
    .topbar{
        height: 100px;
    }
    
    .mainScreen{
        
        overflow: hidden;
    }
    .header{
        float: left;
        height: 100%;
        width: 250px;
        text-align: center;
        
    }
    
    ul{
        list-style: none;
        background-color: azure;
        
    }
    li, a{
        text-decoration: none;
        padding:15px;
    }
    
    li:hover{
        background-color: coral;
        color: white;
    }
    
    
    .mainShow{
        float:left;
        padding-left: 220px;
       
    }
</style>


<%
	String aId = (String)session.getAttribute("aId");
	pageContext.setAttribute("aId", aId);

%>
<script type="text/javascript">

function logout(){
	if(confirm("로그아웃 하시겠습니까?") == true){
		location.href="adminLogout";
	}else{
		return;
	}
}

</script>
<body>
<div class="wapper">
    <div class="topbar">
        
    </div>
    <div class="mainScreen">
        <div class="header">
          
               <img alt="아이콘">&nbsp;${aId }님
               <br><br>
           
            <ul>
                <a href="adminPage"><li>홈</li></a>
                <a href="addMenu"><li>메뉴 추가</li></a>
                <a href="dnuMenu"><li>메뉴 삭제/수정</li></a>
                <a href="writeBoard"><li>게시글 작성</li></a>
                <a href="dnuBoard"><li>게시글 삭제/수정</li></a>
                <a href="javascript:logout()"><li>로그아웃</li></a>
            </ul>
        </div>
        <div class="mainShow">