
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
<meta
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0"
	name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<link rel="icon" type="image/x-icon" href="favicon.ico">
<link href="iTunesArtwork@2x.png" sizes="114x114"
	rel="apple-touch-icon-precomposed">
<link type="text/css" rel="stylesheet"
	href="${ctx}/qtCustomer/themes/css/base.css">
<link type="text/css" rel="stylesheet"
	href="${ctx}/qtCustomer/themes/css/icon.css">
<link type="text/css" rel="stylesheet"
	href="${ctx}/qtCustomer/themes/css/home.css">
<script type="text/javascript"
	src="${ctx}/qtCustomer/themes/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/qtCustomer/themes/js/tab.js"></script>
<script type="text/javascript"
	src="${ctx}/qtCustomer/themes/js/delete/mui.min.js"></script>

</head>
<body>
	<section class="aui-flexView">
		<header class="aui-navBar aui-navBar-fixed">
			<a href="javascript:history.go(-1);" class="aui-navBar-item"> <i
				class="aui-icon icon-return"></i>
			</a>
			<div class="aui-center">
				<span class="aui-center-title">我的订单</span>
			</div>
			<a href="javascript:;" class="aui-navBar-item"> <i
				class="icon icon-sys"></i>
			</a>
		</header>
		<section class="aui-scrollView">
			<div class="aui-tab aui-tab-order" data-ydui-tab>
				<ul class="tab-nav">
					<li class="tab-nav-item tab-active"><a href="javascript:;">我寄的</a>
					</li>
					<li class="tab-nav-item"><a href="javascript:;">我收的</a></li>
					<li class="tab-nav-item"><a href="javascript:;">待揽件</a></li>
					<li class="tab-nav-item"><a href="javascript:;">配送中</a></li>
					<li class="tab-nav-item"><a href="javascript:;">已签收</a></li>
					<li class="tab-nav-item"><a href="javascript:;">已取消</a></li>

				</ul>

				<div class="tab-panel">
					<!-- 我寄的 -->
					<div class="tab-panel-item tab-active">
						<div class="mui-content">

							<ul class="mui-table-view">
								<c:forEach items="${waybills}" var="waybill">
									<li class="mui-table-view-cell">
										<%--  <div class="mui-slider-right mui-disabled">
                                    <c:if test="${waybill.cancelTime eq null}">
                                        <a class="mui-btn mui-btn-red" style="background-color: blue;">取消</a>
                                        </c:if>
                                        <a class="mui-btn mui-btn-red">删除</a>
                                    </div> --%>
										<div class="mui-slider-handle">
											<div class="aui-flex">
												<a
													href="${ctx}/qtCustomer/order/orderTracking.do?waybill_id=${waybill.waybillId}">
													<div class="aui-flex-box">
														<h2>
															<font color="#808080">运单号：</font>${waybill.waybillId }</h2>
														<span style="float: r"></span>

														<div style="height: 5px"></div>
														<div class="aui-flex-track">
															<span class="aui-flex-track-span"
																style="text-align: center;">
																<!-- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
																${waybill.order.sender}&nbsp;&nbsp;&nbsp;<i
																class="aui-arrow-right"></i>&nbsp;&nbsp;&nbsp;&nbsp;${waybill.order.receiver}
															</span>

														</div>

														<p>
															下单时间：
															<fmt:formatDate type="both" dateStyle="medium"
																timeStyle="medium" value="${waybill.order.orderTime}" />
														</p>
														<p>寄：${waybill.order.senderAddress}</p>
														<p>收：${waybill.order.receivingAddress}</p>
														<span
															style="cursor: pointer; background-color: #FFFFFF; color: #33CCFF; padding: 5px 5px; display: inline-block; font-size: 15px;">${waybill.order.paymentMethod}</span>
													</div>
												</a>

												<c:if test="${waybill.cancelTime ne null}">
													<div class="aui-touch-off">已取消</div>
												</c:if>
											</div>
										</div>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
					<!-- end -->

					<!-- 我收的 -->
					<div class="tab-panel-item">
						<div class="mui-content">
							<ul class="mui-table-view">
								<c:forEach items="${waybills2}" var="waybill2">
									<li class="mui-table-view-cell">
										<div class="mui-slider-right mui-disabled">
											<a class="mui-btn mui-btn-red">删除</a>
										</div>
										<div class="mui-slider-handle">
											<div class="aui-flex">
												<a
													href="${ctx}/qtCustomer/order/orderTracking.do?waybill_id=${waybill2.waybillId}">

													<div class="aui-flex-box">
														<h2>
															<font color="#808080">运单号：</font>${waybill2.waybillId }</h2>
														<div style="height: 5px"></div>
														<div class="aui-flex-track">
															<span class="aui-flex-track-span">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																${waybill2.order.sender}&nbsp;<i class="aui-arrow-right"></i>&nbsp;${waybill2.order.receiver}
															</span>

														</div>

														<p>
															下单时间：
															<fmt:formatDate type="both" dateStyle="medium"
																timeStyle="medium" value="${waybill2.order.orderTime}" />
														</p>
														<p>寄：${waybill2.order.senderAddress}</p>
														<p>收：${waybill2.order.receivingAddress}</p>
														<span
															style="cursor: pointer; background-color: #FFFFFF; color: #33CCFF; padding: 5px 5px; display: inline-block; font-size: 15px;">${waybill2.order.paymentMethod}</span>
													</div>

												</a>

											</div>
										</div>
									</li>

								</c:forEach>
							</ul>
						</div>
					</div>
					<!-- end -->

					<!-- 待揽件 -->
					<div class="tab-panel-item">
						<div class="mui-content">
							<ul class="mui-table-view">
								<c:forEach items="${waybills}" var="waybill">
									<c:if test="${waybill.confirmTime eq null}">
										<c:if test="${waybill.cancelTime eq null}">
											<li class="mui-table-view-cell">
												<div class="mui-slider-right mui-disabled">
													<a class="mui-btn mui-btn-red"
														onclick="quxiaodingdan('${waybill.waybillId}');">取消</a>
												</div>
												<div class="mui-slider-handle">
													<div class="aui-flex">
														<a
															href="${ctx}/qtCustomer/order/orderTracking.do?waybill_id=${waybill.waybillId}">
															<div class="aui-flex-box">
																<h2>
																	<font color="#808080">运单号：</font>${waybill.waybillId}</h2>
																<div style="height: 5px"></div>
																<div class="aui-flex-track">
																	<span class="aui-flex-track-span">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																		${waybill.order.sender}&nbsp;<i
																		class="aui-arrow-right"></i>&nbsp;${waybill.order.receiver}
																	</span>

																</div>

																<p>
																	下单时间：
																	<fmt:formatDate type="both" dateStyle="medium"
																		timeStyle="medium" value="${waybill.order.orderTime}" />
																</p>
																<p>寄：${waybill.order.senderAddress}</p>
																<p>收：${waybill.order.receivingAddress}</p>
																<span
																	style="cursor: pointer; background-color: #FFFFFF; color: #33CCFF; padding: 5px 5px; display: inline-block; font-size: 15px;">${waybill.order.paymentMethod}</span>

															</div>
														</a>
														<%--  <c:if test="${waybill.cancelTime eq null}">
                                             <div class="aui-touch-off">已取消</div> 
                                             </c:if>  --%>
													</div>
												</div>
											</li>
										</c:if>
									</c:if>
								</c:forEach>
							</ul>
						</div>
					</div>
					<!-- end -->
					<!-- 配送中 -->
					<div class="tab-panel-item">
						<div class="mui-content">
							<ul class="mui-table-view">
								<c:forEach items="${waybills}" var="waybill">
									<c:if test="${waybill.confirmTime ne null}">
										<c:if test="${waybill.finishTime eq null}">
											<li class="mui-table-view-cell">

												<div class="mui-slider-handle">
													<div class="aui-flex">
														<a
															href="${ctx}/qtCustomer/order/orderTracking.do?waybill_id=${waybill.waybillId}">
															<div class="aui-flex-box">
																<h2>
																	<font color="#808080">运单号：</font>${waybill.waybillId }</h2>
																<div style="height: 5px"></div>
																<div class="aui-flex-track">
																	<span class="aui-flex-track-span"
																		style="text-align: center;">
																		${waybill.order.sender}&nbsp;&nbsp;&nbsp;<i
																		class="aui-arrow-right"></i>&nbsp;&nbsp;&nbsp;${waybill.order.receiver}
																	</span>

																</div>

																<p>
																	下单时间：
																	<fmt:formatDate type="both" dateStyle="medium"
																		timeStyle="medium" value="${waybill.order.orderTime}" />
																</p>
																<p>寄：${waybill.order.senderAddress}</p>
																<p>收：${waybill.order.receivingAddress}</p>
																<span
																	style="cursor: pointer; background-color: #FFFFFF; color: #33CCFF; padding: 5px 5px; display: inline-block; font-size: 15px;">${waybill.order.paymentMethod}</span>
															</div>
														</a>

													</div>
												</div>
											</li>
										</c:if>
									</c:if>
								</c:forEach>
							</ul>
						</div>
					</div>
					<!-- end -->
					<!-- 已签收 -->
					<div class="tab-panel-item">
						<div class="mui-content">
							<ul class="mui-table-view">
								<c:forEach items="${waybills}" var="waybill">
									<c:if test="${waybill.finishTime ne null}">

										<li class="mui-table-view-cell">
											<div class="mui-slider-right mui-disabled">
												<a class="mui-btn mui-btn-red">删除</a>
											</div>
											<div class="mui-slider-handle">
												<div class="aui-flex">
													<a
														href="${ctx}/qtCustomer/order/orderTracking.do?waybill_id=${waybill.waybillId}">
														<div class="aui-flex-box">
															<h2>
																<font color="#808080">运单号：</font>${waybill.waybillId }</h2>
															<div style="height: 5px"></div>
															<div class="aui-flex-track">
																<span class="aui-flex-track-span">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																	${waybill.order.sender}&nbsp;<i class="aui-arrow-right"></i>&nbsp;${waybill.order.receiver}
																</span>

															</div>

															<p>
																下单时间：
																<fmt:formatDate type="both" dateStyle="medium"
																	timeStyle="medium" value="${waybill.order.orderTime}" />
															</p>
															<p>寄：${waybill.order.senderAddress}</p>
															<p>收：${waybill.order.receivingAddress}</p>
															<span
																style="cursor: pointer; background-color: #FFFFFF; color: #33CCFF; padding: 5px 5px; display: inline-block; font-size: 15px;">${waybill.order.paymentMethod}</span>
														</div> <a
														href="${ctx}/qtCustomer/order/orderTracking.do?waybill_id=${waybill.waybillId}">
															<%--    <div class="aui-touch-off">${waybill.order.paymentMethod}</div>  --%>
												</div>
											</div>
										</li>
									</c:if>
								</c:forEach>
							</ul>
						</div>
					</div>
					<!-- end -->
					<!-- 已取消 -->
					<div class="tab-panel-item">
						<div class="mui-content">
							<ul class="mui-table-view">
								<c:forEach items="${waybills}" var="waybill">
									<c:if test="${waybill.cancelTime ne null}">
										<li class="mui-table-view-cell">
											<div class="mui-slider-right mui-disabled">
												<a class="mui-btn mui-btn-red" onclick="shanchudingdan('${waybill.waybillId}')">删除</a>
											</div>
											<div class="mui-slider-handle">
												<div class="aui-flex">
													<a
														href="${ctx}/qtCustomer/order/orderTracking.do?waybill_id=${waybill.waybillId}">
														<div class="aui-flex-box">

															<h2>
																<font color="#808080">运单号：</font>${waybill.waybillId }</h2>
															<div style="height: 5px"></div>
															<div class="aui-flex-track">
																<span class="aui-flex-track-span">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
																	${waybill.order.sender}&nbsp;<i class="aui-arrow-right"></i>&nbsp;${waybill.order.receiver}
																</span>

															</div>

															<p>
																下单时间：
																<fmt:formatDate type="both" dateStyle="medium"
																	timeStyle="medium" value="${waybill.order.orderTime}" />
															</p>
															<p>寄：${waybill.order.senderAddress}</p>
															<p>收：${waybill.order.receivingAddress}</p>
															<span
																style="cursor: pointer; background-color: #FFFFFF; color: #33CCFF; padding: 5px 5px; display: inline-block; font-size: 15px;">${waybill.order.paymentMethod}</span>
														</div> <a
														href="${ctx}/qtCustomer/order/orderTracking.do?waybill_id=${waybill.waybillId}">
															<%--  <c:if test="${waybill.paymentTime eq null}">
                                             <div class="aui-touch-off">待付款</div> 
                                             </c:if> --%>
												</div>
											</div>
										</li>
									</c:if>
								</c:forEach>
							</ul>
						</div>
					</div>
					<!-- end -->
				</div>
			</div>

		</section>
	</section>
	<script type="text/javascript">
function quxiaodingdan(waybillId){
	console.log(waybillId)
	 let data = {
			"waybillId":waybillId
	}
	console.log(data); 
	  $.post(getContextPath() + "/qtCustomer/order/quxiao.do",data,function(msg) {
		if(msg==1){
			alert("取消成功!");
			setTimeout(function(){location.reload()},2000);
		}else{
			 setTimeout(function(){location.reload()},2000); 
		}
	})  
}

function shanchudingdan(waybillId){
	console.log(waybillId)
	 let data = {
			"waybillId":waybillId
	}
	console.log(data); 
	  $.post(getContextPath() + "/qtCustomer/order/shanchu.do",data,function(msg) {
		if(msg==1){
			alert("删除成功!");
			setTimeout(function(){location.reload()},1000);
		}else{
			 setTimeout(function(){location.reload()},2000); 
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

