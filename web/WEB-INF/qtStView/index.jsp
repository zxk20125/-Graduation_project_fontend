<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>宅急送</title>
	    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	    <link rel="stylesheet" href="${ctx}/qtCustomer/css/amazeui.min.css" type="text/css" />
	    <link rel="stylesheet" href="${ctx}/qtCustomer/css/style.css" type="text/css" />
	    <script type="text/javascript" src="${ctx}/qtCustomer/js/jquery.min.js" ></script>
	    <script type="text/javascript" src="${ctx}/qtCustomer/js/amazeui.min.js" ></script>
	    <script>
	    	$(function(){
	    		$(".search-text").click(function(){
	    			$(".am-icon-search").hide();
	    			$(this).attr("value","");
	    		})
	    	})
	    </script>
		<style type="text/css">
			.yg{
				margin-left: 45%;
				font-size: 15px;
				border: #008B31;
				
			}
		</style>
	</head>
	<body>
		<header data-am-widget="header" class="am-header am-header-default header-green">
<!-- 	      <div class="am-header-left am-header-nav">
		        <a href="" class="" style="color: #fff;">
			        <img src="images/saoyisao.png">
			        <p style="font-size: 12px; margin-top: -35px;">&nbsp扫一扫</p>
			    </a>
		  </div> -->
        <div class="search">
        	<i class="am-icon-search" onclick=""></i>
           <input type="text" class="search-text" value="请输入订单号" onchange="sousuo();" id="sou"/>
        </div>

		  </header>
		<div class="banner"><img src="${ctx}/qtCustomer/images/zjsyg.jpg"/></div>
		<ul class="menu">
			<li>
				<a href="${ctx}/qtStaff/logistics/logistics.do" class="menu-box">
					<p>更新物流</p>
					<i class="iconfont">&#xe606;</i>
				</a>
			</li>
				<li>
				<a href="${ctx}/qtStaff/send/send.do" class="menu-box">
					<p>设置派送</p>
					<i class="iconfont">&#xe605;</i>
				</a>
			</li>
				<li>
				 <a href="${ctx}/qtStaff/send/finish.do" class="menu-box">
					<p>处理派送</p>
					<i class="iconfont">&#xe608;</i>
				</a> 
			</li>
				<li>
				 <a href="${ctx}/qtStaff/order/order.do" class="menu-box">
					<p>快递订单</p>
					<i class="iconfont">&#xe612;</i>
				</a> 
			</li>
		</ul>
		<div class="jl"></div>
		 <div class="yg">
		 	
		 </div>
		 <div data-am-widget="navbar" class="am-navbar  dream-foot am-no-layout" id="">
		      <ul class="am-navbar-nav1 am-cf am-avg-sm-2">   
		          <li >
		            <a href="index.html" class="curr">
		                <span class="iconfont">&#xe60b;</span>
		                <p class="am-navbar-label">首页</p>
		            </a>
		          </li>
		          
		        <%--   <li>
		            <a href="${ctx}/qtStaff/order/order.do" class="">
		                <span class="add"><i class="iconfont" style="font-size: 30px; line-height: 40px;">&#xe612;</i></span>
		                <p class="am-navbar-label" style="margin-top: -36px;">订单</p>
		            </a>
		          </li>
		          --%>
		          <li>
		            <a href="${ctx}/qtStaff/order/order.do" class="">
		                <span class="iconfont">&#xe612;</span>
		                <p class="am-navbar-label">订单</p>
		            </a>
		          </li>
		      </ul> 
		</div>
		<div>
			
			</div>
	
	</body>
	 <script src="${ctx}/qtCustomer/js/jquery.min.js"></script>
	<script type="text/javascript">
	function sousuo(){
		var id = $("#sou").val();
		console.log(id);
		var data = {
				"id":id
		}
		$.post(getContextPath()+"/qtStaff/order/sousuo.do",data,function(msg){ 
			if(msg==1){
				window.location.href = getContextPath()+"/qtCustomer/order/orderTracking.do?waybill_id="+id
			}else{
				alert("运单号不存在")
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
	function getContextPath() {
		var local = window.location;
		//获取 pathname 属性的值 
		var pathname = local.pathname;
		//将字符串以 斜杠/切割成数组
		var arr = pathname.split("/");
		//获取上下文路径
		var contextPath = arr[1];
		return "/" + contextPath;// : /ajax
	};
	</script>
</html>
