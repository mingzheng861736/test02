//登录
function login() {
	var username = $("#username").val();
	if (username == "") {
		alert("用户名不能为空!");
		$("#username").focus();
		return;
	}
	var password = $("#password").val();
	if (password == "") {
		alert("密码不能为空!");
		$("#password").focus();
		return;
	}
	$.ajax({
		url : "do_login",
		data : $("#frmlogin").serialize(),
		dataType : "json",
		success : function(result) {
			if (result.status == 1) {// 成功
				location.href="jsp/admin/admin.jsp";
			} else {
				alert(result.message);
			}
		},
		error : function(jqxhr, textStatus, errorThrown) {
			alert(jqxhr.status + textStatus + errorThrown);
		}
	});
}