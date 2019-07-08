//每隔n行,添加样式
Handlebars.registerHelper("addspace", function(v1, v2, options) {
	if ((v1 + 1) % v2 == 0) {
		// 满足条件继续执行
		return options.fn(this);
	} else {
		// 不满足条件执行{{else}}部分
		return options.inverse(this);
	}
});
// 大于
Handlebars.registerHelper("gt", function(v1, v2, options) {
	if (v1 > v2) {
		// 满足条件继续执行
		return options.fn(this);
	} else {
		// 不满足条件执行{{else}}部分
		return options.inverse(this);
	}
});
// 小于
Handlebars.registerHelper("lt", function(v1, v2, options) {
	if (v1 < v2) {
		// 满足条件继续执行
		return options.fn(this);
	} else {
		// 不满足条件执行{{else}}部分
		return options.inverse(this);
	}
});
//等于
Handlebars.registerHelper("eq", function(v1, v2, options) {
	if (v1 == v2) {
		// 满足条件继续执行
		return options.fn(this);
	} else {
		// 不满足条件执行{{else}}部分
		return options.inverse(this);
	}
});
// 注册一个翻译用的Helper，0翻译成男，1翻译成女
Handlebars.registerHelper("transformat", function(value) {
	if (value == 0) {
		return "男";
	} else if (value == 1) {
		return "女";
	}
});
// 加一
Handlebars.registerHelper("addOne", function(value) {
	return ++value;
});
//采用正则表达式获取地址栏参数
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null) {
		return unescape(r[2]);
	}
	return null;
}