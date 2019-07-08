var g_id = 0;// 新闻id
$(document).ready(function() {
	g_id = getQueryString("id");
	$("#newsid").val(g_id);
	// 获得主题列表
	getcategoryList();
	// 获得最新的新闻和评论
	getlatestList(1);
	// 获得新闻信息
	getnewsDetail(g_id);
	// 获得评论列表
	getcommentList(g_id);
});
// 获得评论列表
function getcommentList(newsid) {
	$.ajax({
		url : "do_comment_list",
		data : {
			id : newsid
		},
		dataType : "json",
		success : function(result) {
			if (result.status == 1) {// 成功
				console.log(result);
				var template = Handlebars.compile($("#commentList-template").html());
				var strhtml = template(result.data);
				$(".comment").html(strhtml);
			} else {
				alert(result.message);
			}
		},
		error : function(jqxhr, textStatus, errorThrown) {
			alert(jqxhr.status + textStatus + errorThrown);
		}
	});
}
// 获得新闻信息
function getnewsDetail(newsid) {
	$.ajax({
		url : "do_news_read",
		data : {
			id : newsid
		},
		dataType : "json",
		success : function(result) {
			if (result.status == 1) {// 成功
				var template = Handlebars.compile($("#newsdetail-template").html());
				var strhtml = template(result.data);
				$("#news_detail").html(strhtml);
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
}
// 获得主题列表
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
//发表评论
function sendComment() {
	var contents = $("#contents").val().trim();
	if (contents == "") {
		alert("评论的内容不能为空!");
		return false;
	}
	//console.log($.param($("#frmcomment").serializeArray()));
	//console.log($("#frmcomment").serialize());
	$.ajax({
		url : "do_comment_add",
		type:"post",
		data :$("#frmcomment").serialize() ,
		dataType : "json",
		success : function(result) {
			if (result.status == 1) {// 成功
				alert(result.message);
				getcommentList(g_id);
			} else {
				alert(result.message);
			}
		},
		error : function(jqxhr, textStatus, errorThrown) {
			alert(jqxhr.status + textStatus + errorThrown);
		}
	});
}