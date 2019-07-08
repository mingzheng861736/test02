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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	function validate() {
		var name = $("#name").val();
		if (name == null || name == "") {
			$("#nameDiv").html("用户名不能为空！");
		} else {
			$.ajax({
				url : "userServlet",
				type : "post",
				dataType : "text",
				data : {
					'name' : name,
					'time' : new Date()
				},
				success : function(data) {
					if (data == "true") {
						$("#nameDiv").html("用户名已被使用！");
					} else {
						$("#nameDiv").html("用户名可以使用！");
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
	<form action="" id="form1">
		<table>
			<tr>
				<td>用 户 名：</td>
				<td><input type="text" name="name" id="name"
					onblur="validate();" />&nbsp;<font color="#c00fff">*</font></td>
				<td>
					<div id="nameDiv" style="display: inline"></div>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>