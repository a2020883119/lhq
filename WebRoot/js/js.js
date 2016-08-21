//全选
function checkAll(){
	var total = document.getElementsByName("nums");
	var a = document.getElementsByName("numss");
	if(a.item(0).checked == true){
		for(var i = 0; i < total.length; i++){
			total.item(i).checked = true;
		}
	}else{
		for(var i = 0; i < total.length; i++){
			total.item(i).checked = false;
		}
	}
}
//删除确认
function deleteCheck(){
	var flag = confirm("确定要删除?")
	return flag;
}
//更改信息 插入信息 是否为空检查	
function checkInput(){
	var name = document.getElementById("name").value
	var clas = document.getElementById("clas").value
	var addr = document.getElementById("addr").value
	var a = "";
	var flag = true;
	if(name == ""){
		a += "请输入name\n";
		flag = false;
	}
	if(name.length > 10){
		a += "name长度限制为10,你的输入为" + name.length + "\n";
		flag = false;
	}
	if(clas == ""){
		a += "请输入clas\n";
		flag = false;
	}
	if(clas.length > 20){
		a += "clas长度限制为20,你的输入为" + clas.length + "\n";
		flag = false;
	}
	if(addr == ""){
		a += "请输入addr";
		flag = false;
	}
	if(addr.length > 30){
		a += "addr长度限制为30,你的输入为" + addr.length + "\n";
		flag = false;
	}
	if(flag == false){
		alert(a);
		return false;
	}else{
		return confirm("确认提交以下信息吗\nname:" + name + "\nclass:" + clas + "\naddr" + addr);
	}
}
//登录字段为空检查
function checkLoginInput(){
	var password = document.getElementById("password").value
	var username = document.getElementById("username").value
	var a = "";
	var flag = true;
	if(username == ""){
		a += "请输入username\n";
		flag = false;
	}
	if(username.length > 20){
		a += "username长度限制为20,你的输入为" + username.length + "\n";
		flag = false;
	}
	if(password == ""){
		a += "请输入password\n";
		flag = false;
	}
	if(password.length > 20){
		a += "password长度限制为20,你的输入为" + password.length + "\n";
		flag = false;
	}
	if(flag == false){
		alert(a);
		return false;
	}
	return true;
}
//注册字段为空检查
function checkRegisInput(){
	var password1 = document.getElementById("password1").value
	var password2 = document.getElementById("password2").value
	var username =  document.getElementById("username").value
	var a = "";
	var flag = true;
	if(username == ""){
		a += "请输入username\n";
		flag = false;
	}
	if(username.length > 20){
		a += "username长度限制为20,你的输入为" + username.length + "\n";
		flag = false;
	}
	if(password1 == ""){
		a += "请输入password1\n";
		flag = false;
	}
	if(password1.length > 20){
		a += "password1长度限制为20,你的输入为" + password1.length + "\n";
		flag = false;
	}
	if(password2 == ""){
		a += "请输入password2\n";
		flag = false;
	}
	if(password2.length > 20){
		a += "password2长度限制为20,你的输入为" + password2.length + "\n";
		flag = false;
	}
	if(password1 != password2){
		a += "两次输入的密码不同\n";
		flag = false;
	}
	//alert(flag);
	if(flag == false){
		alert(a);
		return false;
	}
	return true;
}
//查询输入为空检查
function checkQueryInput(){
	//alert("");
	var id =   document.getElementById("id").value
	var name = document.getElementById("name").value
	var clas = document.getElementById("clas").value
	var addr = document.getElementById("addr").value
	var a = "";
	var flag = 0;
	if(id == ""){
		a += "id\n";
		flag++;
	}
	if(name == ""){
		a += "name\n";
		flag++;
	}
	if(clas == ""){
		a += "clas\n";
		flag++;
	}
	if(addr == ""){
		a += "addr\n";
		flag++;
	}
	if(flag == 4){
		alert(a+"至少输入一个字段");
		return false;
	}else{
		return true;
	}
}
function createRequest(url){
	var httpRequest =false;
	httpRequest = new XMLHttpRequest();
	httpRequest.onreadystatechange = getResult;
	httpRequest.open('GET', url, true);
	httpRequest.send(null);
	function getResult(){
		if(httpRequest.readyState == 4){
			if(httpRequest.status == 200){
				var text = httpRequest.responseText;
				if(text.length > 0){
					document.getElementById("usernameTip").innerHTML = "用户名存在";
				}else{
					document.getElementById("usernameTip").innerHTML = "";
				}
			}else{
				//document.getElementById("usernameTip").innerHTML = httpRequest.responseText;
				//alert("连接失败");
			}
		}
	}
}

function test(username){
	createRequest('usernameExist.action?username=' + username.value);
}