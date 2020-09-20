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
		var res = "${res}";
		
		if(res ==1){
			alert("메뉴 수정 성공했습니다.");
			location.href="dnuMenu?currentPage=${currentPage}";
		}else if(res ==2){
			alert("이미지 확장자가 올바르지 않습니다.");
			history.back();
		}else{
			alert("수정 실패했습니다.");
			history.back();
		}
		
	}

</script>


</html>