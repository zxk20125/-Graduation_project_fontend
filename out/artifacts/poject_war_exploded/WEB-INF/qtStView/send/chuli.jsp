<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>处理派送</title>
<meta
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0"
	name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<link href="${ctx}/qtCustomer/css/style2.css" rel="stylesheet"
	type="text/css" />

</head>
<body>

	<section class="aui-flexView">
		<header class="aui-navBar aui-navBar-fixed b-line">
			<a href="javascript:history.go(-1)" class="aui-navBar-item"> <i
				class="icon icon-return"></i>
			</a>
			<div class="aui-center">
				<span class="aui-center-title">设置派送</span>
			</div>
			<a href="javascript:;" class="aui-navBar-item"> <i
				class="icon icon-sys"></i>
			</a>
		</header>
		<section class="aui-scrollView">
			<div class="aui-address-box">
				<div class="aui-address-cell-item">
					<div class="aui-cell-name">快递单号</div>
					<div class="aui-cell-input">
						<input type="text" class="cell-input" placeholder="输入快递单号"
							autocomplete="off" id="id" onchange="shuru();">
					</div>
				</div>
				&nbsp;
				<div class="aui-address-box">
					<div class="aui-address-cell-item">
						<div class="aui-cell-name">当前运单</div>
						<div class="aui-cell-input">
							<input type="text" class="cell-input" placeholder="(暂无运单)"
								autocomplete="off" id="waybill_id">
						</div>
					</div>
					&nbsp;
					<!-- 寄件人 -->
					<div class="aui-address-cell-item">
						<div class="aui-cell-name" style="background-color: #FFFFDD;">寄件人</div>
						<div class="aui-cell-input">
							<input type="text" class="cell-input" placeholder="暂无寄件人"
								autocomplete="off" readonly="readonly" id="jijian">
						</div>
					</div>
					<div class="aui-address-cell-item">

					<div class="aui-cell-input">
						<input type="text" class="cell-input" placeholder="暂无寄件人地址"
							autocomplete="off" id="jijiandizhi">
					</div>
				</div>
					<!-- 收件人 -->
					<div class="aui-address-cell-item">
						<div class="aui-cell-name" style="background-color: #F0F2F5;">收件人</div>
						<div class="aui-cell-input">
							<input type="text" class="cell-input" placeholder="暂无收件人"
								autocomplete="off" readonly="readonly" id="shoujian">
						</div>
					</div>
					<div class="aui-address-cell-item">
					<div class="aui-cell-input">
						<input type="text" class="cell-input" placeholder="暂无收件人地址"
							autocomplete="off" id="shoujiandizhi">
					</div>
				</div>
					&nbsp;
					<div class="aui-address-cell-item" id="reason"
						style="display: none;">
						<div style="padding: 5px">拒签原因：</div>
						<div style="padding: 5px">
							<textarea rows="5" cols="25" id="rejectReasons"></textarea>
						</div>
					</div>
					&nbsp;
					<div class="aui-address-btn">
						<a href="javascript:;" onclick="qianshou();" id="qian">签收</a> <br> 
						<a href="javascript:;" onclick="juqian();" id="ju">拒签</a><br>
								<a href="javascript:;" onclick="dojuqian();" style="display: none;" id="queren">确认</a> <br> 
						<a href="javascript:;" onclick="quxiao();" style="display: none;" id="quxiao">取消</a>
						
					</div>
	
				</div>
		</section>
	</section>

	</div>




	<script src="${ctx}/qtCustomer/js/jquery.min.js"></script>
	<script>
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
		function shuru() {
			var id = $("#id").val();
			$("#waybill_id").val(id);

			var data = {
				"id" : id
			}
			$.post(getContextPath() + "/qtStaff/logistics/order.do", data,
					function(msg) {
						$("#jijian").val(
								msg.order.sender + "(" + msg.order.senderPhone
										+ ")");
						$("#shoujian").val(
								msg.order.receiver + "("
										+ msg.order.receiverPhone + ")");
						$("#jijiandizhi").val(msg.order.senderAddress);
						$("#shoujiandizhi").val(msg.order.receivingAddress);
					})

		}
		function qianshou() {
			var wId = $("#waybill_id").val();
			console.log(wId)
			var data = {
				"waybillId" : wId
			}
			$.post(getContextPath() + "/qtStaff/send/qianshou.do", data,
					function(msg) {
						if (msg == 1) {
							alert("设置成功");
							$("#id").val("");
							$("#waybill_id").val("");
							$("#jijian").val("");
							$("#shoujian").val("");
							$("#jijiandizhi").val("");
							$("#shoujiandizhi").val("");
						}else if(msg==2){
							alert("没设置派送！")
						}
					})
		}

		function juqian() {
			$("#reason").show();
			$("#qian").hide();
			$("#ju").hide();
			$("#queren").show();
			$("#quxiao").show();
		}

		function quxiao(){
			$("#reason").hide();
			$("#qian").show();
			$("#ju").show();
			$("#queren").hide();
			$("#quxiao").hide();
		}
		
		function dojuqian() {
			var wId = $("#waybill_id").val();
			var rejectReasons = $("#rejectReasons").val();
			console.log(wId)
			var data = {
				"waybillId" : wId,
				"rejectReasons":rejectReasons
			}
			$.post(getContextPath() + "/qtStaff/send/juqian.do", data,
					function(msg) {
						if (msg == 1) {
							alert("设置成功");
							$("#id").val("");
							$("#waybill_id").val("");
							$("#jijian").val("");
							$("#shoujian").val("");
							var rejectReasons = $("#rejectReasons").val("");
							$("#reason").hide();
							$("#qian").show();
							$("#ju").show();
							$("#queren").hide();
							$("#quxiao").hide();
						}else if(msg==2){
							alert("没设置派送！")
						}
					})
		}

		window.alert = function(name) {
			var iframe = document.createElement("IFRAME");
			iframe.style.display = "none";
			iframe.setAttribute("src", 'data:text/plain,');
			document.documentElement.appendChild(iframe);
			window.frames[0].window.alert(name);
			iframe.parentNode.removeChild(iframe);
		};

		window.confirm = function(message) {
			var iframe = document.createElement("IFRAME");
			iframe.style.display = "none";
			iframe.setAttribute("src", 'data:text/plain,');
			document.documentElement.appendChild(iframe);
			var alertFrame = window.frames[0];
			var result = alertFrame.window.confirm(message);
			iframe.parentNode.removeChild(iframe);
			return result;
		};
	</script>
</body>
</html>
