<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- EL -->
<html>
<head>
<script type="text/javascript" src="js/js.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>http://localhost:8080/web/showTable.jsp</title>
</head>
<body>
<center><h1>主页面</h1></center><hr/>
	<center>
		当前用户:${sessionScope.username}&nbsp;&nbsp;&nbsp;
		<a href="loginOut.action">登出</a>
		<br><br><br><br>
        <div>
       	  <form action="query.action" method="post" onsubmit="return checkQueryInput()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                ID:&nbsp;<input type="text" name="id" id="id" />&nbsp;&nbsp;&nbsp;
                NAME:&nbsp;<input type="text" name="name" id="name"/>&nbsp;&nbsp;
                CLASS:&nbsp;<input type="text" name="clas" id="clas"/>&nbsp;&nbsp;&nbsp;
                ADDR:&nbsp;<input type="text" name="addr" id="addr"/><br /><br>
               <input type="submit" value="SERACH / SEEALL"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               <input type="reset" value="RESET"/><br />
          </form>
        </div>
        <br><br><br><br>
        <div>
        	<table style="width:800px;  text-align:left">
            	<tr>
            		<td><span><a href="showTableAdd.jsp">添加信息</a></span></td>
            		<td style="text-align:right">
            			<a href="insertOne.action">InsertOne</a>&nbsp;&nbsp;
            			<a href="showTable.action">Refresh</a>&nbsp;&nbsp;
            		</td>
            	</tr>
            </table>   	
        </div>
		<div>
			<form action="deletes.action" method="post">
				<table border="1" cellspacing="0"
					style="width: 800px; text-align: center">
					<tr>
						<th scope="col" style="width: 10px;  font-style: normal;"><input type="checkbox" name="numss" onclick="checkAll();"/></th>
						<th scope="col" style="width: 100px;">序号</th>
						<th scope="col" style="width: 150px;">姓名</th>
						<th scope="col" style="width: 150px;">班级</th>
						<th scope="col" style="width: 300px;">地址</th>
						<th scope="col" style="width: 100px;">操作</th>
					</tr>
					<c:forEach items="${sessionScope.stuList}" var="stu">
						<tr>
							<td><input type="checkbox" name="nums" value="${stu.id}" />
							</td>
							<td>${stu.id}</td>
							<td>${stu.name}</td>
							<td>${stu.clas}</td>
							<td>${stu.addr}</td>
							<td><a href="delete.action?id=${stu.id}" onclick="return deleteCheck();" >删除</a>&nbsp; 
							<a href="change.action?id=${stu.id}">修改</a>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td><b>选中</b></td>
						<td><b>序号</b></td>
						<td><b>姓名</b></td>
						<td><b>班级</b></td>
						<td><b>地址</b></td>
						<td><b>操作</b></td>
					</tr>
					<tr>
						<td colspan="1"><span><input type="submit" value="批量删除" onclick=" return deleteCheck();"/></span></td>
						<td colspan="2">数据总数：<%=session.getAttribute("total")%></td>
						<td colspan="3">
						<a href="showTable.action">首页</a>&nbsp;-&nbsp;
							<a href="page.action?n=1&p=${sessionScope.page }">上页</a>&nbsp;-&nbsp;
							${sessionScope.page }/${sessionScope.last }&nbsp;-&nbsp; 
							<a href="page.action?n=2&p=${sessionScope.page }">下页</a>&nbsp;-&nbsp;
							<a href="page.action?n=3&p=${sessionScope.last }">末页</a>&nbsp;&nbsp;
						</td>
					</tr>
				</table>
			</form>
		</div>
		<br><br><br><br>
	</center>
</body>
</html>