<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
			<a href="javascript:history.go(-1);" class="aui-navBar-item"> <i
				class="icon icon-return"></i>
			</a>
			<div class="aui-center">
				<span class="aui-center-title">运单信息</span>
			</div>
			<!-- <a href="javascript:;" class="aui-navBar-item"> <i
				class="icon icon-more"></i>
			</a> -->
		</header>
		<section class="aui-scrollView">
			<div class="aui-flex aui-flex-lag">

				<div class="aui-flex-box">

					<h2>
						运单单号：<em><input id="waybillId" style="border: none;"
							type="text" value="${waybill.waybillId }"></em>
					</h2>
				</div>
				<div class="aui-text-copy" id="copyBT">复制</div>
			</div>
			<div class="divHeight"></div>
			<div class="aui-flex-box">
				<div style="color: #778899; padding-left: 10px; padding-top: 5px;">
					寄件方：${waybill.order.sender}</div>
				<div style="padding-left: 10px; padding-top: 2px">${waybill.order.sender}<span
						style="float: right; padding-right: 10px">${waybill.order.senderPhone}</span>
				</div>
				<div style="padding-left: 10px; padding-top: 2px">${waybill.order.senderAddress}</div>

				<div style="color: #778899; padding-left: 10px; padding-top: 5px;">
					收件方：${waybill.order.receiver}</div>
				<div style="padding-left: 10px; padding-top: 2px">${waybill.order.receiver}<span
						style="float: right; padding-right: 10px">${waybill.order.receiverPhone}</span>
				</div>
				<div style="padding-left: 10px; padding-top: 2px">${waybill.order.receivingAddress}</div>

				<hr
					style="height: 1px; border: none; border-top: 1px solid #555555;" />
				<div style="color: #778899; padding-left: 10px; padding-top: 2px;">
					托寄物：<font color="#000000">${waybill.order.resSort}</font>
				</div>
				<div style="color: #778899; padding-left: 10px; padding-top: 3px;">
					计费重量：<font color="#000000">${waybill.order.weight}kg</font>
				</div>
				<div style="color: #778899; padding-left: 10px; padding-top: 3px;">
					<c:if test="${waybill.order.insuredPrice==1}">已保价</c:if>
					<c:if test="${waybill.order.insuredPrice==0}">未保价</c:if>
				</div>
				<div
					style="color: #778899; padding-left: 10px; padding-top: 3px; padding-bottom: 5px;">
					运费：<font color="#000000">￥${waybill.order.freight}</font>
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
			<div class="b-line divHeight"></div>
			<!-- <div class="aui-shop-news">
				<h2>你可能还想买的</h2>
			</div>
			<div class="aui-shop-list aui-shop-list-selected">
				<a href="javascript:;" class="aui-shop-list-item">
					<div class="aui-shop-list-item-hd">
						<img src="images/icon-page-006.png" alt=""> <span
							class="aui-shop-list-item-tag">9色可选</span>
					</div>
					<div class="aui-shop-list-item-bd">
						<h3>鬼冢虎男鞋女鞋夏季新款运动鞋懒人休闲鞋低帮透气板鞋TH342N-0250 T</h3>
						<p class="aui-special-text">
							<em>特价</em> <span>118条评价98.9%</span>
						</p>
						<p class="aui-special-etc">
							<span class="aui-special-etc-hd">￥598</span> <span
								class="aui-special-etc-bd">￥898</span>
						</p>
					</div>
				</a> <a href="javascript:;" class="aui-shop-list-item">
					<div class="aui-shop-list-item-hd">
						<img src="images/icon-page-007.png" alt=""> <span
							class="aui-shop-list-item-tag">9色可选</span>
					</div>
					<div class="aui-shop-list-item-bd">
						<h3>鬼冢虎男鞋女鞋夏季新款运动鞋懒人休闲鞋低帮透气板鞋TH342N-0250 T</h3>
						<p class="aui-special-text">
							<em>特价</em> <span>118条评价98.9%</span>
						</p>
						<p class="aui-special-etc">
							<span class="aui-special-etc-hd">￥598</span> <span
								class="aui-special-etc-bd">￥898</span>
						</p>
					</div>
				</a> <a href="javascript:;" class="aui-shop-list-item">
					<div class="aui-shop-list-item-hd">
						<img src="images/icon-page-008.png" alt=""> <span
							class="aui-shop-list-item-tag">9色可选</span>
					</div>
					<div class="aui-shop-list-item-bd">
						<h3>鬼冢虎男鞋女鞋夏季新款运动鞋懒人休闲鞋低帮透气板鞋TH342N-0250 T</h3>
						<p class="aui-special-text">
							<em>特价</em> <span>118条评价98.9%</span>
						</p>
						<p class="aui-special-etc">
							<span class="aui-special-etc-hd">￥598</span> <span
								class="aui-special-etc-bd">￥898</span>
						</p>
					</div>
				</a> <a href="javascript:;" class="aui-shop-list-item">
					<div class="aui-shop-list-item-hd">
						<img src="images/icon-page-009.png" alt=""> <span
							class="aui-shop-list-item-tag">9色可选</span>
					</div>
					<div class="aui-shop-list-item-bd">
						<h3>鬼冢虎男鞋女鞋夏季新款运动鞋懒人休闲鞋低帮透气板鞋TH342N-0250 T</h3>
						<p class="aui-special-text">
							<em>特价</em> <span>118条评价98.9%</span>
						</p>
						<p class="aui-special-etc">
							<span class="aui-special-etc-hd">￥598</span> <span
								class="aui-special-etc-bd">￥898</span>
						</p>
					</div>
				</a> <a href="javascript:;" class="aui-shop-list-item">
					<div class="aui-shop-list-item-hd">
						<img src="images/icon-page-010.png" alt=""> <span
							class="aui-shop-list-item-tag">9色可选</span>
					</div>
					<div class="aui-shop-list-item-bd">
						<h3>鬼冢虎男鞋女鞋夏季新款运动鞋懒人休闲鞋低帮透气板鞋TH342N-0250 T</h3>
						<p class="aui-special-text">
							<em>特价</em> <span>118条评价98.9%</span>
						</p>
						<p class="aui-special-etc">
							<span class="aui-special-etc-hd">￥598</span> <span
								class="aui-special-etc-bd">￥898</span>
						</p>
					</div>
				</a> <a href="javascript:;" class="aui-shop-list-item">
					<div class="aui-shop-list-item-hd">
						<img src="images/icon-page-011.png" alt=""> <span
							class="aui-shop-list-item-tag">9色可选</span>
					</div>
					<div class="aui-shop-list-item-bd">
						<h3>鬼冢虎男鞋女鞋夏季新款运动鞋懒人休闲鞋低帮透气板鞋TH342N-0250 T</h3>
						<p class="aui-special-text">
							<em>特价</em> <span>118条评价98.9%</span>
						</p>
						<p class="aui-special-etc">
							<span class="aui-special-etc-hd">￥598</span> <span
								class="aui-special-etc-bd">￥898</span>
						</p>
					</div>
				</a> <a href="javascript:;" class="aui-shop-list-item">
					<div class="aui-shop-list-item-hd">
						<img src="images/icon-page-012.png" alt=""> <span
							class="aui-shop-list-item-tag">9色可选</span>
					</div>
					<div class="aui-shop-list-item-bd">
						<h3>鬼冢虎男鞋女鞋夏季新款运动鞋懒人休闲鞋低帮透气板鞋TH342N-0250 T</h3>
						<p class="aui-special-text">
							<em>特价</em> <span>118条评价98.9%</span>
						</p>
						<p class="aui-special-etc">
							<span class="aui-special-etc-hd">￥598</span> <span
								class="aui-special-etc-bd">￥898</span>
						</p>
					</div>
				</a> <a href="javascript:;" class="aui-shop-list-item">
					<div class="aui-shop-list-item-hd">
						<img src="images/icon-page-013.png" alt=""> <span
							class="aui-shop-list-item-tag">9色可选</span>
					</div>
					<div class="aui-shop-list-item-bd">
						<h3>鬼冢虎男鞋女鞋夏季新款运动鞋懒人休闲鞋低帮透气板鞋TH342N-0250 T</h3>
						<p class="aui-special-text">
							<em>特价</em> <span>118条评价98.9%</span>
						</p>
						<p class="aui-special-etc">
							<span class="aui-special-etc-hd">￥598</span> <span
								class="aui-special-etc-bd">￥898</span>
						</p>
					</div>
				</a> <a href="javascript:;" class="aui-shop-list-item">
					<div class="aui-shop-list-item-hd">
						<img src="images/icon-page-014.png" alt=""> <span
							class="aui-shop-list-item-tag">9色可选</span>
					</div>
					<div class="aui-shop-list-item-bd">
						<h3>鬼冢虎男鞋女鞋夏季新款运动鞋懒人休闲鞋低帮透气板鞋TH342N-0250 T</h3>
						<p class="aui-special-text">
							<em>特价</em> <span>118条评价98.9%</span>
						</p>
						<p class="aui-special-etc">
							<span class="aui-special-etc-hd">￥598</span> <span
								class="aui-special-etc-bd">￥898</span>
						</p>
					</div>
				</a> <a href="javascript:;" class="aui-shop-list-item">
					<div class="aui-shop-list-item-hd">
						<img src="images/icon-page-015.png" alt=""> <span
							class="aui-shop-list-item-tag">9色可选</span>
					</div>
					<div class="aui-shop-list-item-bd">
						<h3>鬼冢虎男鞋女鞋夏季新款运动鞋懒人休闲鞋低帮透气板鞋TH342N-0250 T</h3>
						<p class="aui-special-text">
							<em>特价</em> <span>118条评价98.9%</span>
						</p>
						<p class="aui-special-etc">
							<span class="aui-special-etc-hd">￥598</span> <span
								class="aui-special-etc-bd">￥898</span>
						</p>
					</div>
				</a> <a href="javascript:;" class="aui-shop-list-item">
					<div class="aui-shop-list-item-hd">
						<img src="images/icon-page-016.png" alt=""> <span
							class="aui-shop-list-item-tag">9色可选</span>
					</div>
					<div class="aui-shop-list-item-bd">
						<h3>鬼冢虎男鞋女鞋夏季新款运动鞋懒人休闲鞋低帮透气板鞋TH342N-0250 T</h3>
						<p class="aui-special-text">
							<em>特价</em> <span>118条评价98.9%</span>
						</p>
						<p class="aui-special-etc">
							<span class="aui-special-etc-hd">￥598</span> <span
								class="aui-special-etc-bd">￥898</span>
						</p>
					</div>
				</a> <a href="javascript:;" class="aui-shop-list-item">
					<div class="aui-shop-list-item-hd">
						<img src="images/icon-page-017.png" alt=""> <span
							class="aui-shop-list-item-tag">9色可选</span>
					</div>
					<div class="aui-shop-list-item-bd">
						<h3>鬼冢虎男鞋女鞋夏季新款运动鞋懒人休闲鞋低帮透气板鞋TH342N-0250 T</h3>
						<p class="aui-special-text">
							<em>特价</em> <span>118条评价98.9%</span>
						</p>
						<p class="aui-special-etc">
							<span class="aui-special-etc-hd">￥598</span> <span
								class="aui-special-etc-bd">￥898</span>
						</p>
					</div>
				</a>
			</div> -->
		</section>
		<!-- <footer class="aui-footer aui-footer-fixed">
			<div class="aui-artificial" >
				<i class="icon icon-air"></i> 人工客服
			</div>
		</footer> -->
	</section>
	<script src="${ctx}/qtCustomer/js/jquery.min.js"></script>
	<script type="text/javascript">
		window.alert = function(name) {
			var iframe = document.createElement("IFRAME");
			iframe.style.display = "none";
			iframe.setAttribute("src", 'data:text/plain,');
			document.documentElement.appendChild(iframe);
			window.frames[0].window.alert(name);
			iframe.parentNode.removeChild(iframe);
		};

		window.confirm = function(message) {
			var iframe = document.createElement("IFRAME");
			iframe.style.display = "none";
			iframe.setAttribute("src", 'data:text/plain,');
			document.documentElement.appendChild(iframe);
			var alertFrame = window.frames[0];
			var result = alertFrame.window.confirm(message);
			iframe.parentNode.removeChild(iframe);
			return result;
		};
		function copyArticle(event) {
			const range = document.createRange();
			range.selectNode(document.getElementById('waybillId'));

			const selection = window.getSelection();
			if (selection.rangeCount > 0)
				selection.removeAllRanges();
			selection.addRange(range);
			document.execCommand('copy');
			alert("复制成功！");
		}
		document.getElementById('copyBT').addEventListener('click',
				copyArticle, false);
	</script>
</body>
</html>
