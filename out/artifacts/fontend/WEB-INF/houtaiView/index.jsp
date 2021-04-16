<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<title>宅基送后台</title>

<meta name="keywords" content="宅急送后台管理">

<!--[if lt IE 8]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

<!-- <link rel="shortcut icon" href="favicon.ico"> -->
<link href="houtai/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
<link href="houtai/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
<link href="houtai/css/animate.min.css" rel="stylesheet">
<link href="houtai/css/style.min.css?v=4.0.0" rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg"
	style="overflow: hidden">
	<div id="wrapper">
		<!--左侧导航开始-->
		<nav class="navbar-default navbar-static-side" role="navigation">
			<div class="sidebar-collapse">

				<ul class="nav" id="side-menu">
					<li class="nav-header">
						<div class="dropdown profile-element">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#"> <span
								class="clear"> <span class="block m-t-xs"><strong
										class="font-bold">${staff.staffLoginName}</strong></span> <span
									class="text-muted text-xs block">${staff.staffName}<b
										class="caret"></b></span>
							</span>
							</a>
							<ul class="dropdown-menu animated fadeInDown">
								<!-- <li><a class="J_menuItem" href="profile.html">个人资料</a></li>
								<li class="divider"></li> -->
								<li><a href="${ctx}/houtai/staff/logout.do">安全退出</a></li>
							</ul>
						</div>
					</li>


					<li><a class="J_menuItem" href="view/index_v1.html"
						data-index="0"><i class="fa fa-home"></i> <span
							class="nav-label">主页</span> </a></li>


					<li><a href="#"><i class="fa fa-user"></i> <span
							class="nav-label">客户管理</span> <span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a class="J_menuItem"
								href="${ctx}/houtai/customer/list.do">客户信息</a></li>
						</ul></li>

					<li><a href="#"><i class="fa fa-map-o"></i> <span
							class="nav-label">地址管理</span> <span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a class="J_menuItem"
								href="${ctx}/houtai/address/list.do">客户地址</a></li>
						</ul> <%-- <ul class="nav nav-second-level">
							<li><a class="J_menuItem"
								href="${ctx}/houtai/address/list_shoujian.do">收件人地址</a></li>
						</ul>  --%></li>

					<li><a href="#"><i class="fa fa-users"></i> <span
							class="nav-label">配送员管理</span> <span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a class="J_menuItem" href="${ctx}/houtai/staff/list.do">配送员信息</a>
							</li>
							<li><a class="J_menuItem"
								href="${ctx}/houtai/staff/insert.do">添加配送员</a></li>
						</ul></li>


					<li><a href="#"><i class="fa fa-building-o"></i> <span
							class="nav-label">网点管理</span> <span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a class="J_menuItem" href="${ctx}/houtai/dot/list.do">网点管理</a>
							</li>
							<li><a class="J_menuItem" href="${ctx}/houtai/dot/insert.do">添加网点</a>
							</li>
						</ul></li>

					 <li><a href="#"><i class="fa fa-money"></i> <span
							class="nav-label">定价管理</span> <span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a class="J_menuItem" href="${ctx}/houtai/shipAddress/ship_address_list.do">运送地址定价（镇/区/县）</a>
							</li>
							<li><a class="J_menuItem" href="${ctx}/houtai/resSort/res_sort_list.do">物件类别定价</a>
							</li>
							<%-- <li><a class="J_menuItem" href="${ctx}/houtai/resWeight/res_weight_list.do">物件重量定价</a>
							</li> --%>
						</ul></li> 

				

					<li><a href="${ctx}/houtai/order/list.do" class="J_menuItem"><i
							class="fa fa-newspaper-o"></i> <span class="nav-label">订单信息</span></a>

					</li>

					<li><a href="${ctx}/houtai/waybill/list.do" class="J_menuItem"><i
							class="fa fa-bookmark-o"></i> <span class="nav-label">运单信息</span>
					</a></li>


					<li><a href="${ctx}/houtai/feedback/list.do"
						class="J_menuItem"><i class="fa fa-book"></i> <span
							class="nav-label">反馈建议</span> </a></li>


					<%-- <li><a href="${ctx}/city/list.do" class="J_menuItem"><i
							class="fa fa-building-o"></i> <span class="nav-label">城市开放权限</span>
					</a></li> --%>


				</ul>
			</div>
		</nav>
		<!--左侧导航结束-->

		<!--右侧部分开始-->
		<div id="page-wrapper" class="gray-bg dashbard-1">
			<div class="row border-bottom" style="height: 45px;">
				<nav class="navbar navbar-default">

					<a class="navbar-minimalize minimalize-styl-2" href="#"> <i
						class="fa fa-bars"></i>
					</a>

					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav navbar-left">
							<li><a href="view/index_v1.html">欢迎来到宅急送后台系统</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li><a href="${ctx}/houtai/staff/logout.do"><i
									class="fa fa fa-sign-out"></i> 退出</a></li>
						</ul>
					</div>

				</nav>
			</div>


			<div class="row J_mainContent" id="content-main"
				style="height: 500px;">
				<iframe class="J_iframe" name="iframe0" width="100%" height="100%"
					src="view/index_v1.html?v=4.0" frameborder="0"
					data-id="view/index_v1.html" seamless></iframe>
			</div>

		</div>

	</div>


	<script src="houtai/js/jquery.min.js?v=2.1.4"></script>
	<script src="houtai/js/bootstrap.min.js?v=3.3.5"></script>
	<script src="houtai/js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="houtai/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="houtai/js/plugins/layer/layer.min.js"></script>
	<script src="houtai/js/hplus.min.js?v=4.0.0"></script>
	<script type="text/javascript" src="houtai/js/contabs.min.js"></script>
	<script src="houtai/js/plugins/pace/pace.min.js"></script>
</body>

</html>
