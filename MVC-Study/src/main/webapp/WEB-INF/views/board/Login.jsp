<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form>
		<table>
			<tr>
				<td>ID</td>
				<td><input tpye="text" name="id" id="id"></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="password" name="pw" id="pw"></td>
			</tr>
			<button onclick="login(this.form)">로그인</button>
		</table>
	</form>
	<script type="text/javascript">
		function login(f){
			var id = document.getElementById(f.id).value();
			var pw = document.getElementById(f.pw).value();
			
			if(id == null){
				alert("아이디 입력 해주세요.");
				id.focus();
				return;
			}else if(pw == null){
				alert("비밀번호 입력해주세요");
				pw.focus();
				return;
			}else{
				location.href="login";
			}
		}
	</script>
</body>
</html>