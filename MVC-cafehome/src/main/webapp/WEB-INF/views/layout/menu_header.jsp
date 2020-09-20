<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	request.setCharacterEncoding("utf-8");
	String title="";
	String getTitle = (String)request.getAttribute("getTitle");
	
	if(getTitle !=null && !getTitle.isEmpty()){
		title = getTitle;
	}
	
	pageContext.setAttribute("title", title);

%>

<c:choose>
	<c:when test="${getTitle eq '음료' || getTitle eq '커피' ||getTitle eq '논커피' ||getTitle eq '에이드' ||getTitle eq '차' ||getTitle eq '블랜디드'  }">
		<div class="menu_menubar">
		<ul>
			<a href="drink_move?category=커피"><li>커피</li></a>
			<a href="drink_move?category=논커피"><li>논커피</li></a>
			<a href="drink_move?category=에이드"><li>에이드</li></a>
			<a href="drink_move?category=차"><li>차</li></a>
			<a href="drink_move?category=블랜디드"><li>블랜디드</li></a>
		</ul>
	</div>
	</c:when>
	<c:when test="${getTitle eq '샌드위치'}">
		<div class="menu_menubar">
		<ul>
			<a href="sandwitchpage?getTitle=${getTitle }"><li>샌드위치</li></a>
		</ul>
	</div>
	</c:when>
	<c:when test="${getTitle eq '디저트'}">
		<div class="menu_menubar">
		<ul>
			<a href="bakerypage?getTitle=${getTitle }"><li>베이커리/디저트</li></a>
		</ul>
	</div>
	</c:when>
	
</c:choose>
	