<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
window.onload=function(){
	var imgFlag = "${imgFlag}";
	
	if(imgFlag == 1){
		alert("메뉴 추가가 되었습니다.");
		location.href="addMenu";
	}else{
		alert("메뉴 추가가 되지 않았습니다.");
		history.back();
	}
}

</script>
</html>