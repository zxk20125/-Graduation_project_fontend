<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set><!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>建议反馈</title>
        <meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" name="viewport"/>
        <meta content="yes" name="apple-mobile-web-app-capable"/>
        <meta content="black" name="apple-mobile-web-app-status-bar-style"/>
        <meta content="telephone=no" name="format-detection"/>
        <link href="${ctx}/qtCustomer/css/style3.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
      
        <section class="aui-flexView">
            <header class="aui-navBar aui-navBar-fixed" style="color: #008B31;">
                <a href="javascript:history.back(-1)" class="aui-navBar-item" style="color: #008B31;">
                    <i class="icon icon-return"></i>
                </a>
                <div class="aui-center">
                    <span class="aui-center-title">意见反馈</span>
                </div>
                <!-- <a href="javascript:;" class="aui-navBar-item">
                    <i class="icon icon-sys"></i>
                </a> -->
            </header>
            <section class="aui-scrollView">
            <input type="hidden" id="cutomer_id" name="cutomerId" value="${customer.customerId}"/>
                <div class="aui-view-box">
                    <div class="aui-view-box-item">
                    
                        <h2>您的问题或建议:</h2>
                        <textarea id="content" placeholder="输入个人意见反馈,字数在100字以内"></textarea>
                    </div>
                    <div class="aui-view-box-item">
                        <h2>您的联系方式:</h2>
                        
                        <input type="text" placeholder="输入电子邮箱" id="mailbox">
                    </div>
                    <div class="aui-view-box-item">
                        <p>留下您的联系方式,以便我们了解问题后及时反馈和结果，紧急问题请联系客服。</p>
                    </div>
                    <div class="aui-btn-submit">
                        <button onclick="doinsert();">提交建议</button>
                    </div>
                </div>
            </section>
            <footer class="aui-footer aui-footer-fixed">
                <p>
                    <span>
                        遇到问题了？ 点击 <em>在线客服</em>
                    </span>
                </p>
            </footer>
        </section>
    </body>
    <script src="${ctx}/houtai/js/jquery.min.js?v=2.1.4"></script>
    <script type="text/javascript">
    /* var cuId = $("#cutomer_id").val();
    console.log(cuId); */
    
    function doinsert(){
    	var cuId = $("#cutomer_id").val();
    	var content = $("#content").val();
    	var mailbox = $("#mailbox").val();
    	
    	var feedback = {
    			"customerId":cuId,
    			"feedbackContent":content,
    			"mailxbox":mailbox
    	}
    	console.log(feedback)
    	
    	$.post(getContextPath()+"/qtCustomer/feedback/doinsert.do",feedback,function(msg){
    		if(msg==1){
    			alert("谢谢您的建议反馈！");
    			window.location.href = getContextPath()+"/qtCustomer/customer/index.do"
    		}else{
    			alert("添加失败");
    		}
    	}
    	)
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
</html>
