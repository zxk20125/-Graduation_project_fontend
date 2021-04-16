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

	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>
							配送员 <small>列表</small>
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
									<th>员工编号</th>
									<th>姓名</th>
									<th>性别</th>
									<th>年龄</th>
									<th>联系号码</th>
									<th>所属网点</th>
									<th>入职日期</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach items="${staffs}" var="staff">
									<!-- 不显示后台管理员信息 -->
									<c:if test="${staff.staffLoginName ne 'admin'}">

										<%-- ${staff }; --%>
										<tr class="gradeX">
											<td>${staff.staffId}</td>
											<td>${staff.staffName}</td>
											<td>${staff.staffSex}</td>
											<td>${staff.staffAge}</td>
											<td>${staff.staffPhone}</td>
											<td>${staff.dot.dotName}</td>
											<td><fmt:formatDate value="${staff.hiredate}"
													pattern="yyyy-MM-dd" /></td>

											<td><botton class="btn btn-danger btn-xs"
													onclick="deletestaff(${staff.staffId})"> <span
													class="glyphicon glyphicon-remove"></span> 删除</botton>
												<button class="btn btn-primary btn-xs"
													onclick="updatestaff(${staff.staffId})" data-toggle="modal"
													data-target="#myModal">
													<span class="glyphicon glyphicon-pencil"></span> 修改
												</button></td>
										</tr>

									</c:if>
								</c:forEach>
							</tbody>
						</table>

						<!-- 添加修改框 -->
						<div class="modal inmodal" id="myModal" tabindex="-1"
							role="dialog" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content animated bounceInRight">

									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">
											<span aria-hidden="true">&times;</span><span class="sr-only">关闭</span>
										</button>
										<!-- <i class="fa fa-laptop modal-icon"></i> -->
										<h5 class="modal-title">修改员工信息</h5>
										<small class="font-bold"> <!-- 这里可以显示副标题。 -->
									</div>

									<form id="updateform" onsubmit="return doupdate()"
										name="updatefrom">
										<div class="modal-body">
											<!-- <p><strong>H+</strong> 是一个完全响应式，基于Bootstrap3.3.5最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术，她提供了诸多的强大的可以重新组合的UI组件，并集成了最新的jQuery版本(v2.1.1)，当然，也集成了很多功能强大，用途广泛的jQuery插件，她可以用于所有的Web应用程序，如网站管理后台，网站会员中心，CMS，CRM，OA等等，当然，您也可以对她进行深度定制，以做出更强系统。</p> -->

											<div class="form-group">
												<input type="hidden" class="form-control" id="staff_id"
													required="" name="staffId">
											</div>

											<div class="form-group">
												<label>姓名</label> <input type="text" placeholder="请输入姓名"
													class="form-control" id="staff_name" required=""
													name="staffName" required="required">
											</div>


											<div class="form-group">
												<label>账号</label> <input type="text" placeholder="请输入账号"
													class="form-control" id="staff_login_name"
													name="staffLoginName" required="required">
											</div>


											<div class="form-group">
												<label>密码</label> <input type="text" placeholder="请输入密码"
													class="form-control" id="staff_password"
													name="staffPassword" required="required">
											</div>



											<div class="form-group">
												<label>年龄</label> <input type="number" placeholder="请输入年龄"
													class="form-control" id="staff_age" name="staffAge">
											</div>



											<div class="form-group">

												<label>性别</label> <br> <label> <input
													type="radio" id="staff_sex_woman" value="女" name="staffSex" />女
												</label> <label> <input type="radio" value="男"
													name="staffSex" id="staff_sex_man" />男
												</label>
											</div>

											<!-- <div class="form-group">
												<label>职位</label> <input type="text" required=""
													placeholder="请输入职位" class="form-control" id="job"
													name="job">
											</div> -->

										
												<div class="form-group">
													<label>所属网点</label> <input type="text" required=""
													placeholder="" class="form-control" id="dot_name"
													name="dotName">
												</div>
											

											<div class="form-group">
												<label>入职时间</label> <input type="date" required=""
													placeholder="请输入职位" class="form-control" id="hiredate"
													name="hiredate">
											</div>

											<!-- <div class="form-group">
												<label>工资</label> <input type="number" placeholder=""
													class="form-control" step="0.01" id="sal" name="sal">
											</div> -->

											<div class="form-group">
												<label>电话号码</label> <input type="number" required="required"
													placeholder="请输入电话号码" class="form-control" id="staff_phone"
													name="staffPhone">
											</div>

										</div>

										<div class="modal-footer">

											<button type="button" class="btn btn-white"
												data-dismiss="modal">关闭</button>
											<button type="submit" class="btn btn-primary">保存</button>
										</div>

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
			
			
			
			
			//删除
			function deletestaff(id){
				$.post(getContextPath()+"/houtai/staff/delete.do",
						{id:id},
						function(msg){		
							if(msg == 1){
								console.log(msg);
								setTimeout(function() {
									window.location.href=getContextPath()+"/houtai/staff/list.do";
								}, 500);
							}
						}
						);
			};
			
			//提交修改数据	
			function doupdate() {
			
    		//JSON数据结构数据
    		var sta = $("#updateform").serializeArray();
    		//将序列化数据转为对象
    		var formObject = {};
    		for (var item in sta) {
       			 formObject[sta[item].name] = sta[item].value;
    			}
    
    		var formJSON = {data:JSON.stringify(formObject)};
    		console.log(formJSON);
  
    		// jquery 表单提交
   			$.post(getContextPath()+"/houtai/staff/doupdate.do",formJSON,function(msg){ 
					console.log(msg);
					if(msg == 1){
						window.location.href = getContextPath()+"/houtai/staff/list.do"; 
					}
			  	});
    			return false; // 必须返回false，否则表单会自己再做一次提交操作，并且页面跳转
			};

			
			//时间戳转年月日格式
			function timestampToTime(timestamp) {
				var date = new Date();   //timestamp 为10位需*1000，timestamp 为13位的话不需乘1000
				var Y = date.getFullYear() + '-';
				var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
				var D = (date.getDate() < 10 ? '0'+ date.getDate() : date.getDate());
				
				return Y+M+D;
		    };
			
			//模态窗口显示
			function updatestaff(id){
				console.log(id)
				$.post(getContextPath()+"/houtai/staff/update.do",
						{id:id},
						function(msg){	
							 console.log(msg)
							/*  console.log(msg.hiredate)
  
   							 console.log(timestampToTime(msg.hiredate)); */
							 
							 $("#staff_id").val(msg.staffId);
							$("#staff_name").val(msg.staffName);
							$("#staff_login_name").val(msg.staffLoginName);
							$("#staff_password").val(msg.staffPassword);
							$("#staff_age").val(msg.staffAge);
						if(msg.staffSex == "女"){
							$("#staff_sex_woman").attr("checked","chencked")
						}else{
							$("#staff_sex_man").attr("checked","chencked")
						}
						/* $("#job").val(msg.job); */
						$("#dot_name").val(msg.dot.dotName);
						$("#hiredate").val(timestampToTime(msg.hiredate));
						
					/* 	$("#sal").val(msg.sal); */
						$("#staff_phone").val(msg.staffPhone);
						
						}
						);
				
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
