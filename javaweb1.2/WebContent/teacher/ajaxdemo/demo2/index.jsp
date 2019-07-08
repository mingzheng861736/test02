<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<c:set var="basePath"
	value="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${path }/"></c:set>
<!DOCTYPE html>
<html>
<head>
<base href="${basePath }">
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//创建XMLHttpRequestc对象
	var xmlHttp = false;
	function createXMLHttpRequest() {
		if (window.ActiveXObject) {//IE浏览器
			try {
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
				}
			}
		} else if (window.XMLHttpRequest) {//其他浏览器：如mozilla 的 fireFox 或者 netscape 7
			xmlHttp = new XMLHttpRequest();
			if (xmlHttp.overrideMimeType) {
				xmlHttp.overrideMimeType("text/html");
			}
		}
	}

	function processResponse() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				var info = xmlHttp.responseText;
				if (info == "fail") {
					document.getElementById("demo").innerHTML = "<font color='red'>邮箱已被注册</font>";
					document.getElementById("email").value = "";
				} else {
					document.getElementById("demo").innerHTML = "<font color='green'>邮箱可以使用</font>";
				}
			}
		}
	}

	function sendRequest_get(url) {
		createXMLHttpRequest();
		xmlHttp.open("GET", url, true);
		xmlHttp.onreadystatechange = processResponse;
		xmlHttp.send(null);
	}
	function sendRequest_post(url, email) {
		createXMLHttpRequest();
		xmlHttp.open("POST", url, true);
		xmlHttp.onreadystatechange = processResponse;
		xmlHttp.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded;charset=UTF-8');
		xmlHttp.send("email=" + email);
	}

	function validate() {
		var val = document.forms[0].email.value;
		if (val == "") {
			document.getElementById("demo").innerHTML = "<font color='red'>请输入邮箱</font>";
		} else {
			// 			 var url="checkemail?email="+val+"&time="+new Date().getTime();
			// 			 sendRequest_get(url);
			var url = "checkemail?time=" + new Date().getTime();
			sendRequest_post(url, val);
		}
	}
</script>
</head>
<body>
	<div id="demo" style="height: 30px;"></div>
	<form action="" method="POST" name="f1">
		<table>
			<tr>
				<td>注册邮箱：<input type="text" name="email" id="email"
					onblur="validate()"></td>
			</tr>
			<tr>
				<td>注册密码：<input type="password" name="password" id="password"></td>
			</tr>
			<tr>
				<td><input type="button" value="提交"></td>
			</tr>
		</table>
	</form>
</body>
</html>
