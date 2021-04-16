<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新物流</title>
<meta
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0"
	name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<link href="${ctx}/qtCustomer/css/style2.css" rel="stylesheet"
	type="text/css" />
<style type="text/css">
.leibie {
	/*  display: inline-block;
    text-decoration: none;
    height: 40px;
    text-align: center;
    line-height: 40px;
	overflow: hidden; */
	display: inline;
	min-width: 160px;
	padding: 12px 16px;
	z-index: 1;
	border-style: hidden;
	appearance: none;
	-moz-appearance: none;
	-webkit-appearance: none;
}
</style>
</head>
<body>

	<section class="aui-flexView">
		<header class="aui-navBar aui-navBar-fixed b-line">
			<a href="javascript:history.go(-1)" class="aui-navBar-item"> <i
				class="icon icon-return"></i>
			</a>
			<div class="aui-center">
				<span class="aui-center-title">更新物流</span>
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
							autocomplete="off" onchange="shuru();" id="id">
					</div>
				</div>
				&nbsp;
				<div class="aui-address-cell-item">
					<div class="aui-cell-name">当前运单</div>
					<div class="aui-cell-input">
						<input type="text" class="cell-input" placeholder="(暂无订单)"
							autocomplete="off" id="waybill_id" readonly="readonly">
					</div>
				</div>
				&nbsp;
				<!-- 寄件人 -->
				<div class="aui-address-cell-item">
					<div class="aui-cell-name" style="background-color: #FFFFDD;">寄件人</div>
					<div class="aui-cell-input">
						<input type="text" class="cell-input" placeholder="暂无寄件人"
							autocomplete="off" id="jijian">
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
							autocomplete="off" id="shoujian">
					</div>
				</div>
				<div class="aui-address-cell-item">
					<div class="aui-cell-input">
						<input type="text" class="cell-input" placeholder="暂无收件人地址"
							autocomplete="off" id="shoujiandizhi">
					</div>
				</div>
				<p style="font-size: 20px; margin: 3%;">选项</p>
				<div class="aui-address-cell-item">
					<div class="aui-cell-name">物流更新类型</div>
					<div class="aui-cell-input cell-input-text">
						<select class="leibie" id="ty">
							<option value="收入">收入</option>
							<option value="发出">发出</option>
						</select>
					</div>

				</div>
				
				<div class="aui-address-cell-item">
					<div class="aui-cell-name">起始网点名称</div>
					<div class="aui-cell-input cell-input-text">
						<!-- <input type="text" class="cell-input" readonly id="J_qswd"
							placeholder="东莞新寮步"> -->
						<select class="leibie" id="start">
						</select>
					</div>
				</div>
				
				<div class="aui-address-cell-item">
					<div class="aui-cell-name">目标网点名称</div>
					<div class="aui-cell-input cell-input-text">
						<!-- <input type="text" class="cell-input" readonly id="J_mbaddress"
							placeholder="请选择网点"> -->
						<select class="leibie" id="end">
						</select>
					</div>
				</div>

				<div class="aui-address-btn">
					<a href="javascript:;" onclick="newlogistics();">更新物流</a>
				</div>
			</div>
		</section>
	</section>
	<script src="${ctx}/qtCustomer/js/jquery.min.js"></script>
	<script src="${ctx}/qtCustomer/js/city.js"></script>
	<script src="${ctx}/qtCustomer/js/address.js"></script>

	<script type="text/javascript">
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
		window.onload = function() {
			var selectOption = "";
			$.get(getContextPath() + "/qtStaff/logistics/dot.do",
					function(msg) {
						$.each(msg, function(i, val) {
							// alert(n+" --"+JSON.stringify(value));
							selectOption += "<option value="+val.dotId+">"
									+ val.dotName + "</option>"
							/* console.log(val.resSort) */
						});
						$('#start').html(selectOption);
						$('#end').html(selectOption);

					})
		}
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

		function newlogistics() {
			var waybill_id = $("#waybill_id").val();
			var logisticsType = $("#ty option:selected").val();
			var start = $("#start option:selected").text();
			var end = $("#end option:selected").text();
			var data = {
				"waybillId" : waybill_id,
				"logisticsType" : logisticsType,
				"startDotName" : start,
				"targetDotName" : end
			}
			/* console.log(data) */
			$.post(getContextPath() + "/qtStaff/logistics/donew.do", data,
					function(msg) {
						console.log(msg)
						if (msg == 1) {
							alert("更新成功");
							$("#id").val("");
							$("#waybill_id").val("");
							$("#jijian").val("");
							$("#shoujian").val("");
							$("#jijiandizhi").val("");
							$("#shoujiandizhi").val("");
						}
					})
		}
	</script>
</body>
</html>
