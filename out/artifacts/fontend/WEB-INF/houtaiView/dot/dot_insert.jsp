<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>员工信息列表</title>

<link rel="shortcut icon" href="${ctx}/houtai/favicon.ico">
<link href="${ctx}/houtai/css/bootstrap.min.css?v=3.3.5"
	rel="stylesheet">
<link href="${ctx}/houtai/css/font-awesome.min.css?v=4.4.0"
	rel="stylesheet">

<!-- Data Tables -->
<link
	href="${ctx}/houtai/css/plugins/dataTables/dataTables.bootstrap.css"
	rel="stylesheet">

<link href="${ctx}/houtai/css/animate.min.css" rel="stylesheet">
<link href="${ctx}/houtai/css/style.min.css?v=4.0.0" rel="stylesheet">
<base target="_blank">

</head>

<body class="gray-bg">
	<div class="row">

		<div class="col-sm-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>添加员工</h5>
					<div class="ibox-tools">
						<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
						</a> <a class="close-link"> <i class="fa fa-times"></i>
						</a>
					</div>
				</div>
				<div class="ibox-content">

					<form id="insertform" onsubmit="return doinsert()"
						name="updatefrom" class="form-horizontal">

						<div class="form-group">
							<input type="hidden" class="form-control" id="dot_id" required=""
								name="dotId">
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">网点名</label>
							<div class="col-sm-10">
								<input type="text" placeholder="" class="form-control"
									id="dot_name" required="" name="dotName" required="required">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">网点所在城市</label>
							<div class="col-sm-10">
								<select id="province"></select> 
												<select	id="city"> </select>
								<input type="hidden" placeholder="" class="form-control"
									id="dot_city" required="" name="dotCity" required="required">		
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">网点地址</label>
							<div class="col-sm-10">
								<input type="text" placeholder="" class="form-control"
									id="dot_address" name="dotAddress" required="required">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">联系号码</label>
							<div class="col-sm-10">
								<input type="number" required="required" placeholder="请输入电话号码"
									class="form-control" name="dotPhone" id="dot_phone"
									required="required">
							</div>
						</div>

						<div class="hr-line-dashed"></div>
						<div class="form-group">
							<div class="col-sm-4 col-sm-offset-2">
								<button class="btn btn-primary" type="submit">确定添加</button>
								<button class="btn btn-white" type="reset">重置</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

	</div>


	<script src="${ctx}/houtai/js/jquery.min.js?v=2.1.4"></script>
	<script src="${ctx}/houtai/js/bootstrap.min.js?v=3.3.5"></script>
	<script src="${ctx}/houtai/js/plugins/jeditable/jquery.jeditable.js"></script>
	<script src="${ctx}/houtai/js/plugins/dataTables/jquery.dataTables.js"></script>
	<script
		src="${ctx}/houtai/js/plugins/dataTables/dataTables.bootstrap.js"></script>
	<script src="${ctx}/houtai/js/content.min.js?v=1.0.0"></script>
	<script>
		$(document).ready(function() {
			$(".dataTables-example").dataTable();
			var oTable = $("#editable").dataTable();
			oTable.$("td").editable("../example_ajax.php", {
				"callback" : function(sValue, y) {
					var aPos = oTable.fnGetPosition(this);
					oTable.fnUpdate(sValue, aPos[0], aPos[1])
				},
				"submitdata" : function(value, settings) {
					return {
						"row_id" : this.parentNode.getAttribute("id"),
						"column" : oTable.fnGetPosition(this)[2]
					}
				},
				"width" : "90%",
				"height" : "100%"
			})
		});

		function fnClickAddRow() {
			$("#editable").dataTable()
					.fnAddData(
							[ "Custom row", "New row", "New row", "New row",
									"New row" ])
		};
	</script>
	<script type="text/javascript"
		src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

	<script>
		document.write('<script src="//'
				+ (location.host || 'localhost').split(':')[0]
				+ ':35929/livereload.js?snipver=1"></' + 'script>')
	</script>
	<script>
		document.addEventListener('LiveReloadDisconnect', function() {
			setTimeout(function() {
				window.location.reload();
			}, 500);
		})
	</script>

	<script>
	/* 	function setAddressCity(){
			var province = $('#province option:selected').val();//选中的值
			console.log(province) 
			var city = $('#city option:selected').val();
		 console.log(city) 
			
			var address = province+city;
			 console.log(address) 
			
			$('dot_city').val(address)
		}
	 */
	 document.getElementById('province').onchange=function (){
		  if(this.options[0].value==-1)this.options[0]=null;
		 /*  document.getElementById('dot_city').value=this.value */
		  var province = $('#province option:selected').val();
		  var city = $('#city option:selected').val();
		  var address = province+city;
		  $('#dot_city').val(address)
		};
		
	 document.getElementById('city').onchange=function (){
		  if(this.options[0].value==-1)this.options[0]=null;
		 /*  document.getElementById('dot_city').value=this.value */
		  var province = $('#province option:selected').val();
		  var city = $('#city option:selected').val();
		  var address = province+city;
		  $('#dot_city').val(address)
		};
		
		//提交添加数据	
		function doinsert() {
		 
		 var province = $('#province option:selected').val();//选中的值
			console.log(province) 
			var city = $('#city option:selected').val();
		 console.log(city) 
			
			var address = province+city;
			 console.log(address) 
			  
			//JSON数据结构数据
			var sta = $("#insertform").serializeArray();
			
			console.log(sta)
			//将序列化数据转为对象
			var formObject = {};
			for ( var item in sta) {
				formObject[sta[item].name] = sta[item].value;
			}

			var formJSON = {
				data : JSON.stringify(formObject)
			};
			console.log(formJSON);

			// jquery 表单提交
			$.post(getContextPath() + "/houtai/dot/doinsert.do", formJSON,
					function(msg) {
						console.log(msg);
						if (msg == 1) {
							//window.location.href = getContextPath()+"/staff.do?cmd=list"; 
							alert("添加成功");
							window.location.href = getContextPath()
									+ "/houtai/dot/list.do";
						} else {
							alert("已有账号，添加失败");
						}
					});
			return false; // 必须返回false，否则表单会自己再做一次提交操作，并且页面跳转
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
	<!-- 城市选择 -->
<script src="${ctx}/houtai/js/myjs/city.js"></script>
<script>
	(
			function() {
				var pHtmlStr = '';
				for ( var name in pc) {
					pHtmlStr = pHtmlStr + '<option value='+name+'>' + name + '</option>';
				}
				$("#province").html(pHtmlStr);
				$("#province").change(
						function() {
							var pname = $("#province option:selected").text();
							var pHtmlStr = '';
							var cityList = pc[pname];
							for ( var index in cityList) {
								pHtmlStr = pHtmlStr + '<option>'
										+ cityList[index] + '</option>';
							}
							$("#city").html(pHtmlStr);
						});
				$("#province").change();
			})();
</script>
</body>

</html>
