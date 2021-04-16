<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>个人信息</title>
        <meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" name="viewport"/>
        <meta content="yes" name="apple-mobile-web-app-capable"/>
        <meta content="black" name="apple-mobile-web-app-status-bar-style"/>
        <meta content="telephone=no" name="format-detection"/>
        <link href="${ctx}/qtCustomer/css/style2.css" rel="stylesheet" type="text/css"/>
				<style type="text/css">
					.chongzhi{
						 background:#fd8238;
						color:#fff;
						font-size:14px;
						display:block;
						width:100%;
						height:40px;
						line-height:40px;
						text-align:center;
						border-radius:3px;
						box-shadow:0 1px 3px #b7b7b7;
					}
				</style>
    </head>
    <body>
 
        <section class="aui-flexView">
            <header class="aui-navBar aui-navBar-fixed b-line">
                <a href="javascript:history.go(-1)" class="aui-navBar-item">
                    <i class="icon icon-return"></i>
                </a>
                <div class="aui-center">
                    <span class="aui-center-title">个人信息</span>
                </div>
                <a href="javascript:;" class="aui-navBar-item">
                    <i class="icon icon-sys"></i>
                </a>
            </header>
            <section class="aui-scrollView">
                <div class="aui-address-box">
                    <div class="aui-address-cell-item">
                        <div class="aui-cell-name">姓名</div>
                        <div class="aui-cell-input">
                            <input type="text" class="cell-input" placeholder="输入姓名" autocomplete="off" id="name" value="${customer.customerName}">
                        </div>
                    </div>
				
				
					<!--   <div class="aui-address-cell-item">
					    <div class="aui-cell-name">账号</div>
					    <div class="aui-cell-input">
					        <input type="text" class="cell-input" placeholder="输入您的账号" autocomplete="off" >
					    </div>
					</div> -->
					
					 <div class="aui-address-cell-item">
					    <div class="aui-cell-name" >密码</div>
					    <div class="aui-cell-input">
					        <input type="text" class="cell-input" placeholder="输入您的密码" autocomplete="off" id="password" value="${customer.customerPassword}">
					    </div>
					</div>
                   <div class="aui-address-cell-item">
                      <div class="aui-cell-name" >年龄</div>
                      <div class="aui-cell-input">
                          <input type="text" class="cell-input" placeholder="输入您的年龄" autocomplete="off" id="age" value="${customer.customerAge}">
                      </div>
                  </div>
									 <div class="aui-address-cell-item">
									    <div class="aui-cell-name" >性别</div>
									    <div class="aui-cell-radio">
									   
									       <input type="radio" name="sex" value="男"  <c:if test="${customer.customerSex eq '男'}">checked</c:if> >男&nbsp;&nbsp;&nbsp;
									    		<input type="radio" name="sex" value="女" <c:if test="${customer.customerSex eq '女'}">checked</c:if> >女
									    </div>
																				</div>
			  <div class="aui-address-cell-item">
			    <div class="aui-cell-name" >联系号码</div>
			    <div class="aui-cell-input">
			        <input type="text" class="cell-input" placeholder="输入您的手机号码" autocomplete="off" id="phone" value="${customer.customerPhone}">
			    </div>
			</div>
			  <div class="aui-address-cell-item">
			    <div class="aui-cell-name" >身份证号码</div>
			    <div class="aui-cell-input">
			        <input type="text" class="cell-input" placeholder="输入您的身份证号码" autocomplete="off" id="idCard" value="${customer.idCardNo}">
			    </div>
			</div>
				
                 <div class="aui-address-btn">
					<a href="javascript:;" onclick="genxin();">保存</a> &nbsp; 
				</div>
										
                </div>
            </section>
        </section>
        <script src="${ctx}/qtCustomer/js/jquery.min.js"></script>
        <script src="${ctx}/qtCustomer/js/city.js"></script>
        <script src="${ctx}/qtCustomer/js/address.js"></script>
        <script>
        function checkPhone(phone){ 
        	
    	    if(!(/^1[34578]\d{9}$/.test(phone))){ 
    	        alert("手机号码有误，请重填");  
    	        return false; 
    	    } 
    	}
    	function isCardNo(card)  
    	{  
    	   // 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X  
    	   var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;  
    	   if(reg.test(card) === false)  
    	   {  
    	       alert("身份证输入不合法");  
    	       return  false;  
    	   }  
    	   
    	}
    	function genxin(){
    		var name = $("#name").val();
    		
    		var password = $("#password").val();
    		var age = $("#age").val();
    		var sex = $('input:radio[name="sex"]:checked').val();
    		var phone = $("#phone").val();
    		var idCard = $("#idCard").val();
    		if(phone!=null&&phone!=""){
    			checkPhone(phone);
    			
    		}else{
    			alert("手机号码不能为空");
    		}
    		
    		if(idCard!=null&&idCard!=""){
    		isCardNo(idCard);
    		}
    		var data = {
    				"customerName":name,
    				"customerPassword":password,
    				"customerAge":age,
    				"customerSex":sex,
    				"customerPhone":phone,
    				"idCardNo":idCard
    		}
    		console.log(data)
    		
    	$.post(getContextPath() + "/qtCustomer/customer/gerenUpdate.do",data,function(msg) {
			if(msg==1){
				alert("修改成功")
			}
		}) 
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
    	}
        </script>
    </body>
</html>
