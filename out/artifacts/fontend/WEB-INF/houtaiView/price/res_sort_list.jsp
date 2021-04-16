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


<title>定价</title>


<link rel="shortcut icon" href="favicon.ico">
<link href="${ctx}/houtai/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
<link href="${ctx}/houtai/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
<link href="${ctx}/houtai/css/plugins/iCheck/custom.css" rel="stylesheet">
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
						<h5>运送城市 定价</h5>
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a>

							<!-- 添加弹出按钮 -->
							<a data-toggle="modal" data-target="#myModal">
								<i class="fa fa-plus"></i>
							</a> <a class="close-link"> <i class="fa fa-times"></i>
							</a>
						</div>

					</div>
					<div class="ibox-content">

						<table class="table table-striped table-hover ">
							<thead>
								<tr>
									<th>物件类型</th>
									<!-- <th>终点地址</th> -->
									<th>定价（元）</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${resSorts}" var="resSort">
									<tr>
										<td>${resSort.resSort}</td>
										<td>${resSort.resSortMoney}</td>
										<%-- <td>${shipAddress.shipAddressMoney}</td> --%>
										<td><botton class="btn btn-danger btn-xs"
												onclick="deleteTDis(${resSort.resSortId})"> <span
												class="glyphicon glyphicon-remove"></span> 删除</botton>
											<button class="btn btn-primary btn-xs"
												onclick="updateTDis(${resSort.resSortId})"
												data-toggle="modal" data-target="#myModalupdateTDistance">
												<span class="glyphicon glyphicon-pencil"></span> 修改
											</button></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>

	</div>

		</div>


		<!-- 距离定价修改框 -->
		<div class="modal inmodal" id="myModalupdateTDistance" tabindex="-1"
			role="dialog" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content animated bounceInRight">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">关闭</span>
						</button>
						<!-- <i class="fa fa-laptop modal-icon"></i> -->
						<h5>修改</h5>
						<small class="font-bold"> <!-- 这里可以显示副标题。 -->
					</div>

					<form id="updateTDistanceform" onsubmit="return doupdateTDis()"
						name="updateTDistancefrom">
						<div class="modal-body">

						<div class="form-group">
								<input type="hidden" class="form-control" id="res_sort_id"
									name="resSortId" required="">
							</div>

							<div class="form-group">
								<label>物件类别</label> <input type="text" class="form-control"
									id="res_sort" required="" name="resSort" required="required">
							</div>


							<!-- <div class="form-group">
								<label>终点地址</label> <input type="text" class="form-control"
									id="end_address" name="endAddress" required="required">
							</div> -->
							
							<div class="form-group">
								<label>定价</label> <input type="number" class="form-control"
									id="res_sort_money" name="resSortMoney" required="required">
							</div>
						</div>


						<div class="modal-footer">
							<button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
							<button type="submit" class="btn btn-primary">保存</button>
						</div>

					</form>
				</div>

			</div>
		</div>
		<!-- end -->

		<!-- 添加  -->
		<div class="modal inmodal" id="myModal" tabindex="-1"
			role="dialog" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content animated bounceInRight">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">关闭</span>
						</button>
						<!-- <i class="fa fa-laptop modal-icon"></i> -->
						<h5>添加</h5>
						<small class="font-bold"> <!-- 这里可以显示副标题。 -->
					</div>

					<form id="insertTDistanceform" onsubmit="return insertTDis()"
						name="insertTDistancefrom">
						<div class="modal-body">



							<div class="form-group">
								<input type="hidden" class="form-control" id="res_sort_id"
									name="resSortId" required="">
							</div>

							<div class="form-group">
								<label>物件类别</label> <input type="text" class="form-control"
									id="res_sort" required="" name="resSort" required="required">
							</div>


							<!-- <div class="form-group">
								<label>终点地址</label> <input type="text" class="form-control"
									id="end_address" name="endAddress" required="required">
							</div> -->
							
							<div class="form-group">
								<label>定价</label> <input type="number" class="form-control"
									id="res_sort_money" name="resSortMoney" required="required">
							</div>
						</div>

						

						<div class="modal-footer">
							<button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
							<button type="submit" class="btn btn-primary">确认</button>
						</div>

					</form>
				</div>

			</div>
		</div>

		<!-- end -->


		
	</div>

	<script src="${ctx}/houtai/js/jquery.min.js?v=2.1.4"></script>
	<script src="${ctx}/houtai/js/bootstrap.min.js?v=3.3.5"></script>
	<script src="${ctx}/houtai/js/plugins/peity/jquery.peity.min.js"></script>
	<script src="${ctx}/houtai/js/content.min.js?v=1.0.0"></script>
	<script src="${ctx}/houtai/js/plugins/iCheck/icheck.min.js"></script>
	<script src="${ctx}/houtai/js/demo/peity-demo.min.js"></script>
	<script>
        $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
    </script>
	<script type="text/javascript"
		src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>

	<script type="text/javascript">
	
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
		
	
	// 修改模态窗口显示
	function updateTDis(id){
		console.log(id)
		$.post(getContextPath()+"/houtai/resSort/update.do",
				{id:id},
				function(msg){	
					 console.log(msg);
				$("#res_sort_id").val(msg.resSortId);
				$("#res_sort").val(msg.resSort);
				/* $("#end_address").val(msg.endAddress); */
				$("#res_sort_money").val(msg.resSortMoney);
				}
				);
		
	};
	
	//修改 操作
	function doupdateTDis(){
		//JSON数据结构数据
		var sta = $("#updateTDistanceform").serializeArray();
		
		//将序列化数据转为对象
		var formObject = {};
		for (var item in sta) {
   			 formObject[sta[item].name] = sta[item].value;
			}

		var formJSON = {data:JSON.stringify(formObject)};
		console.log(formJSON);

		// jquery 表单提交
			$.post(getContextPath()+"/houtai/resSort/doupdate.do",formJSON,function(msg){ 
				console.log(msg);
				if(msg == 1){
					alert("修改成功");
					 window.location.href = getContextPath()+"/houtai/resSort/res_sort_list.do";  
				}else{
					alert("修改失败")
				}
		  	});
			return false; // 必须返回false，否则表单会自己再做一次提交操作，并且页面跳转
	};
	
	//删除操作
	function deleteTDis(id){
		$.post(getContextPath()+"/houtai/resSort/delete.do",
				{id:id},
				function(msg){		
					if(msg == 1){
						console.log(msg);
						setTimeout(function() {
							window.location.href=getContextPath()+"/houtai/resSort/res_sort_list.do";
						}, 500);
					}else{
						alert("删除失败");
					}
				}
				);
	};
	
	//添加 距离定价
	function insertTDis(){
		//JSON数据结构数据
		var sta = $("#insertTDistanceform").serializeArray();
		console.log(sta)
		//将序列化数据转为对象
		var formObject = {};
		for (var item in sta) {
   			 formObject[sta[item].name] = sta[item].value;
			}

		var formJSON = {data:JSON.stringify(formObject)};
		console.log(formJSON);
		
		// jquery 表单提交
			$.post(getContextPath()+"/houtai/resSort/insert.do",formJSON,function(msg){ 
				console.log(msg);
				if(msg == 1){
					//window.location.href = getContextPath()+"/staff.do?cmd=list"; 
					alert("添加成功");
					window.location.href = getContextPath()+"/houtai/resSort/res_sort_list.do"; 
				}else{
					alert("已有条件，添加失败");
					window.location.href = getContextPath()+"/houtai/resSort/res_sort_list.do";
				}
		  	});
			return false; // 必须返回false，否则表单会自己再做一次提交操作，并且页面跳转
	}
	
		</script>

	
</body>

</html>