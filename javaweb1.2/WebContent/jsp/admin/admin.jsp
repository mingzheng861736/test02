<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.*,org.news.entity.*,org.news.service.*,java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<c:set var="basePath"
	value="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${path }/"></c:set>
<!DOCTYPE html>
<html>
<head>
<base href="${basePath }">
<meta charset="UTF-8">
<title>无标题文档</title>
<link type="text/css" rel="stylesheet" href="css/common.css" />
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/handlebars-v4.0.11.js"></script>
<script type="text/javascript" src="js/my.js"></script>
<script type="text/javascript" src="js/admin.js"></script>
</head>
<script id="categoryList-template" type="text/x-handlebars-template">
	{{#each data}}
		<option value='{{id}}'>{{name}}</option>
	{{/each}}
</script>
<script id="newsdetailList-template" type="text/x-handlebars-template">
	{{#each newsList}}
		<tr
			{{#addspace @index 2}}
				class="admin-list-td-h2"
			{{/addspace}}
			>
			<td><a href='newsread.jsp?id={{id}}'>{{title}}</a></td>
			<td>{{author}}</td>
			<td>{{createDate }}</td>
			<td><a
				href='jsp/admin/newsupdate.jsp?id={{id}}'>修改</a>
				<a
				href="javascript:void(0)" onclick="deletenews({{id}},this);">删除</a>
			</td>
		</tr>
	{{/each}}
</script>
<script id="page-template" type="text/x-handlebars-template">
	<form action="" method="post">
		<input type="hidden" name="categoryId" id="hidcategoryId"
			value="{{id}}"> <input type="hidden"
			id="hidtotalpagecount" value="{{totalPageCount}}">
		<ul class="page-num-ul clearfix">
			<li>共{{totalRecordCount}}条记录&nbsp;&nbsp;
				{{currPageNo}}/{{totalPageCount}}页</li>

			{{#gt currPageNo 1}}
				<li><a
					href="javascript:getnewsPage({{id}},1);">第一页</a></li>
				<li><a
					href="javascript:getnewsPage({{id}},{{currPageNo}}-1);">上一页</a></li>
			{{/gt}}
			{{#lt currPageNo totalPageCount}}
				<li><a
					href="javascript:getnewsPage({{id}},{{currPageNo}}+1);">下一页</a></li>
				<li><a
					href="javascript:getnewsPage({{id}},{{totalPageCount}});">最后一页</a></li>
			{{/lt}}
		</ul>
		<span class="page-go-form"><label>跳转至</label> <input
			type="text" id="currPageNo" name="currPageNo" class="page-key"
			value="{{currPageNo}}" />页 <input type="button"
			class="page-btn" value="GO" onclick="jump();"/> </span>
	</form>
</script>
<body>
	<c:import url="include/adminTop.jsp"></c:import>

	<!--主体-->
	<div id="content" class="main-content clearfix">
		<c:import url="include/adminSidebar.jsp"></c:import>
		<div class="main-content-right">
			<!--即时新闻-->
			<div class="main-text-box">
				<div class="main-text-box-tbg">
					<div class="main-text-box-bbg">
						<form name="searchForm" id="searchForm"
							action="../do_admin_list" method="post">
							<div>
								新闻分类：
								 <select name="categoryId" id="categoryId">

								</select>
								<button type="button" onclick="searchNews();" class="page-btn">GO</button>
								<button type="button" onclick="addNews();" class="page-btn">增加</button>
							</div>
						</form>
						<table class="admin-list">
							<thead>
								<tr class="admin-list-head">
									<th>新闻标题</th>
									<th>作者</th>
									<th>时间</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>

							</tbody>
						</table>
						<div class="page-bar">
							<form action="../do_admin_list" method="post"
								onsubmit="return jump();">
								<input type="hidden" name="categoryId" id="hidcategoryId"
									value="${newspage.id }"> <input type="hidden"
									id="hidtotalpagecount" value="${newspage.totalPageCount }">
								<ul class="page-num-ul clearfix">
									<li>共${newspage.totalRecordCount }条记录&nbsp;&nbsp;
										${newspage.currPageNo }/${newspage.totalPageCount }页</li>
									<c:if test="${newspage.currPageNo gt 1 }">
										<li><a
											href="../do_admin_list?categoryId=${newspage.id }&currPageNo=1">第一页</a></li>
										<li><a
											href="../do_admin_list?categoryId=${newspage.id }&currPageNo=${newspage.currPageNo-1}">上一页</a></li>
									</c:if>
									<c:if test="${newspage.currPageNo lt newspage.totalPageCount }">
										<li><a
											href="../do_admin_list?categoryId=${newspage.id }&currPageNo=${newspage.currPageNo+1}">下一页</a></li>
										<li><a
											href="../do_admin_list?categoryId=${newspage.id }&currPageNo=${newspage.totalPageCount }">最后一页</a></li>
									</c:if>
								</ul>
								<span class="page-go-form"><label>跳转至</label> <input
									type="text" id="currPageNo" name="currPageNo" class="page-key"
									value="${newspage.currPageNo }" />页 <input type="submit"
									class="page-btn" value="GO" /> </span>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:import url="include/adminBottom.jsp"></c:import>
</body>
</html>