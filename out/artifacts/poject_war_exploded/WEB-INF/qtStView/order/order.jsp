<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的订单</title>
    <meta
            content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0"
            name="viewport"/>
    <meta content="yes" name="apple-mobile-web-app-capable"/>
    <meta content="black" name="apple-mobile-web-app-status-bar-style"/>
    <meta content="telephone=no" name="format-detection"/>
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
        <a href="${ctx}/qtStaff/staff/index.do" class="aui-navBar-item">
            <i class="aui-icon icon-return"></i>
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
                <li class="tab-nav-item tab-active"><a href="javascript:;">待接单</a>
                </li>
                <li class="tab-nav-item"><a href="javascript:;">待付款</a></li>
                <li class="tab-nav-item"><a href="javascript:;">待揽件</a></li>
                <li class="tab-nav-item"><a href="javascript:;">已揽件</a></li>
                <li class="tab-nav-item"><a href="javascript:;">已完成</a></li>

            </ul>

            <div class="tab-panel">
                <!-- 待接单 -->
                <div class="tab-panel-item tab-active">
                    <div class="mui-content">

                        <ul class="mui-table-view">
                            <c:forEach items="${waybills}" var="waybill">
                            <c:if test="${waybill.receiptTime eq null}">
                            <c:if test="${waybill.order.staffId eq null}">
                            <li class="mui-table-view-cell">
                                <div class="mui-slider-handle">
                                    <div class="mui-slider-right mui-disabled">
                                        <a class="mui-btn mui-btn-red"
                                           href="${ctx}/qtStaff/order/jiedan.do?orderId=${waybill.order.orderId}">接单</a>
                                        <div class="aui-flex">
                                                <%--     <a href="${ctx}/qtCustomer/order/orderTracking.do?waybill_id=${waybill.waybillId}"> --%>
                                            <a
                                                    href="${ctx}/qtCustomer/order/orderTracking.do?waybill_id=${waybill.waybillId}">
                                                <div class="aui-flex-box">
                                                    <h2>
                                                        <font color="#808080">运单号：</font>${waybill.waybillId }</h2>
                                                    <span style="float: r"></span>

                                                    <div style="height: 5px"></div>
                                                    <div class="aui-flex-track">
																<span class="aui-flex-track-span"
                                                                      style="text-align: center;"> <!-- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
																	${waybill.order.sender}&nbsp;&nbsp;&nbsp;<i
                                                                            class="aui-arrow-right"></i>&nbsp;&nbsp;&nbsp;&nbsp;${waybill.order.receiver}
																</span>

                                                    </div>

                                                    <p>
                                                        下单时间：
                                                        <fmt:formatDate type="both" dateStyle="medium"
                                                                        timeStyle="medium"
                                                                        value="${waybill.order.orderTime}"/>
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
                                </div>
                                </c:if>
                                </c:if>
                                </c:forEach>
                        </ul>
                    </div>
                </div>
                <!-- end -->

                <!-- 待付款 -->
                <div class="tab-panel-item">
                    <div class="mui-content">
                        <ul class="mui-table-view">
                            <c:forEach items="${waybills}" var="waybill">
                                <c:if test="${waybill.order.staffId eq staff.staffId}">
                                    <c:if test="${waybill.paymentTime eq null}">
                                        <li class="mui-table-view-cell">
                                                <%-- <div class="mui-slider-right mui-disabled">
                                                    <a class="mui-btn mui-btn-red"
                                                        href="${ctx}/qtStaff/order/lanjian.do?waybillId=${waybill.order.orderId}">揽件</a>
                                                </div> --%>
                                            <div class="mui-slider-handle">
                                                <div class="aui-flex">
                                                    <a
                                                            href="${ctx}/qtCustomer/order/orderTracking.do?waybill_id=${waybill.waybillId}">
                                                        <div class="aui-flex-box">
                                                            <h2>
                                                                <font color="#808080">运单号：</font>${waybill.waybillId }
                                                            </h2>

                                                            <span style="float: r"></span>

                                                            <div style="height: 5px"></div>
                                                            <div class="aui-flex-track">
																	<span class="aui-flex-track-span"
                                                                          style="text-align: center;">
																		${waybill.order.sender}&nbsp;&nbsp;&nbsp;<i
                                                                            class="aui-arrow-right"></i>&nbsp;&nbsp;&nbsp;&nbsp;${waybill.order.receiver}
																	</span>

                                                            </div>

                                                            <p>
                                                                下单时间：
                                                                <fmt:formatDate type="both" dateStyle="medium"
                                                                                timeStyle="medium"
                                                                                value="${waybill.order.orderTime}"/>
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
                                    </c:if>
                                </c:if>
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
                                <c:if test="${waybill.order.staffId eq staff.staffId}">
                                    <c:if test="${waybill.confirmTime eq null}">
                                        <li class="mui-table-view-cell">
                                            <div class="mui-slider-handle">
                                                <div class="mui-slider-right mui-disabled">
                                                    <a class="mui-btn mui-btn-red"
                                                       href="${ctx}/qtStaff/order/lanjianjiemian.do?waybillId=${waybill.waybillId}">揽件</a>
                                                </div>
                                                <div class="aui-flex">
                                                    <a
                                                            href="${ctx}/qtCustomer/order/orderTracking.do?waybill_id=${waybill.waybillId}">
                                                        <div class="aui-flex-box">
                                                            <h2>
                                                                <font color="#808080">运单号：</font>${waybill.waybillId }
                                                            </h2>
                                                            <span style="float: r"></span>

                                                            <div style="height: 5px"></div>
                                                            <div class="aui-flex-track">
																	<span class="aui-flex-track-span"
                                                                          style="text-align: center;">
																		${waybill.order.sender}&nbsp;&nbsp;&nbsp;<i
                                                                            class="aui-arrow-right"></i>&nbsp;&nbsp;&nbsp;&nbsp;${waybill.order.receiver}
																	</span>

                                                            </div>

                                                            <p>
                                                                下单时间：
                                                                <fmt:formatDate type="both" dateStyle="medium"
                                                                                timeStyle="medium"
                                                                                value="${waybill.order.orderTime}"/>
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
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <!-- end -->
                <!-- 已揽件 -->
                <div class="tab-panel-item">
                    <div class="mui-content">
                        <ul class="mui-table-view">
                            <c:forEach items="${waybills}" var="waybill">
                                <c:if test="${waybill.finishTime eq null}">
                                    <c:if test="${waybill.order.dotId eq staff.dotId}">
                                        <c:if test="${waybill.confirmTime ne null}">
                                            <li class="mui-table-view-cell">
                                                    <%-- 	<div class="mui-slider-right mui-disabled">
                                                    <a class="mui-btn mui-btn-red"
                                                        href="${ctx}/qtStaff/order/lanjian.do?waybillId=${waybill.order.orderId}">取消</a>
                                                </div> --%>
                                                <div class="mui-slider-handle">
                                                    <div class="aui-flex">
                                                        <a
                                                                href="${ctx}/qtCustomer/order/orderTracking.do?waybill_id=${waybill.waybillId}">
                                                            <div class="aui-flex-box">
                                                                <h2>
                                                                    <font color="#808080">运单号：</font>${waybill.waybillId }
                                                                </h2>
                                                                <span style="float: r"></span>

                                                                <div style="height: 5px"></div>
                                                                <div class="aui-flex-track">
																		<span class="aui-flex-track-span"
                                                                              style="text-align: center;">
																			${waybill.order.sender}&nbsp;&nbsp;&nbsp;<i
                                                                                class="aui-arrow-right"></i>&nbsp;&nbsp;&nbsp;&nbsp;${waybill.order.receiver}
																		</span>

                                                                </div>

                                                                <p>
                                                                    下单时间：
                                                                    <fmt:formatDate type="both" dateStyle="medium"
                                                                                    timeStyle="medium"
                                                                                    value="${waybill.order.orderTime}"/>
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
                                        </c:if>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <!-- end -->


                <!-- 已完成 -->
                <div class="tab-panel-item">
                    <div class="mui-content">
                        <ul class="mui-table-view">
                            <c:forEach items="${waybills}" var="waybill">
                                <c:if test="${waybill.finishTime ne null}">
                                    <c:if test="${waybill.order.staffId eq staff.staffId}">
                                        <c:if test="${waybill.confirmTime ne null}">
                                            <li class="mui-table-view-cell">

                                                <div class="mui-slider-handle">
                                                    <div class="aui-flex">
                                                        <a
                                                                href="${ctx}/qtCustomer/order/orderTracking.do?waybill_id=${waybill.waybillId}">
                                                            <div class="aui-flex-box">
                                                                <h2>
                                                                    <font color="#808080">运单号：</font>${waybill.waybillId }
                                                                </h2>
                                                                <span style="float: r"></span>

                                                                <div style="height: 5px"></div>
                                                                <div class="aui-flex-track">
																		<span class="aui-flex-track-span"
                                                                              style="text-align: center;">
																			${waybill.order.sender}&nbsp;&nbsp;&nbsp;<i
                                                                                class="aui-arrow-right"></i>&nbsp;&nbsp;&nbsp;&nbsp;${waybill.order.receiver}
																		</span>

                                                                </div>

                                                                <p>
                                                                    下单时间：
                                                                    <fmt:formatDate type="both" dateStyle="medium"
                                                                                    timeStyle="medium"
                                                                                    value="${waybill.order.orderTime}"/>
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
                                        </c:if>
                                    </c:if>
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

<script type="text/javascript"
        src="${ctx}/qtCustomer/themes/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/qtCustomer/themes/js/tab.js"></script>
<script type="text/javascript">
    function jiedan(waybillId) {
        var data = {
            "waybillId": waybillId
        };
        $.post(getContextPath() + "/qtStaff/order/jiedan.do", data,
            function (msg) {
                if (msg == 1) {
                    history.go(0);
                } else {
                    alert("已有人接单！")

                }
            })
    }

    window.alert = function (name) {
        var iframe = document.createElement("IFRAME");
        iframe.style.display = "none";
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
</script>
</body>
</html>

