<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<title>寄件</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes" />
<link href="${ctx}/qtCustomer/css/style4.css" rel="stylesheet"
	type="text/css" />
<meta name="full-screen" content="yes">
<meta name="browsermode" content="application">
<meta name="x5-fullscreen" content="true">
<meta name="x5-page-mode" content="app">

<link rel="stylesheet" type="text/css"
	href="${ctx}/qtCustomer/css/lxs_index.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/qtCustomer/css/lxsHeadFoot.css">
<link href="${ctx}/qtCustomer/css/style3.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/qtCustomer/css/order_new.css" />
<script src="${ctx}/qtCustomer/js/jquery-2.1.4.min.js"></script>
<script src="${ctx}/qtCustomer/js/lxs_index00.js"></script>
<script></script>

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

	<div class="content" id="orderhead">
		<div class="headTop">
			<a href="javascript:history.go(-1)" class="back"><i
				class="iconBack"></i></a><span>订单填写</span>
			<!-- <a class="more"><i
				class="iconDian"></i><i class="iconDian"></i><i class="iconDian"></i></a> -->
		</div>
	</div>


	<div class="j_main m-main" id="orderform">

		<form action="" method="post" name="form_1">

			<div class="tit">
				<i></i>填写物品信息
			</div>
			<div class="txt">
				<dl class="J_price">
					<dt>重量预计</dt>
					<dd class="box-flex-1 price pd0" id="adult_price_span">
					<!-- 	<span>￥ <span id="price_d">2</span>/Kg
						</span> -->
					</dd>
					<dd class="box-flex-2">
						<span class="subadd j_num"><span class="sub"
							data-type="adults"></span> <input id="j_price_d_num"
							type="number" min="1" max="25" class="text_num" value="1" readonly="readonly"
							name="adult_num"> <span class="add" data-type="adults"></span></span>
					</dd>
				</dl>
				<dl class="J_price">
					<dt>物品类别</dt>
					<dd>
						<!-- <input maxlength="20" type="text" name="truename" class="o_text"
							placeholder="请填写货物类别" value=""> -->

						<select class="leibie" id="resSort">

						</select>
					</dd>
				</dl>
			</div>
			<div class="tit">
				<i></i>是否保价
				<select class="leibie" id="insrued_price">
					<option value="1">是</option>
					<option value="0">否</option>

				</select>
			</div>
			<div class="tit">
				<i></i>支付方式
				<select class="leibie" id="payment_method">
					<option value="在线支付">在线支付</option>
					<option value="货到付款">货到付款</option>
					<option value="线下支付">线下支付</option>
				</select>
			</div>

			<!-- <div class="txt txt2 J_baoxian"></div> -->
			<script type="text" id="j_baoxian_con"> <dl> <dt> <a href="javascript:;" class="j_baoxian_tit J_baoxian_info">*title*</a> <input type="hidden" name="*name1*" value="*id*" /> <input type="hidden" name="*name2*" value="*price*" /> </dt> <dd> <font><span class="j_baoxian_c">*price_c*</span><i class="more"></i></font> </dd> </dl> </script>
			<script></script>
			<div class="tit">
				<i></i>填写寄件人信息<span style="float: right; color: orange;"
					onclick="jijiandizhi();">地址簿&nbsp;></span>
			</div>

			<div class="txt">
				<dl>
					<dt>寄件人</dt>
					<dd>
						<input maxlength="20" type="text" name="truename" class="o_man"
							placeholder="真实姓名（必填）" value="" id="sender">
					</dd>
				</dl>
				<dl>
					<dt>寄件地址</dt>
					<dd>
						<input type="text" name="truename" class="o_addr" placeholder=""
							value="" id="sender_address">
					</dd>
				</dl>
				<dl>
					<dt>手机号码</dt>
					<dd class="pd0">
						<input type="tel" name="mobiletel" id="n_mobiletel"
							class="o_number" maxlength="11" placeholder="手机号码（必填）" value="">
					</dd>
					</dd>
				</dl>

			</div>
			<div class="tit">
				<i></i>填写收件人信息<span style="float: right; color: orange;"
					onclick="shoujiandizhi();">地址簿&nbsp;></span>
			</div>
			<div class="txt">
				<dl>
					<dt>收件人</dt>
					<dd>
						<input maxlength="20" type="text" name="truename" class="o_man"
							placeholder="真实姓名（必填）" value="" id="receiver">
					</dd>
				</dl>
				<dl>
					<dt>收件地址</dt>
					<dd>
						<input maxlength="20" type="text" name="truename" class="o_addr"
							placeholder="" value="" id="receiver_address">
					</dd>
				</dl>
				<dl>
					<dt>手机号码</dt>
					<dd class="pd0">
						<input type="tel" name="mobiletel" id="receiver_phone"
							class="o_number" maxlength="11" placeholder="手机号码（必填）" value="">
					</dd>
				</dl>

			</div>

			<div class="tit">
				<i></i>备注
			</div>
			<div class="aui-view-box">
				<div class="aui-view-box-item">
					<textarea id="remarks" placeholder="可选择性输入"></textarea>
				</div>
			</div>
			<script type="text" id="j_kehu_c"> <dl class="j_kehu_open"> <dt> <span>游客*i*</span> <div class="none"> <input maxlength="20" type="hidden" class="o_man tourist_name" name="insurance_username[]" placeholder="游客姓名（必填）"> <input type="hidden" class="o_man tourist_phone_number" name="phone_number[]" placeholder="手机号码（选填）"> <input type="hidden" class="o_man tourist_identity_card" name="idcard_no[]" placeholder="身份证号码（必填）">  </div> </dt> <dd> <font class="corBlue"><span>填写信息</span><i class="more fr"></i></font> </dd> </dl> </script>
			<script></script>

			<div class="booking_notes">
				<label><i class="on"></i>我已阅读并同意</label><a href="javascript:;"
					class="btn_notes">服务协议</a>
				<p>温馨提示：为了保障您的权益，请务必在线支付订单。</p>
			</div>
		</form>
		<div class="submintFix">
			<dl>
				<dt>
					<div class="price">
						<!-- 订单总额 <span>￥<em class="j_all_money">620</em></span> -->
						目前只开放广东 广州市
					</div>
				</dt>
				<dd class="sbmFix">
					<button type="button" onclick="xiadan();">提交订单</button>
				</dd>
			</dl>
		</div>
	</div>

	<!-- 寄件地址 -->
	<div class="content" id="addresshead">
		<div class="headTop">
			<a href="javascript:history.go(-1)" class="back"><i
				class="iconBack"></i></a><span>订单填写</span> <a
				href="${ctx}/qtCustomer/address/insert.do?customerId=${customer.customerId}"
				class="more" style="color: white;"><h2>添加</h2></a>
			<%-- <a href="${ctx}/qtCustomer/address/insert.do?customerId=${customer.customerId}" class="aui-navBar-item">
				<h1>添加</h1>
			</a> --%>
		</div>
	</div>

	<section class="aui-scrollView" id="addresschoose">
		<div class="aui-tab">
			<div class="divHeight"></div>
			<div class="tab-panel">
				<div class="tab-panel-item tab-active">

					<c:if test="${addresss eq 'null'}">
						<center>没有地址</center>
					</c:if>
					<c:if test="${addresss ne 'null'}">
						<c:forEach items="${addresss}" var="address">

							<div class="tab-item">
								<%-- href="${ctx}/qtCustomer/address/update.do?addressId=${address.addressId}" --%>
								<span class="aui-well-item aui-well-item-clear"
									style="background: white;">
									<div class="aui-well-item-bd">
										<b>${address.addressName}</b> ${address.phone}
										<p>${fn:substring(address.address, 0, 3)}${fn:substring(address.address, 3, 7)}${fn:substring(address.address, 7, -1)}</p>
									</div> <span style="float: right; color: orange;"> <a
										href="${ctx}/qtCustomer/address/update.do?addressId=${address.addressId}">编辑</a>
										&nbsp;|&nbsp; <span
										onclick="sender('${address.addressName}','${address.address}','${address.phone}');">选择</span>
								</span>
								</span>

							</div>

							<div class="divHeight"></div>

							<div class="tab-item"></div>

						</c:forEach>
					</c:if>


				</div>

			</div>
		</div>


	</section>
	<!-- end -->
	<!-- 收件地址 -->
	<div class="content" id="shoujianaddresshead">
		<div class="headTop">
			<a href="javascript:history.go(-1)" class="back"><i
				class="iconBack"></i></a><span>订单填写</span> <a
				href="${ctx}/qtCustomer/address/insert.do?customerId=${customer.customerId}"
				class="more" style="color: white;"><h2>添加</h2></a>
			<%-- <a href="${ctx}/qtCustomer/address/insert.do?customerId=${customer.customerId}" class="aui-navBar-item">
				<h1>添加</h1>
			</a> --%>
		</div>
	</div>


	<section class="aui-scrollView" id="shoujianaddresschoose">
		<div class="aui-tab">
			<div class="divHeight"></div>
			<div class="tab-panel">
				<div class="tab-panel-item tab-active">

					<c:if test="${addresss eq 'null'}">
						<center>没有地址</center>
					</c:if>
					<c:if test="${addresss ne 'null'}">
						<c:forEach items="${addresss}" var="address">

							<div class="tab-item">
								<%-- href="${ctx}/qtCustomer/address/update.do?addressId=${address.addressId}" --%>
								<span class="aui-well-item aui-well-item-clear"
									style="background: white;">
									<div class="aui-well-item-bd">
										<b>${address.addressName}</b> ${address.phone}
										<p>${fn:substring(address.address, 0, 3)}${fn:substring(address.address, 3, 7)}${fn:substring(address.address, 7, -1)}</p>
									</div> <span style="float: right; color: orange;"> <a
										href="${ctx}/qtCustomer/address/update.do?addressId=${address.addressId}">编辑</a>
										&nbsp;|&nbsp; <span
										onclick="receiver('${address.addressName}','${address.address}','${address.phone}');">选择</span>
								</span>
								</span>

							</div>

							<div class="divHeight"></div>

							<div class="tab-item"></div>

						</c:forEach>
					</c:if>


				</div>

			</div>
		</div>


	</section>

	<!-- end -->
	<script type="text/javascript" src="${ctx}/qtCustomer/script/aui-dialog.js" ></script>
	<script src="${ctx}/qtCustomer/js/jquery.min.js"></script>
	<script src="${ctx}/qtCustomer/js/min_com.js"></script>
	<script src="${ctx}/qtCustomer/js/order_xianlu.js"></script>
	<script type="text/javascript">
		window.onload = function() {
			$("#addresschoose").hide();
			$("#addresshead").hide();
			$("#shoujianaddresschoose").hide();
			$("#shoujianaddresshead").hide();
			var selectOption = "";
			/* selectOption += "<option value='其他'>无</option>"; */
			$.get(getContextPath() + "/qtCustomer/resSort/list.do", function(
					msg) {
				$.each(msg, function(i, val) {
					// alert(n+" --"+JSON.stringify(value));
					selectOption += "<option value="+val.resSort+">"
							+ val.resSort + "</option>"
					/* console.log(val.resSort) */
				});
				$('#resSort').html(selectOption);

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
	</script>
	<script>
		function mobiletel_code_check() {
			var ajax_url = '/order/checkCode', code = $('input[name="code"]')
					.val(), mobiletel = $('input[name="mobiletel"]').val();
			if (mobiletel == '') {
				alert('请输入手机号码');
				return false;
			} else if (!checkMobile(mobiletel)) {
				alert('请输入正确的手机号码');
				return false;
			} else if (code == '' || code.length != 6) {
				alert('请输入6位验证码');
				return false;
			}
			$('#save').addClass('not');
			$.ajax({
				url : ajax_url,
				type : 'post',
				data : {
					mobiletel : mobiletel,
					code : code,
					inajax : 1
				},
				dataType : 'json',
				success : function(data) { /*console.log(data);*/
					if (data == '1') {
						alert('手机验证完毕');
						document.form_1.submit();
					} else {
						$('#save').removeClass('not');
						if (data == '-1') {
							alert('手机号码错误');
							return false;
						} else if (data == '-2') {
							alert('验证码错误');
							return false;
						} else {
							alert('意外错误');
							return false;
						}
					}
				},
				error : function() {
					$('#save').removeClass('not');
					alert('意外错误');
					return false
				}
			});
		}
		$(function() { /*表单提交*/
			$('#save')
					.click(
							function(e) {
								e.stopPropagation();
								if ($('#save').hasClass('not'))
									return false;
								var uid = parseInt($("#uid").val()); /*检测游客填写的身份信息*/
								if (!tourist_check()) {
									return false;
								}
								var true_name = $('input[name="truename"]')
										.val(), mobiletel = $(
										'input[name="mobiletel"]').val();
								if (true_name == '') {
									alert('联系人为必须填写项');
									return false;
								} else if (true_name.length < 2) {
									alert('联系人过短，请重新输入');
									return false;
								} else if (true_name.length > 10) {
									alert('联系人长度仅限10个字符，请重新输入');
									return false;
								} else if (mobiletel == '') {
									alert('手机号码为必须填写项');
									return false;
								} else if (mobiletel.length != 11
										|| !mobiletel_regexp.test(mobiletel)) {
									alert('手机号码不正确，请重新输入');
									return false;
								}
								if (!$('.booking_notes i').hasClass('on')) {
									alert('请阅读并同意此产品的预订须知');
									return false;
								}
								if (uid == 0) {
									mobiletel_code_check();
								} else {
									$('#save').addClass('not');
									document.form_1.submit();
								}
							}); /*发送手机验证码*/
			$(".mobile_code")
					.click(
							function() {
								var th = $(this), tel = $("#n_mobiletel").val(), r_url = '/account/getcode?inajax=1&mobiletel='
										+ tel + '&idtype=4';
								if (tel == '') {
									alert('请先输入手机号码');
									return false;
								}
								if (tel.length != 11
										|| !mobiletel_regexp.test(tel)) {
									alert('手机号码不正确，请您重新输入');
									return false
								}
								if (th.hasClass('not')) {
									return false;
								}
								th.addClass('not');
								setTimeout(function() {
									th.removeClass('not');
								}, 60000);
								$.get(r_url, function(data) {
									if (data == '1') {
										alert('短信已发送，请查看');
									} else if (data == '-1') {
										alert('获取失败，手机号码不能为空');
									} else if (data == '-2') {
										alert('获取失败，手机号码错误');
									} else if (data == '-3') {
										alert('获取失败，该手机已被注册');
									} else if (data == '-4') {
										alert('您的操作太频繁，请稍候再试');
									} else if (data == '-8') {
										alert('同一ip一天最多10条短信');
									} else if (data == '-5') {
										alert('同一手机一个月最多5条短信');
									} else if (data == '-6') {
										alert('获取失败，获取验证时间间隔60秒');
									} else {
										alert('获取失败');
									}
								});
							}); /*改变证件类型事件*/
			$('#j_kehu_list').on(
					'change',
					'.tourist_box .certificate_type',
					function() {

						placeholder = mark + '号码（必填）';
						cur.closest('dl').next('dl').find('dt').html(mark)
								.siblings('dd').find('input[type="text"]')
								.attr('placeholder', placeholder);
					});
		});

		function guoqing_yh() {

		}
	</script>
	
	<script type="text/javascript">
		function jijiandizhi() {
			$("#orderform").hide()
			$("#orderhead").hide()
			$("#addresshead").show()
			$("#addresschoose").show();
			/* var weight = $("#j_price_d_num").val()
			var sort = $('#resSort option:selected').val();
			var insrued_price = $("#insrued_price").val();
			 
			console.log(weight)
			console.log(sort)
			console.log(insrued_price) */
		}

		function sender(aadressName, address, phone) {
			/* 	console.log(aadressName)
				console.log(address)
				console.log(phone) */
			$("#orderform").show();
			$("#orderhead").show()
			$("#addresshead").hide()
			$("#addresschoose").hide();
			$("#sender").val(aadressName)
			$("#sender_address").val(address)
			$("#n_mobiletel").val(phone)
		}
	</script>
	<script type="text/javascript">
		function shoujiandizhi() {
			$("#orderform").hide()
			$("#orderhead").hide()
			$("#shoujianaddresshead").show()
			$("#shoujianaddresschoose").show();
			var weight = $("#j_price_d_num").val()
			var sort = $('#resSort option:selected').val();
			var insrued_price = $("#insrued_price").val();
			/*  
			console.log(weight)
			console.log(sort)
			console.log(insrued_price) */
		}
		function receiver(aadressName, address, phone) {
			/* console.log(aadressName)
			console.log(address)
			console.log(phone) */
			$("#orderform").show();
			$("#orderhead").show()
			$("#shoujianaddresshead").hide()
			$("#shoujianaddresschoose").hide();
			$("#receiver").val(aadressName)
			$("#receiver_address").val(address)
			$("#receiver_phone").val(phone)
		}
	</script>
	<script type="text/javascript">
		function xiadan() {
			var weight = $("#j_price_d_num").val()
			var sort = $('#resSort option:selected').val();
			var insrued_price = $("#insrued_price").val();
			var sender = $("#sender").val();
			var sender_address = $("#sender_address").val();
			var sender_phone = $("#n_mobiletel").val();
			var receiver = $("#receiver").val();
			var receiver_address = $("#receiver_address").val();
			var receiver_phone = $("#receiver_phone").val();
			var remarks = $("#remarks").val();
			var payment_method = $("#payment_method").val();
			/* console.log(weight);
			console.log(sort);
			console.log(insrued_price);
			console.log(sender);
			console.log(sender_address);
			console.log(sender_phone);
			console.log(receiver);
			console.log(receiver_address);
			console.log(receiver_phone); */

			//手机号码校验
			if (!(/^1[34578]\d{9}$/.test(sender_phone))) {
				alert("手机号码有误，请重填");
				return false;
			}
			if (!(/^1[34578]\d{9}$/.test(receiver_phone))) {
				alert("手机号码有误，请重填");
				return false;
			}

			var data = {
				"weight" : weight,
				"resSort" : sort,
				"insuredPrice" : insrued_price,
				"sender" : sender,
				"senderAddress" : sender_address,
				"senderPhone" : sender_phone,
				"receiver" : receiver,
				"receivingAddress" : receiver_address,
				"receiverPhone" : receiver_phone,
				"paymentMethod":payment_method
			}
			console.log(data)
			$.post(getContextPath() + "/qtCustomer/jijian/yunfei.do", data,
					function(msg) {
						console.log(msg)
						var cf = confirm("运费"+msg+"元，是否继续");
						if(cf){
							data.newParam = 'freight';
							data.freight = msg;
							console.log(data)
							//下单
							$.post(getContextPath() + "/qtCustomer/jijian/xiadan.do", data,function(msg) {
								if(msg==1){
									alert("下单成功");
									setTimeout(window.location.href=getContextPath()+"/qtCustomer/customer/index.do",6000);
								}else if(msg==0){
									alert("寄出地址与收件地址需同城！")
								}
							})
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
</body>
</html>