<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/js.js"></script>
<title>change</title>
</head>
<%
%>
<body>

<center><h1>修改信息</h1></center><hr/>
<a href="showTable.action">showtable</a>
	<center>
		<form action="changeOk.action" method="post" onsubmit="return checkInput()">
			 ID:<input type="text" readonly="readonly" id = "id" name = "student.id" value="<s:property value="stu.id"/>"/>&nbsp;
             NAME:&nbsp;<input type="text" name="student.name" id = "name" value="<s:property value="stu.name"/>"/>
             CLASS:&nbsp;<input type="text" name="student.clas" id = "clas" value="<s:property value="stu.clas"/>"/>
             ADDR:&nbsp;<input type="text" name="student.addr" id = "addr" value="<s:property value="stu.addr"/>"/>&nbsp;<br /><br/>
            &nbsp;&nbsp;&nbsp; &nbsp;<input type="submit" value="submit"/>&nbsp;&nbsp;<input type="reset" value="RESET"/><br />
	    </form>
	</center>
</body>
</html>