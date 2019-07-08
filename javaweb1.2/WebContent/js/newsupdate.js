$(document).ready(function() {
	var id = getQueryString("id");
	// 获得主题列表和新闻
	getnews(id);
});
function getnews(id) {
	$.ajax({
		url : "do_category_list",
		data : {
			opt : "addupdate"
		},
		dataType : "json",
		success : function(categorys) {
			if (categorys.status == 1) {// 成功
				$.ajax({
					url : "do_news_read",
					data : {
						"id" : id
					},
					dataType : "json",
					success : function(detail) {
						if (detail.status == 1) {// 成功
							categorys.categoryId = detail.data.categoryId;
							console.log(categorys);
							console.log(detail);
							var source = "{{#each data}}<option {{#eq id ../categoryId}}selected{{/eq}} value={{id}}>{{name}}</option>{{/each}}"
							var template = Handlebars.compile(source);
							var strhtml = template(categorys);
							$("#categoryId").html(strhtml);
							template = Handlebars.compile($("#newsdetail-template").html());
							strhtml = template(detail.data);
							$("#frmnews p:first-of-type").after(strhtml);
						} else {
							alert(result.message);
						}
					},
					error : function(jqxhr, textStatus, errorThrown) {
						alert(jqxhr.status + textStatus + errorThrown);
					}
				});
			} else {
				alert(result.message);
			}
		},
		error : function(jqxhr, textStatus, errorThrown) {
			alert(jqxhr.status + textStatus + errorThrown);
		}
	});
}
function updatenews() {
	if (!checknews()) {
		return;
	}
	var formData = new FormData($("#frmnews")[0]);
	console.log($("#categoryId").val());
	$.ajax({
		url : "do_news_update",
		type : "post",
		data : formData,
		dataType : "json",
		cache : false,
		contentType : false,
		processData : false,
		success : function(result) {
			if (result.status == 1) {// 成功
				alert(result.message);
				location.href = "jsp/admin/admin.jsp";
			} else {
				alert(result.message);
			}
		},
		error : function(jqxhr, textStatus, errorThrown) {
			alert(jqxhr.status + textStatus + errorThrown);
		}
	});
}
function checknews() {
	var title = $("#title").val();
	if (title == "") {
		alert("标题不能为空!");
		$("#title").focus();
		return false;
	}
	var author = $("#author").val();
	if (author == "") {
		alert("作者不能为空!");
		$("#author").focus();
		return false;
	}
	var summary = $("#summary").val();
	if (summary == "") {
		alert("摘要不能为空!");
		$("#summary").focus();
		return false;
	}
	var contents = $("#contents").val();
	if (contents == "") {
		alert("内容不能为空!");
		$("#contents").focus();
		return false;
	}
	var file = $("input[name=filename]").prop("files")[0];
	if (file) {
		if (file.size > 5 * 1024 * 1024) {
			alert("文件大小不能超过5mb");
			return false;
		}
		var filename = file.name.toLowerCase();
		if (!/^.+\.(jpg|jpeg|png|gif|bmp)$/.test(filename)) {
			alert("必须是个图片文件!");
			return false;
		}
	}
	return true;
}