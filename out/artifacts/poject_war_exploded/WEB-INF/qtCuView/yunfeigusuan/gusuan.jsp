<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<title>运费预估</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="full-screen" content="yes">
<meta name="browsermode" content="application">
<meta name="x5-fullscreen" content="true">
<meta name="x5-page-mode" content="app">
<link rel="stylesheet" type="text/css"
	href="${ctx}/qtCustomer/css/lxs_index.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/qtCustomer/css/lxsHeadFoot.css">
<link rel="stylesheet" type="text/css"
	href="${ctx}/qtCustomer/css/order_new.css" />
<script src="${ctx}/qtCustomer/js/jquery-2.1.4.min.js"></script>
<script src="${ctx}/qtCustomer/js/lxs_index00.js"></script>
<link href="${ctx}/qtCustomer/css/style2.css" rel="stylesheet"
	type="text/css" />
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

	<div class="content">
		<div class="headTop">
			<a href="javascript:history.go(-1)" class="back"><i
				class="iconBack"></i></a><span>运费预估</span><a class="more"><i
				class="iconDian"></i><i class="iconDian"></i><i class="iconDian"></i></a>
		</div>
	</div>


	<div class="j_main m-main">

		<form action="" method="post" name="form_1">

			<div class="tit">
				<i></i>填写物品信息(目前只开放广东广州)
			</div>
			<div class="txt">
				<dl class="J_price">
					<dt>重量预计</dt>
					<dd class="box-flex-1 price pd0" id="adult_price_span">
					<!-- 
						<span>￥ <span id="price_d">续重2</span>/Kg
						(首重￥5)
						</span> -->
					</dd>
					<dd class="box-flex-2">
						<span class="subadd j_num"> <span class="sub"
							data-type="adults" onclick="yunfeisub();"></span> <input
							id="j_price_d_num" type="number" min="0" max="25" readonly="readonly"
							class="text_num" value="0" name="adult_num"> <span
							class="add" data-type="adults" id="add" onclick="yunfeiadd();">
						</span>
						</span>
					</dd>
				</dl>
				<dl class="J_price">
					<dt>物品类别</dt>
					<dd>
						<!-- 下拉框 -->
						<select class="leibie" id="resSort" onchange="yunfei();">
							<!-- <option value="volvo">Volvo</option>
				<option value="saab">Saab</option>
				<option value="opel">Opel</option>
				<option value="audi">Audi</option> -->
						</select>
						<!-- <input maxlength="20" type="text" name="truename" class="o_text" placeholder="请填写货物类别" value=""> -->
					</dd>
				</dl>
				<dl>

					<dt>寄件地址</dt>
					<div class="aui-cell-input cell-input-text">
						<input type="text" class="cell-input" readonly id="J_Address"
							placeholder="请选择">

					</div>
				</dl>
				<dl>

					<dt>收件地址</dt>
					<div class="aui-cell-input cell-input-text">
						<input type="text" class="cell-input" readonly id="J_Address1"
							placeholder="请选择">

					</div>
				</dl>
			</div>

			<div class="txt txt2 J_baoxian"></div>
			<script type="text" id="j_baoxian_con"> <dl> <dt> <a href="javascript:;" class="j_baoxian_tit J_baoxian_info">*title*</a> <input type="hidden" name="*name1*" value="*id*" /> <input type="hidden" name="*name2*" value="*price*" /> </dt> <dd> <font><span class="j_baoxian_c">*price_c*</span><i class="more"></i></font> </dd> </dl> </script>
			<script></script>

			<script type="text" id="j_kehu_c"> <dl class="j_kehu_open"> <dt> <span>游客*i*</span> <div class="none"> <input maxlength="20" type="hidden" class="o_man tourist_name" name="insurance_username[]" placeholder="游客姓名（必填）"> <input type="hidden" class="o_man tourist_phone_number" name="phone_number[]" placeholder="手机号码（选填）"> <input type="hidden" class="o_man tourist_identity_card" name="idcard_no[]" placeholder="身份证号码（必填）">  </div> </dt> <dd> <font class="corBlue"><span>填写信息</span><i class="more fr"></i></font> </dd> </dl> </script>
			<script></script>

		</form>
		<div class="submintFix">
			<dl>
				<dt>
					<div class="price" style="margin-left: 20%; font-size: 30px;">

						<!--  <b>运费预估</b>  -->
						<span><b><input type="text" disabled="disabled"
								value="运费预估￥0" id="money"></b></span>
					</div>
				</dt>
				<!-- <dd class="sbmFix"><button type="button" id="save">提交订单</button></dd> -->
			</dl>
		</div>
	</div>

	<script src="${ctx}/qtCustomer/js/jquery.min.js"></script>
	<script src="${ctx}/qtCustomer/js/city.js"></script>
	<script src="${ctx}/qtCustomer/js/address.js"></script>
	<script src="${ctx}/qtCustomer/js/min_com.js"></script>
	<script src="${ctx}/qtCustomer/js/order_xianlu.js"></script>
	<script>
		/* $(function(){  
			
			$("#j_price_d_num").bind('input propertychange', function() {  
				var weight = $("#j_price_d_num").val();
				console.log()
			}); 
		  
		}) */
		function yunfei() {
			var weight = $("#j_price_d_num").val();
			var resSort = $("#resSort").find("option:selected").val();
			var sad = $("#J_Address").val();
			var ead = $("#J_Address1").val();
			console.log("重量：" + weight)
			console.log("类别：" + resSort)
			console.log("寄出地址：" + sad)
			console.log("收件地址：" + ead)

			var data = {
				"weight" : weight,
				"resSort" : resSort,
				"sad" : sad,
				"ead" : ead
			}

			$.post(getContextPath() + "/qtCustomer/freight/gusuan.do", data,
					function(msg) {
						/* var item = "<b>运费预估</b><span>￥<b>"+msg+"</b></span></p>"
						$("#money").append(item) */
						if(msg!=="0"){
							$("#money").val("运费预估￥"+ msg)
						}
					})
		}

		function yunfeiadd() {
			var weight = $("#j_price_d_num").val();
			weight++;
			var resSort = $("#resSort").find("option:selected").val();
			var sad = $("#J_Address").val();
			var ead = $("#J_Address1").val();
			/* console.log("重量："+weight)
			console.log("类别："+resSort)
			console.log("寄出地址："+sad)
			console.log("收件地址："+ead) */

			var data = {
				"weight" : weight,
				"resSort" : resSort,
				"sad" : sad,
				"ead" : ead
			}

			$.post(getContextPath() + "/qtCustomer/freight/gusuan.do", data,
					function(msg) {
						/* var item = "<b>运费预估</b><span>￥<b>"+msg+"</b></span></p>"
						$("#money").append(item) */
						$("#money").val("运费预估￥" + msg)
					})
		}

		function yunfeisub() {
			var weight = $("#j_price_d_num").val();
			weight--;
			var resSort = $("#resSort").find("option:selected").val();
			var sad = $("#J_Address").val();
			var ead = $("#J_Address1").val();
			/* console.log("重量："+weight)
			console.log("类别："+resSort)
			console.log("寄出地址："+sad)
			console.log("收件地址："+ead) */

			var data = {
				"weight" : weight,
				"resSort" : resSort,
				"sad" : sad,
				"ead" : ead
			}

			$.post(getContextPath() + "/qtCustomer/freight/gusuan.do", data,
					function(msg) {
						/* var item = "<b>运费预估</b><span>￥<b>"+msg+"</b></span></p>"
						$("#money").append(item) */
						$("#money").val("运费预估￥" + msg)
					})
		}

		window.onload = function() {

			var selectOption = "";
			selectOption += "<option></option>";
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
				var weight = $("#j_price_d_num").val();
				var resSort = $("#resSort").find("option:selected").val();
				var sad = $("#J_Address").val();
				var ead = $("#J_Address1").val();
				console.log("重量：" + weight)
				console.log("类别：" + resSort)
				console.log("寄出地址：" + sad)
				console.log("收件地址：" + ead)

				var data = {
					"weight" : weight,
					"resSort" : resSort,
					"sad" : sad,
					"ead" : ead
				}

				$.post(getContextPath() + "/qtCustomer/freight/gusuan.do",
						data, function(msg) {
							/* var item = "<b>运费预估</b><span>￥<b>"+msg+"</b></span></p>"
							$("#money").append(item) */
							$("#money").val("运费预估￥" + msg)
						})
			});
		}();

		!function() {
			var $target = $('#J_Address1');

			$target.citySelect();

			$target.on('click', function(event) {
				event.stopPropagation();
				$target.citySelect('open');
			});

			$target.on('done.ydui.cityselect', function(ret) {
				$(this).val(ret.provance + ' ' + ret.city + ' ' + ret.area);
				var weight = $("#j_price_d_num").val();
				var resSort = $("#resSort").find("option:selected").val();
				var sad = $("#J_Address").val();
				var ead = $("#J_Address1").val();
				console.log("重量：" + weight)
				console.log("类别：" + resSort)
				console.log("寄出地址：" + sad)
				console.log("收件地址：" + ead)

				var data = {
					"weight" : weight,
					"resSort" : resSort,
					"sad" : sad,
					"ead" : ead
				}

				$.post(getContextPath() + "/qtCustomer/freight/gusuan.do",
						data, function(msg) {
							/* var item = "<b>运费预估</b><span>￥<b>"+msg+"</b></span></p>"
							$("#money").append(item) */
							$("#money").val("运费预估￥" + msg)
						})
			});
		}();

		/**
		 * 设置默认值
		 */

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