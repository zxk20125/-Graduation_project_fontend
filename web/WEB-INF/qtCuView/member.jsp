<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>个人中心</title>
	    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	    <link rel="stylesheet" href="${ctx}/qtCustomer/css/amazeui.min.css" type="text/css" />
	    <link rel="stylesheet" href="${ctx}/qtCustomer/css/style.css" type="text/css" />
	    <script type="text/javascript" src="${ctx}/qtCustomer/js/jquery.min.js" ></script>
	    <script type="text/javascript" src="${ctx}/qtCustomer/js/amazeui.min.js" ></script>
	</head>
	<body class="bgcolor">
		<header data-am-widget="header" class="am-header am-header-default header-green1">
	      <div class="am-header-left am-header-nav ">
		        <a href="javascript:history.back()" style="color: #fff;"><i class="am-icon-chevron-left"></i></a>
	        </div>
		  <h1 class="am-header-title" style="color: #fff;">个人中心</h1>
       </header>
       <div class="jl"></div>
       <div class="member">
			<div class="mem-tit">${customer.customerLoginName}<a href="step.html" class="step"></a></div>
			<div class="mem-pic">
                 <div class="mem-pic-bg" style=" background-image:url(${ctx}/qtCustomer/images/tx.png)"></div>									
			</div>
			
			
	   </div>
	   <ul class="member-list">
	     	<li>
				<a href="${ctx}/qtCustomer/customer/geren.do">
					<%-- <img src="${ctx}/qtCustomer/images/icon07.png"> --%>
					<span>个人信息</span>
					<i class="am-icon-angle-right"></i>
				</a>
			</li>
			<li>
				<a href="${ctx}/qtCustomer/address/list.do">
					<!-- <img src="images/icon01.png"> -->
					<span>地址簿</span>
					<i class="am-icon-angle-right"></i>
				</a>
			</li>
			<li>
				<a href="${ctx}/qtCustomer/dot/select.do">
					
					<span>网点查询</span>
					<i class="am-icon-angle-right"></i>
				</a>
			</li>
			<li>
				<a href="${ctx}/qtCustomer/order/myorder.do">
					<%-- <img src="${ctx}/qtCustomer/images/icon02.png"> --%>
					<span>我的订单</span>
					<i class="am-icon-angle-right"></i>
				</a>
			</li>
			<li>
				<a href="${ctx}/qtCustomer/freight/xianshi.do">
					<%-- <img src="${ctx}/qtCustomer/images/icon02.png"> --%>
					<span>运费估算</span>
					<i class="am-icon-angle-right"></i>
				</a>
			</li>
		<li>
				<a href="${ctx}/qtCustomer/feedback/insert.do">
					<%-- <img src="${ctx}/qtCustomer/images/icon02.png"> --%>
					<span>反馈建议</span>
					<i class="am-icon-angle-right"></i>
				</a>
			</li>
		</ul>
		
		
       <div class="jl"></div>
		 <div data-am-widget="navbar" class="am-navbar  dream-foot am-no-layout" id="">
		      <ul class="am-navbar-nav1 am-cf am-avg-sm-4">   
		          <li>
		            <a href="${ctx}/qtCustomer/customer/index.do" class="curr">
		                <span class="iconfont">&#xe60b;</span>
		                <p class="am-navbar-label">首页</p>
		            </a>
		          </li>
		          <li>
		            <a href="${ctx}/qtCustomer/jijian/xianshi.do" class="">
		                <span class="iconfont">&#xe60c;</span>
		                <p class="am-navbar-label">寄件</p>
		            </a>
		          </li>
		          <li>
		            <a href="${ctx}/qtCustomer/order/myorder.do" class="">
		               <!--  <span class="add"><i class="iconfont" style="font-size: 30px; line-height: 40px;">&#xe60e;</i></span>
		                <p class="am-navbar-label" style="margin-top: -36px;">订单</p> -->
		                 <span class="iconfont">&#xe60e;</span>
		                <p class="am-navbar-label" ">订单</p>
		            </a>
		          </li>
		       <!--    <li>
		            <a href="message.html" class="">
		                <span class="iconfont">&#xe60d;</span>
		                <p class="am-navbar-label">寄件须知</p>
		            </a>
		          </li> -->
		          <li>
		            <a href="${ctx}//qtCustomer/customer/member.do" class="">
		                <span class="iconfont">&#xe609;</span>
		                <p class="am-navbar-label">个人中心</p>
		            </a>
		          </li>
		      </ul>
		</div>
		<div id="msg_bh" style="display:none; width:100%; height:100%; z-index: 9999; background: rgba(0,0,0,0.8); position: fixed; top: 0; left: 0; "> 
        	<p style="top: 45%; position: fixed; left: 42%;"><img src="images/loading.gif" width="50"/></p>
        </div>

		<script>
			$(function(){
			        $('.mem-pic-bg').click(function(){
			            $('input[name=file]').click();
			        })
			        $('input[name=file]').change(function(){
						$('#msg_bh').show();
			            var fd = new FormData();
			            fd.append("upload", 1);
			            fd.append("img", $("input[name=file]").get(0).files[0]);
			            $.ajax({
			                url: "",
			                type: "POST",
			                processData: false,
			                contentType: false,
			                data: fd,
			                success: function(d) {
			              console.log(d);  
			                    if(d.status){
			                        $('.mem-pic-bg').css('background-image','url('+ d.info+')');
									$('#msg_bh').hide();
			                        location.reload();
			                    }else{
			                        alert(d.info);
			                    }
			                }
			            });
			        })
			    });
		</script>
	</body>
</html>

