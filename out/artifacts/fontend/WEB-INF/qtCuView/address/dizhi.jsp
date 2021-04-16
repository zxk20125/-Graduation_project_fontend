<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>地址簿</title>
<meta
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0"
	name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<link href="${ctx}/qtCustomer/css/style4.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${ctx}/qtCustomer/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/qtCustomer/js/tab.js"></script>
</head>
<body>

	<section class="aui-flexView">
		<header class="aui-navBar aui-navBar-fixed">
			<a href="javascript:history.back(-1)" class="aui-navBar-item"> <i
				class="icon icon-return"></i>
			</a>
			 <div class="aui-center">
				 <span class="aui-center-title">地址簿</span> 
			</div> 
			<a href="${ctx}/qtCustomer/address/insert.do?customerId=${customer.customerId}" class="aui-navBar-item">
				<h1>添加</h1>
			</a>
		</header>
		<section class="aui-scrollView">
			<div class="aui-tab" data-ydui-tab>
				
				<div class="divHeight"></div>
				 <div class="tab-panel">
					<div class="tab-panel-item tab-active"> 
						<c:if test="${addresss eq 'null'}">
							<center>没有地址</center>
						</c:if>
						<c:if test="${addresss ne 'null'}">
							<c:forEach items="${addresss}" var="address">
								<%-- <c:if test="${address.role == 0}"> --%>
									<div class="tab-item">
										<a href="${ctx}/qtCustomer/address/update.do?addressId=${address.addressId}"
											class="aui-well-item aui-well-item-clear"> 
											<div class="aui-well-item-bd">
												<b>${address.addressName}</b> ${address.phone}
												<p>${fn:substring(address.address, 0, 3)}${fn:substring(address.address, 3, 7)}${fn:substring(address.address, 7, -1)}</p>
											</div>
										</a>
									</div>
									<div class="divHeight"></div>
									<div class="tab-item"></div>
								<%-- </c:if> --%>
							</c:forEach>
						</c:if>
						
						
					</div>
				
</div></div>

				<!-- 收货人 -->
				<%-- <div class="tab-panel-item">
					<div class="tab-item">
						<c:if test="${addresss eq 'null'}">
							<center>没有地址</center>
						</c:if>
						<c:if test="${addresss ne 'null'}">
							<c:forEach items="${addresss}" var="address">
								<c:if test="${address.role == 1}">
									<div class="tab-item">

										<a href="javascript:void(0);"
											class="aui-well-item aui-well-item-clear">
											<div class="aui-well-item-bd">
												<b>${address.addressName}</b> ${address.phone}
												<p>${address.address}</p>
			
											</div>
											<button>asd</button>
										</a>
										

									</div>


									<div class="divHeight"></div>
									<div class="tab-item"></div>
								</c:if>
							</c:forEach>
						</c:if>
					</div>

				</div> --%>
		</section>
	</section>
</body>
</html>

