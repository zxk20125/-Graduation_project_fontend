<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>信息列表</title>

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

	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>
							 <small>信息</small>
						</h5>
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a> <a class="close-link"> <i class="fa fa-times"></i>
							</a>
						</div>
					</div>
					<div class="ibox-content">

						<table
							class="table table-striped table-stripped table-hover dataTables-example">
							<thead>
								<tr>
									<th>运单号</th>
									<th>客户</th>
									<th>状态</th> 
									<th>是否付款</th>
									<th>对应订单</th>
									<th>运单物流</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${waybills}" var="waybill">
									<tr>
										<td>${waybill.waybillId}</td>
										<td>${waybill.order.customer.customerLoginName}</td>
										<td>
										<c:if test="${waybill.cancelTime eq null }">
										 <c:if test="${waybill.finishTime ne null }">
										 已完成		
										 </c:if>								
										</c:if> 
										
										<c:if test="${waybill.cancelTime eq null }">
										<c:if test="${waybill.finishTime eq null }">
										<c:if test="${waybill.confirmTime ne null }">
										运输中
										</c:if>
										</c:if>  										
										</c:if>
										
										<c:if test="${waybill.cancelTime eq null }">
										<c:if test="${waybill.finishTime eq null }">
										<c:if test="${waybill.confirmTime eq null }">
										<c:if test="${waybill.receiptTime ne null }">
										已接单
										</c:if>
										</c:if>
										</c:if>  										
										</c:if>
										
										<c:if test="${waybill.cancelTime eq null }">
										<c:if test="${waybill.finishTime eq null }">
										<c:if test="${waybill.confirmTime eq null }">
										<c:if test="${waybill.receiptTime eq null }">
										未接单
										</c:if>
										</c:if>
										</c:if>  										
										</c:if>
										
										<c:if test="${waybill.cancelTime ne null }">
										已取消
										</c:if>
										</td>
										<td><c:if test="${waybill.paymentTime ne null }">
										已付款
										</c:if>
										<c:if test="${waybill.paymentTime eq null }">
										未付款
										</c:if>
										</td>
										<td><a>${waybill.orderId}</a></td>
										<td> <a href="${ctx}/houtai/waybill/orderTracking.do?waybillId=${waybill.waybillId}"> 查看</a> 
												<%-- <button class="btn btn-primary btn-xs"
													onclick="updatestaff(${staff.staffId})" data-toggle="modal"
													data-target="#myModal">
													 查看
												</button> --%>
											</td>

							
									</tr>
								</c:forEach>
							</tbody>
						</table>

						<!-- 添加修改框 -->
						<div class="modal inmodal" id="myModal" tabindex="-1"
							role="dialog" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content animated bounceInRight">

									<!-- <div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">
											<span aria-hidden="true">&times;</span><span class="sr-only">关闭</span>
										</button>
										<i class="fa fa-laptop modal-icon"></i>
										<h5 class="modal-title"></h5>
										<small class="font-bold"> 这里可以显示副标题。
									</div> -->

									<form id="updateform" onsubmit="return doupdate()"
										name="updatefrom">
										<div class="modal-body">
											<!-- <p><strong>H+</strong> 是一个完全响应式，基于Bootstrap3.3.5最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术，她提供了诸多的强大的可以重新组合的UI组件，并集成了最新的jQuery版本(v2.1.1)，当然，也集成了很多功能强大，用途广泛的jQuery插件，她可以用于所有的Web应用程序，如网站管理后台，网站会员中心，CMS，CRM，OA等等，当然，您也可以对她进行深度定制，以做出更强系统。</p> -->

									

											<div class="form-group">
												
												 <label class="col-sm-3 control-label">留言：</label>
        <!-- <div class="col-sm-9">
            <p class="form-control-static" id="remarks"
													name="remarks"></p>
        </div> -->
											<input type="textarea" 
													class="form-control" id="remarks"
													name="remarks" required="required"> 
											</div>
										
										
										</div>

									<!-- 	<div class="modal-footer">

											<button type="button" class="btn btn-white"
												data-dismiss="modal">关闭</button>
											<button type="submit" class="btn btn-primary">保存</button>
										</div> -->

									</form>
								</div>

							</div>
						</div>

						<!-- end -->


					</div>
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
					"callback": function(sValue, y) {
						var aPos = oTable.fnGetPosition(this);
						oTable.fnUpdate(sValue, aPos[0], aPos[1])
					},
					"submitdata": function(value, settings) {
						return {
							"row_id": this.parentNode.getAttribute("id"),
							"column": oTable.fnGetPosition(this)[2]
						}
					},
					"width": "90%",
					"height": "100%"
				})
			});

			function fnClickAddRow() {
				$("#editable").dataTable().fnAddData(["Custom row", "New row", "New row", "New row", "New row"])
			};
		</script>
	<script type="text/javascript"
		src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

	<script>
			document.write('<script src="//' + (location.host || 'localhost').split(':')[0] +
				':35929/livereload.js?snipver=1"></' + 'script>')
		</script>
	<script>
			document.addEventListener('LiveReloadDisconnect', function() {
				setTimeout(function() {
					window.location.reload();
				}, 500);
			})
			
			
			//模态窗口显示
			function asdfasdfremarks(id){
				/* console.log(id) */
				$.post(getContextPath()+"/houtai/order/remarks.do",
						{id:id},
						function(msg){
							
							$("#remarks").val(msg.remarks);
							
						}
						);
				
			};
		
		
			
			

			
			//时间戳转年月日格式
			function timestampToTime(timestamp) {
				var date = new Date();   //timestamp 为10位需*1000，timestamp 为13位的话不需乘1000
				var Y = date.getFullYear() + '-';
				var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
				var D = (date.getDate() < 10 ? '0'+ date.getDate() : date.getDate());
				
				return Y+M+D;
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
</body>

</html>
