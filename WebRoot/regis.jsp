<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/js.js"></script>
<title>Regis</title>
</head>
<body>
<center><h1>注册页面</h1></center><hr/>
<a href="login.jsp">login</a>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br> 
	<center>                                                    
		<form action="regis.action" method="post" onsubmit="return checkRegisInput()"  name="form">
		<span  id="usernameTip" name="usernameTip" style="background-color: red;" ></span><br>
			username&nbsp;: <input type="text" name="regisUser.username" id="username"  onkeyup="test(this)" onchange="test(this)"/><br>
			password1: <input type="password" name="regisUser.password1" id="password1"/><br>
			password2: <input type="password" name="regisUser.password2" id="password2"/><br>
			<input type="submit" value="submit"/> 
			<input type="reset" value="reset"/>
		</form>
	</center>
</body>
</html>