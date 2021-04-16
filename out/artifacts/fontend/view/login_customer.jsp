<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>宅急送登录</title>

<link rel="../houtai/shortcut icon" href="favicon.ico">
<link href="../houtai/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
<link href="../houtai/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">

<link href="../houtai/css/animate.min.css" rel="stylesheet">
<link href="../houtai/css/style.min.css?v=4.0.0" rel="stylesheet">
<base target="_blank">
<!--[if lt IE 8]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
<script>
	if (window.top !== window.self) {
		window.top.location = window.location;
	}
</script>
</head>

<body class="gray-bg" >

	<div class="middle-box text-center loginscreen animated fadeInUp">
		<div>
			<div>

				<img src="../qtCustomer/img2/login_user.png">

			</div>
			<h3>宅急送</h3>

			<form class="m-t" role="form"  id="loginform" >
				<div class="form-group">
					<input class="form-control" placeholder="用户名" required=""
						name="customer_login_name">
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="密码" required=""
						 name="customer_password">
				</div>
				<div id="errorMsg"></div>
				
				<button type="submit"  class="btn btn-primary block full-width m-b"
					style="background-color: #0088CC; border-color: #0088CC;">登
					录</button>


				<p class="text-muted text-center">
					<!-- <a href="login.html#" > --> <!-- <small>忘记密码了？</small></a> | --> <a
						href="register.jsp" target="_self">注册一个新账号</a>
				</p>

			</form>
		</div>
	</div>
	<script src="../houtai/js/jquery.min.js?v=2.1.4"></script>
	<script src="../houtai/js/bootstrap.min.js?v=3.3.5"></script>

	<script type="text/javascript">
		$(function(){

			
			 $("#loginform").submit(function(){
				
				var loginFormData = $("#loginform").serialize();
				console.log(loginFormData);
				//解决中文乱码
   				loginFormData = decodeURIComponent(loginFormData,true);
				
				$.post(getContextPath()+"/qtCustomer/customer/login.do",loginFormData,function(msg){ 
					//console.log(msg);
					if(msg == 0){
						//登录失败
						/* $("#errorMsg").text(msg.message); */
						/* $("#errorMsg").css("color","red"); */
						$("#errorMsg").text("账号或密码错误");
						$("#errorMsg").css("color","red");
					}else{
						 window.location.href = getContextPath()+"/qtCustomer/customer/index.do"; 
					}
			  	});  
				return false;
			}); 
			 
			
		});
		
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