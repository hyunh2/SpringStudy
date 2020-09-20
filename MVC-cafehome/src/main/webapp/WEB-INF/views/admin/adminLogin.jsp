<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 로그인 페이지</title>
</head>
<style>
	*{
		margin:auto;
		padding:0;
	}
	
    .login{
        margin-top: 50px;
        border: 1px solid gray;
        width: 500px;
        border-radius: 10px;
        padding:30px 0px 30px 0px;
    }
	table{
	
		width:100%;
		margin:10px;
       
	}	
	
	td:nth-of-type(1){
		text-align: right;
        font-size: 25px;
        padding:10px;
       
        
	}
	td:nth-of-type(2){
		width:350px;
        padding:10px;
        
	}
	
	.lgbtn{
        width:250px;
		padding:15px;
        font-size: 18px;
	}
    .lgbtn:hover{
        border-style: none;
        background: brown;
        color:white;
	}
    input{
        width:200px;
        height: 55px;
        border-radius: 8px;
        font-size: 22px;
    }
</style>

<script>
window.onload=function(){
	


	var res = "${res}";

	
	
if(res != ""){
	if (res == "1") {
			alert("관리자님 환영합니다.");
			location.href = "adminPage";

		} else if(res == "0"){
			alert("아이디 혹은 비밀번호가 맞지 않습니다.");
			return;
		}else{
			alert("알 수 없는 오류 발생");
			return;
		}
	
}else{
	return;
}

	}


	function login_check(f){
		
		var aId = f.aId.value;
		var aPw = f.aPw.value;
		if(aId == "" || aPw == ""){
			alert("아이디 또는 비밀번호 입력해주세요.");
			return;
		}else{
			f.action="adminLogin?aId="+aId+"&aPw="+aPw;
			f.submit();
		}
	}

	
	
	
</script>
<body>
		<div class="loginBox">
			<h1>관리자 로그인 페이지</h1>
			<a href="index">메인으로 돌아가기</a>
			<br><br>
			<div class="login">
			<form method="post" >
				<table >
					<tr>
						<td>ID</td>
						<td>&nbsp;&nbsp;&nbsp;<input type="text" name="aId" id="aId"></td>
					</tr>
					<tr>
						<td>PW</td>
						<td>&nbsp;&nbsp;&nbsp;<input type="password" name="aPw" id="aPw"></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align:center;"><input type="button" value="로그인" class="lgbtn" onclick="login_check(this.form)" ></td>
					</tr>
				</table>
			</form>
			</div>
		</div>
</body>
</html>