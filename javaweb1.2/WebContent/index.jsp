<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.news.entity.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<c:set var="basePath"
	value="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${path }/"></c:set>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="${basePath }">
<title>My JSP 'doUserCreate.jsp' starting page</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/handlebars-v4.0.11.js"></script>
<script type="text/javascript" src="js/my.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript">

</script>
</head>
<script id="newsdetailList-template" type="text/x-handlebars-template">
{{#each newsList}}
	{{#addspace @index 5}}
  	<li class='li-line'><span> {{createDate}}</span> <a href='newsread.jsp?id={{id}}'>{{title}}</a></li>
	{{else}}
		<li><span> {{createDate}}</span> <a href='newsread.jsp?id={{id}}'>{{title}}</a></li>
	{{/addspace}}
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
	<c:import url="include/indexTop.jsp"></c:import>
	<!--d页面主体-->
	<div id="content" class="main-content clearfix">
		<c:import url="include/indexSidebar.jsp"></c:import>
		<!--页面主体的右部，包括新闻的列表和评论内容 -->
		<div class="main-content-right">
			<!--各专题的新闻列表-->
			<div class="main-text-box">
				<div class="main-text-box-tbg">
					<div class="main-text-box-bbg">

						<div class="main-text-box-header">
							<h3>
								<span id="categoryName"></span> 新闻
							</h3>
						</div>
						<div class="main-text-box-content">
							<ul class="news-list-ul clearfix">

							</ul>
						</div>
						<!--图片新闻-->
						<div class="news-pic">
							<dl>
								<dt>
									<img src="images/new-1.png" />
								</dt>
								<dd>PHP从入门到放弃</dd>
							</dl>
							<dl>
								<dt>
									<img src="images/new-2.png" />
								</dt>
								<dd>Java Web从绝望到希望</dd>
							</dl>
							<dl>
								<dt>
									<img src="images/new-3.png" />
								</dt>
								<dd>课工场五一回馈</dd>
							</dl>
							<dl>
								<dt>
									<img src="images/new-2.png" />
								</dt>
								<dd>Java Web从绝望到希望</dd>
							</dl>
						</div>
						<div class="page-bar">

						</div>
					</div>
				</div>
			</div>
			<!--合作媒体-->
			<div class="main-text-box">
				<div class="main-text-box-tbg">
					<div class="main-text-box-bbg">
						<div class="main-text-box-header">
							<h3>合作媒体</h3>
						</div>
						<div class="main-text-box-content">
							<ul class="link-text-ul clearfix">
								<li><a href="#">中国政府网</a></li>
								<li><a href="#">中国政府网</a></li>
								<li><a href="#">中国政府网</a></li>
								<li><a href="#">中国政府网</a></li>
								<li><a href="#">中国政府网</a></li>
								<li><a href="#">中国政府网</a></li>
								<li><a href="#">中国政府网</a></li>
								<li><a href="#">中国政府网</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:import url="include/indexBottom.jsp"></c:import>
</body>
</html>