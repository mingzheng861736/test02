$(document).ready(function() {
	// 获得主题列表
	getcategoryList();
	// 获取新闻列表
	getnewsPage(1, 1);
});
function getcategoryList() {
	$.ajax({
		url : "do_category_list",
		data : {
			opt : "list"
		},
		dataType : "json",
		success : function(result) {
			if (result.status == 1) {// 成功
				var template = Handlebars.compile($("#categoryList-template").html());
				var strhtml = template(result);
				$("#categoryId").html(strhtml);
			} else {
				alert(result.message);
			}
		},
		error : function(jqxhr, textStatus, errorThrown) {
			alert(jqxhr.status + textStatus + errorThrown);
		}
	});
}
// 获取新闻列表
function getnewsPage(categoryId, currPageNo) {
	$.ajax({
		url : "do_admin_list",
		data : {
			"categoryId" : categoryId,
			"currPageNo" : currPageNo
		},
		dataType : "json",
		success : function(result) {
			if (result.status == 1) {// 成功
				console.log(result);
				// 新闻模板
				var template = Handlebars.compile($("#newsdetailList-template").html());
				var strhtml = template(result.data);
				$("table.admin-list>tbody").html(strhtml);
				// 分页模板
				template = Handlebars.compile($("#page-template").html());
				strhtml = template(result.data);
				$(".page-bar").html(strhtml);
			} else {
				alert(result.message);
			}
		},
		error : function(jqxhr, textStatus, errorThrown) {
			alert(jqxhr.status + textStatus + errorThrown);
		}
	});
}
function searchNews() {
	var categoryId = $("#categoryId").val();
	getnewsPage(categoryId, 1);
}
function addNews() {
	location.href = "jsp/admin/newsadd.jsp";
}
function jump() {
	var currPageNo = $("#currPageNo").val();
	var totalpagecount = $("#hidtotalpagecount").val();
	var categoryId = $("#hidcategoryId").val();
	var regexp = /^[1-9]\d*$/;
	if (!regexp.test(currPageNo)) {
		alert("必须输入大于0的整数!");
		return false;
	}
	if ((currPageNo - totalpagecount) > 0) {
		alert("页号超出范围了!")
		return false;
	}
	getnewsPage(categoryId, currPageNo);
}
function deletenews(id, link) {
	$.ajax({
		url : "do_news_delete",
		type:"get",
		data : {
			"id" : id
		},
		dataType : "json",
		success : function(result) {
			if (result.status == 1) {// 成功
				alert(result.message);
				$(link).parent().parent().remove();
			} else {
				alert(result.message);
			}
		},
		error : function(jqxhr, textStatus, errorThrown) {
			alert(jqxhr.status + textStatus + errorThrown);
		}
	});
}