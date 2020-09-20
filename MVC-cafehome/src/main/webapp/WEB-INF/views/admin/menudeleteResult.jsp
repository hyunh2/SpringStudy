<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script>
	window.onload=function(){
		var deleteRes = "${deleteRes}";
		
		if(deleteRes ==1){
			alert("메뉴가 삭제되었습니다.");
			location.href="dnuMenu?currentPage=${currentPage}";
		}else{
			alert("메뉴 삭제 중 오류가 발생했습니다.");
			history.back();
		}
		
	}

</script>


</html>