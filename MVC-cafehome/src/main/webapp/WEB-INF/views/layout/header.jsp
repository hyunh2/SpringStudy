<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	request.setCharacterEncoding("utf-8");
	String title = "공방 카페 봄";
	String getTitle = (String)request.getAttribute("getTitle");
	
	if(getTitle !=null && !getTitle.isEmpty()){
		title = getTitle;
	}
	
	pageContext.setAttribute("title", title);
	

%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${title}</title>
</head>
<style>
	*{
	margin:auto;
	padding:0;
	
	
	}
	#headerLine{
		height: 80px;
	}
	
	#menubar ul{
		background-color: pink;
		list-style: none;
		margin-left:45px;
		
	}
	
	#menubar li{
		float: left;
		padding:20px;
		width:13%;
		background-color: pink;
		text-align: center;
		
	}
	#menubar li:hover{
		background:skyblue;
	}
	

	
	#menuScreen{
		height: 500px;
		width:1280px;
		border: 1px solid black;
		margin-top:60px;
		
	}
	
	#homeMain{
		overflow: hidden;
		width:90%;
		align-content: center;
	}
	
	#notice{
		float:left;
		border:1px solid black;
		height: 300px;
		width:45%;
		text-align:center;
	}
	
	#newMenu{
		border: 1px solid black;
		height: 300px;
		width:45%;
		
		float:right;
	}
</style>

<body>
<div id="wrapper">
	<div id="headerLine">
	<a href="index">공방카페 봄</a> <p style="text-align:right"><a href="adminLoginPage">관리자</a></p>
	</div>
	
	<div id="menubar">
		<ul>
			<a href="index"><li>HOME</li></a>
			<a href="drinkpage?getTitle=음료"><li>음료</li></a>
			<a href="sandwitchpage?getTitle=샌드위치"><li>샌드위치</li></a>
			<a href="bakerypage?getTitle=디저트"><li>디저트</li></a>
			<a href="boardPage?getTitle=게시판"><li>게시판</li></a>
			<a href="locationPage?getTitle=찾아오시는 길"><li>찾아오시는 길</li></a>
		</ul>
	</div>
	