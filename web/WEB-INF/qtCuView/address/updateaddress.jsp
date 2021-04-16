<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑地址</title>
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
				<span class="aui-center-title">编辑地址</span>
			</div>
			<!-- <a href="javascript:;" class="aui-navBar-item">
                    <i class="icon icon-sys"></i>
                </a> -->
		</header>
		<section class="aui-scrollView">
			<div class="aui-address-box">
				<div class="aui-address-cell-item">
					<div class="aui-cell-name">姓名</div>
					<div class="aui-cell-input">
						<input type="hidden" id="address_id" value="${address.addressId}">
						<input type="text" id="name" class="cell-input"
							placeholder="请输入姓名" autocomplete="off"
							value="${address.addressName}">
					</div>
				</div>
				<div class="aui-address-cell-item">
					<div class="aui-cell-name">联系手机</div>
					<div class="aui-cell-input">
						<input type="text" class="cell-input" id="phone"
							placeholder="收件人电话号码" autocomplete="off" value="${address.phone}">
					</div>
				</div>
				<div class="aui-address-cell-item">
					<div class="aui-cell-name">所在地区</div>
					<div class="aui-cell-input cell-input-text">
						<input type="text" class="cell-input" readonly id="J_Address"
							placeholder=""
							value="${fn:substring(address.address, 0, 3)}${fn:substring(address.address, 3, 6)}${fn:substring(address.address, 6, 10)}">
					</div>
				</div>
				<div class="aui-address-cell-item">
					<div class="aui-cell-name">详细地址</div>
					<div class="aui-cell-input">
						<input type="text" class="cell-input" id="ad"
							placeholder="发票寄送的详细地址信息" autocomplete="off"
							value="${fn:substring(address.address, 10,-1)}">
					</div>
				</div>
				<!--  <div class="aui-address-cell-item">
                        <div class="aui-cell-name">邮政编号</div>
                        <div class="aui-cell-input">
                            <input type="text" class="cell-input" placeholder="邮政编码号" autocomplete="off">
                        </div>
                    </div> -->
				<div class="aui-address-btn">
					<a href="javascript:;" onclick="doupdate();">保存</a>
				</div>
				<div class="aui-address-btn">
					<a href="javascript:;" onclick="dodelete();"
						style="background: #F75000;">删除</a>
				</div>
			</div>
		</section>
	</section>
	<script src="${ctx}/qtCustomer/js/jquery.min.js"></script>
	<script src="${ctx}/qtCustomer/js/city.js"></script>
	<script src="${ctx}/qtCustomer/js/address.js"></script>
	<script>
		/**
		 * 默认调用
		 */
		!function() {
			var $target = $('#J_Address');

			$target.citySelect();

			$target.on('click', function(event) {
				event.stopPropagation();
				$target.citySelect('open');
			});

			$target.on('done.ydui.cityselect', function(ret) {
				$(this).val(ret.provance + ' ' + ret.city + ' ' + ret.area);
			});
		}();
		/**
		 * 设置默认值
		 */
	</script>

	<script type="text/javascript">
		function doupdate() {
			var address_id = $("#address_id").val();
			var name = $("#name").val();
			var phone = $("#phone").val();
			var address = $("#J_Address").val() + $("#ad").val();

			var data = {
				"addressId" : address_id,
				"addressName" : name,
				"phone" : phone,
				"address" : address
			}

			$.post(getContextPath() + "/qtCustomer/address/doupdate.do", data,
					function(msg) {
						if (msg == 1) {
							alert("修改成功！");
							window.location.href = getContextPath()
									+ "/qtCustomer/address/list.do"
						}
					})

		}

		function dodelete() {
			var address_id = $("#address_id").val();
			var addressId = {
					"addressId":address_id
			}
			$.post(getContextPath() + "/qtCustomer/address/dodelete.do", addressId,
					function(msg) {
				if(msg==1){
					alert("删除成功！");
					window.location.href = getContextPath()
							+ "/qtCustomer/address/list.do"
				}
					});
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
	</script>
</body>
</html>

