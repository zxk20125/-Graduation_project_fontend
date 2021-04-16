<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
<meta
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0"
	name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<link href="${ctx}/qtCustomer/css/style6.css" rel="stylesheet"
	type="text/css" />
</head>
<body>


	<section class="aui-flexView">
		<header class="aui-navBar aui-navBar-fixed">
			<!--  <a href="javascript:;" class="aui-navBar-item">
                    <i class="icon icon-return"></i>
                </a> -->
			<div class="aui-center">
				<span class="aui-center-title">配送员</span>
			</div>
			<!--  <a href="javascript:;" class="aui-navBar-item">
                    免密登录
                </a> -->
		</header>
		<section class="aui-scrollView">
			<div class="aui-entry-box">
				<div class="aui-entry-head">
					<div class="aui-entry-img">
						<img src="${ctx}/qtCustomer/images2/head-title.png" alt="">
					</div>
					<div class="aui-flex-item">
						<div class="aui-flex b-line">
							<div class="aui-flex-icon">
								<img src="${ctx}/qtCustomer/images2/icon-user.png" alt="">
							</div>
							<div class="aui-flex-box">
								<input type="text" placeholder="帐号名" id="loginName">
							</div>
						</div>
						<div class="aui-flex">
							<div class="aui-flex-icon">
								<img src="${ctx}/qtCustomer/images2/icon-psd.png" alt="">
							</div>
							<div class="aui-flex-box">
								<input type="password" placeholder="密码" id="password">
							</div>
						</div>
					</div>
					<div class="aui-entry-button">
						<button onclick="login();">登录</button>
					</div>
					<div class="aui-entry-forget">
						<a href="javascript:;">忘记密码？</a>
					</div>
				</div>
				<!--   <div class="aui-entry-text">
                        <p>第三方快速登录</p>
                    </div>
                    <div class="aui-entry-signs">
                        <button> <i class="icon icon-wx"></i> 微信</button>
                        <button style="color:#38a9d3"><i class="icon icon-qq"></i>QQ</button>
                    </div> -->
			</div>
		</section>
	</section>
	<script src="${ctx}/qtCustomer/js/jquery.min.js"></script>
	<script type="text/javascript">
	function login(){
		var loginName = $("#loginName").val();
		var password = $("#password").val();
		var data = {
				"loginName":loginName,
				"password":password
		}
		
		$.post(getContextPath()+"/qtStaff/staff/login.do",data,function(msg){ 
			if(msg==1){
				 window.location.href = getContextPath()+"/qtStaff/staff/index.do"; 
			}else{
				alert("帐号或密码错误");
			}
		})
	}
	
	
	window.alert = function(name){
	    var iframe = document.createElement("IFRAME");
	    iframe.style.display="none";
	    iframe.setAttribute("src", 'data:text/plain,');
	    document.documentElement.appendChild(iframe);
	    window.frames[0].window.alert(name);
	    iframe.parentNode.removeChild(iframe);
	};

	window.confirm = function (message) {
	    var iframe = document.createElement("IFRAME");
	    iframe.style.display = "none";
	    iframe.setAttribute("src", 'data:text/plain,');
	    document.documentElement.appendChild(iframe);
	    var alertFrame = window.frames[0];
	    var result = alertFrame.window.confirm(message);
	    iframe.parentNode.removeChild(iframe);
	    return result;
	};
		/**
		 * 封装获取上下文路径的方法 
		 * @returns {String}
		 */
		function getContextPath(){
			var local = window.location;
			//获取 pathname 属性的值 
			var pathname = local.pathname;
			//将字符串以 斜杠/切割成数组
			var  arr = pathname.split("/");
			//获取上下文路径
			var contextPath = arr[1];
			return "/"+contextPath;// : /ajax
		};
		 
	</script>
</body>
</html>
