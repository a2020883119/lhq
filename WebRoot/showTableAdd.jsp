<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/js.js"></script>
<title>insert</title>
</head>

<body>
<center><h1>添加页面</h1></center><hr/>
<a href="showTable.action">showtable</a>
	<center>
		<form action="insert.action" method="post" onsubmit="return checkInput()">
             NAME:&nbsp;<input type="text" name="student.name" id="name"/>&nbsp;
             CLASS:&nbsp;<input type="text" name="student.clas" id="clas"/>&nbsp;
             ADDR:&nbsp;<input type="text" name="student.addr" id="addr"/><br />&nbsp;&nbsp;&nbsp; &nbsp;<br/>
            <input type="submit" value="submit" />&nbsp;&nbsp;<input type="reset" value="RESET"/><br />
	    </form>
	</center>
</body>
</html>