<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.news.entity.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script id="latestdetailList-template" type="text/x-handlebars-template">
	{{#each data.latestdetailList}}
		<li><a href='newsread.jsp?id={{id}}'>{{title}}</a>
	{{/each}}
</script>
<script id="latestcommentList-template" type="text/x-handlebars-template">
	{{#each data.latestcommentList}}
		<li><a href='newsread.jsp?id={{id}}'>{{title}}</a>
	{{/each}}
</script>
<script id="categoryList-template" type="text/x-handlebars-template">
{{#each data}}
	<li><a	href='javascript:choiceCategroy({{id}});'>{{name }}</a></li>
{{/each}}
</script>
<!--主体的的左边部分-->
<div class="main-content-left">
	<!--新闻专题分类-->
	<div class="class-box">
		<div class="class-box-header">
			<span class="fr"><a href="#">更多...</a></span>
			<h3>新闻专题</h3>
		</div>
		<div class="class-box-content">
			<ul id="categoryList">

			</ul>
		</div>
	</div>
	<!--最新新闻-->
	<div class="left-box">
		<div class="left-box-tbg">
			<div class="left-box-bbg">
				<div class="left-box-header">
					<h3>
						<a href="#">最新新闻</a>
					</h3>
				</div>
				<div class="left-box-content">
					<ul id="latestdetailList">

					</ul>
				</div>
			</div>
		</div>
	</div>
	<!--最新评论-->
	<div class="left-box">
		<div class="left-box-tbg">
			<div class="left-box-bbg">
				<div class="left-box-header">
					<h3>最新评论</h3>
				</div>
				<div class="left-box-content">
					<ul id="latestcommentList">

					</ul>
				</div>
			</div>
		</div>
	</div>
</div>