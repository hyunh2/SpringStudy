<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
	function remove(idk){
		var idk = idk;
		if(confirm("삭제 하시겠습니까?")){
			$.ajax({
				url:"remove",
				type:"post",
				data:{"idk":idk},
				success:function(result){
						alert("삭제됐습니다.");
						location.href="boardlist";
				}
			})
		}else{
			return;
		}
	}
	
	function update(idk){
		var idk = idk;
		location.href="update?idk="+idk;
	}
</script>
<body>
	<table>
		<tr>
			<td>순서</td>
			<td>${bd.idk }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${bd.id }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${bd.title }</td>
		</tr>
		
		<tr>
			<td>작성날짜</td>
			<td>${bd.regdate}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${bd.comment}</td>
		</tr>
			
	</table>
	<button onclick="update(${bd.idk})"> 수정</button>
	<button onclick="remove(${bd.idk})">삭제</button>
	

</body>
</html>