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
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	function validate() {
		var val = document.forms[0].email.value;
		if (val == "") {
			document.getElementById("demo").innerHTML = "<font color='red'>请输入邮箱</font>";
		} else {
			$
					.ajax({
						url : "checkemail",
						type : "get",
						data : {
							email : val
						},
						dataType : "text",
						success : function(data) {
							if (data == "fail") {
								document.getElementById("demo").innerHTML = "<font color='red'>邮箱已被注册</font>";
								document.getElementById("email").value = "";
							} else {
								document.getElementById("demo").innerHTML = "<font color='green'>邮箱可以使用</font>";
							}
						},
						error : function(jqxhr, textStatus, errorThrown) {
							alert(jqxhr.status);
						}
					});
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
