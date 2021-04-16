<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看物流</title>
<meta
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0"
	name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<link href="${ctx}/dingdangenzhu/css/style.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<section class="aui-flexView">
		<header class="aui-navBar aui-navBar-fixed b-line">

			<div class="aui-center">
				<span class="aui-center-title">运单物流跟踪</span>
			</div>

		</header>
		<section class="aui-scrollView">
			<div class="aui-flex aui-flex-lag">

				<div class="aui-flex-box">

					<h2>
						运单单号：<em>${waybill.waybillId }</em>
					</h2>
				</div>

			</div>
			<div class="divHeight"></div>
			<div class="aui-flex aui-flex-lag">
				<div class="aui-flex-box">
					<h2 style="color: #333">订单跟踪</h2>
				</div>
			</div>
			<div class="aui-timeLine b-line">
				<ul class="aui-timeLine-content">

					<c:if test="${waybill.send ne null }">
						<c:forEach items="${waybill.send}" var="Tsend">
							<li class="aui-timeLine-content-item"><em
								class="aui-timeLine-content-icon"></em> 
								<c:if test="${Tsend.stime ne 'null' }">
								<c:if test="${Tsend.signState == 0 }">
									<p>包裹已签收</p>
									</c:if>
									<c:if test="${Tsend.signState == 1 }">
									<p>拒签收,拒签原因：${Tsend.rejectReasons}。</p>
									</c:if>
									<p style="margin-top: 10px;">
									<fmt:formatDate value="${Tsend.stime}"
										pattern="yyyy-MM-dd HH:mm" />
								</p>
								</c:if> 
							
								
								</li>
								
									<c:if test="${Tsend.sendTime ne 'null' }">
									<li class="aui-timeLine-content-item"><em
								class="aui-timeLine-content-icon"></em> 
								<p>【${Tsend.staff.dot.dotName}】安排配送,配送员：${Tsend.staff.staffName} ${Tsend.staff.staffPhone}</p>
								<p style="margin-top: 10px;">
									<fmt:formatDate value="${Tsend.sendTime}"
										pattern="yyyy-MM-dd HH:mm" />
								</p>
								</li>
								</c:if>
						</c:forEach>
					</c:if>

					<c:if test="${waybill.logistics ne null }">
						<c:forEach items="${waybill.logistics}" var="Tlogistics">
							<li class="aui-timeLine-content-item"><em
								class="aui-timeLine-content-icon"></em> <c:if
									test="${Tlogistics.logisticsType eq '收入' }">
									<p>包裹已达【${Tlogistics.targetDotName}】</p>
								</c:if> <c:if test="${Tlogistics.logisticsType eq '发出' }">
									<p>离开【${Tlogistics.startDotName}】,下一站【${Tlogistics.targetDotName}】</p>
								</c:if>
								<p style="margin-top: 10px;">
									<fmt:formatDate value="${Tlogistics.time}"
										pattern="yyyy-MM-dd HH:mm" />
								</p></li>
						</c:forEach>
					</c:if>

					<c:if test="${waybill.confirmTime ne null }">
						<li class="aui-timeLine-content-item"><em
							class="aui-timeLine-content-icon"></em>
							<p>【${waybill.order.staff.dot.dotName}】的
								${waybill.order.staff.staffName} 已揽件，确认包裹信息。</p>
							<p style="margin-top: 10px;">
								<fmt:formatDate value="${waybill.confirmTime}"
									pattern="yyyy-MM-dd HH:mm" />
							</p></li>
					</c:if>

					<c:if test="${waybill.cancelTime ne null }">
						<li class="aui-timeLine-content-item"><em
							class="aui-timeLine-content-icon"></em>
							<p>已取消</p></li>
					</c:if>

					<c:if test="${waybill.receiptTime ne null }">
						<li class="aui-timeLine-content-item"><em
							class="aui-timeLine-content-icon"></em>
							<p>【${waybill.order.staff.dot.dotName}】的
								${waybill.order.staff.staffName} 已接单，请等待揽件。</p>
							<p style="margin-top: 10px;">
								<fmt:formatDate value="${waybill.receiptTime}"
									pattern="yyyy-MM-dd HH:mm" />
							</p></li>
					</c:if>

					<c:if test="${waybill.receiptTime eq null }">
						<li class="aui-timeLine-content-item"><em
							class="aui-timeLine-content-icon"></em>
							<p>待收件</p></li>
					</c:if>


				</ul>
			</div>


		</section>

	</section>
</body>
</html>
