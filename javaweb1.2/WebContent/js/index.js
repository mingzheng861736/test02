$(document).ready(function() {
	// 获得主题列表
	getcategoryList();
	// 获得最新的新闻和评论
	getlatestList(1);
	// 获取新闻列表
	getnewsPage(1, 1);
});
// 获取新闻列表
function getnewsPage(categoryId, currPageNo) {
	$.ajax({
		url : "do_index_list",
		data : {
			"categoryId" : categoryId,
			"currPageNo" : currPageNo
		},
		dataType : "json",
		success : function(result) {
			if (result.status == 1) {// 成功
				// 新闻模板
				var template = Handlebars.compile($("#newsdetailList-template").html());
				var strhtml = template(result.data);
				$(".news-list-ul").html(strhtml);
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
// 选择主题
function choiceCategroy(categoryId) {
	// 获得最新的新闻和评论
	getlatestList(categoryId);
	// 获取新闻列表
	getnewsPage(categoryId, 1);
}
function getcategoryList() {
	$.ajax({
		url : "do_category_list",
		data : {
			opt : "list"
		},
		dataType : "json",
		success : function(result) {
			console.log(result);
			if (result.status == 1) {// 成功
				var template = Handlebars.compile($("#categoryList-template").html());
				var strhtml = template(result);
				$("#categoryList").html(strhtml);
				$("#categoryList>li:last").addClass("clear-bottom-line");
			} else {
				alert(result.message);
			}
		},
		error : function(jqxhr, textStatus, errorThrown) {
			alert(jqxhr.status + textStatus + errorThrown);
		}
	});
}
// 获得最新的新闻和评论
function getlatestList(categoryId) {
	$.ajax({
		url : "do_latest_list",
		data : {
			"categoryId" : categoryId
		},
		dataType : "json",
		success : function(result) {
			if (result.status == 1) {// 成功
				// 最新新闻
				var template = Handlebars.compile($("#latestdetailList-template").html());
				var strhtml = template(result);
				$("#latestdetailList").html(strhtml);
				// 最新评论
				template = Handlebars.compile($("#latestcommentList-template").html());
				strhtml = template(result);
				$("#latestcommentList").html(strhtml);
			} else {
				alert(result.message);
			}
		},
		error : function(jqxhr, textStatus, errorThrown) {
			alert(jqxhr.status + textStatus + errorThrown);
		}
	});
}
// 分页跳转
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