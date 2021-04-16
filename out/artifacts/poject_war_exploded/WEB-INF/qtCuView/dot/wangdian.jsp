<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
    <title>网点</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="full-screen" content="yes">
    <meta name="browsermode" content="application">
    <meta name="x5-fullscreen" content="true">
    <meta name="x5-page-mode" content="app">
    <link rel="stylesheet" type="text/css"
          href="${ctx}/qtCustomer/css/lxs_index.css"/>
    <link rel="stylesheet" type="text/css"
          href="${ctx}/qtCustomer/css/lxsHeadFoot.css">
    <link rel="stylesheet" type="text/css"
          href="${ctx}/qtCustomer/css/order_new.css"/>
    <script src="${ctx}/qtCustomer/js/jquery-2.1.4.min.js"></script>
    <script src="${ctx}/qtCustomer/js/lxs_index00.js"></script>
    <link href="${ctx}/qtCustomer/css/style2.css" rel="stylesheet"
          type="text/css"/>
    <link rel="stylesheet" href="${ctx}/qtCustomer/css/style5.css"/>
    <script type="text/javascript" src="${ctx}/qtCustomer/js/tab.js"></script>
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

        .chaxun {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            width: 90%;
            margin-top: 10%;

        .
        jieguo {
        }

        }
    </style>
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
                class="iconBack"></i></a><span>网点查询</span>
    </div>
</div>


<div class="j_main m-main">


    <li class="lis">
        <!--选择地区-->
        <section class="express-area">
            <a id="expressArea" href="javascript:void(0)">
                <dl>
                    <dt>请选择</dt>
                    <dd id="address">省 - 市</dd>
                </dl>
            </a>
            <a id="dotxuanzhe" style="display:none;">
                <dl>
                    <dt>网点选择</dt>
                    <dd><select class="leibie" id="dotName" onchange="wdNamexuanzhe();">
                    </select>

                    </dd>
                </dl>
            </a>
        </section> <!--选择地区弹层-->
        <section id="areaLayer" class="express-area-box">
            <article id="areaBox">
                <!-- <ul class="remen" id="remen">
        <li class="lastli">热门城市</li>
        <li class="list">北京</li>
        <li class="list">上海</li>
        <li class="list">广州</li>
        <li class="list">深圳</li>
        <li class="list">天津</li>
        <li class="list">重庆</li>
    </ul> -->
                <div class="top">
                    <h3>选择城市</h3>
                </div>
                <ul id="areaList" class="area-list" style="margin-bottom: 500px;"></ul>
            </article>
        </section> <!--遮罩层-->
        <div id="areaMask" class="mask"></div>
    </li>
    <div id="" style="text-align: center;">
        <button type="button" class="chaxun" onclick="dotselect();">
            查询
        </button>
    </div>

    <div class="jieguo" style="font-size: 15px;">
        <p style="margin-top: 10%;">查询结果(目前只开放广东省广州市):</p>
        <hr
                style="height: 5px; border: none; border-top: 5px solid #F0F8FF;">
        <!-- <div class="txt">
            <dt>名字</dt>
            <dt>地址</dt>

        </div> -->
        <div id="liebiao">
        </div>

        <div id="liebiao2" style="display:none;">

        </div>
    </div>
    </form>
</div>

<script src="${ctx}/qtCustomer/js/jquery.min.js"></script>
<script src="${ctx}/qtCustomer/js/city.js"></script>
<script src="${ctx}/qtCustomer/js/address.js"></script>
<script src="${ctx}/qtCustomer/js/min_com.js"></script>
<script src="${ctx}/qtCustomer/js/order_xianlu.js"></script>
<script type="text/javascript"
        src="${ctx}/qtCustomer/js/jquery.area.js"></script>
<script>
    var is_dijie = '0'; /*预定须知弹窗*/
    var cart_type_num = 0;
    var myScroll;
    var mobiletel_regexp = /^1[3|4|5|7|8|9][0-9]\d{8}$/;

    /* function loaded() {
        myScroll = new iScroll('contentWrapper');
    } */
    function bodyscroll(e) {
        e.preventDefault();
    }

    /*  document.addEventListener('DOMContentLoaded', function() {
     setTimeout(loaded, 200);
     }, false); */
    $('.btn_notes').click(function () {
        $('.notes_con').show();
        setTimeout(loaded, 300);
        document.addEventListener('touchmove', bodyscroll, false);
    });
    $('.notes_con').click(function () {
        $(this).hide();
        document.removeEventListener('touchmove', bodyscroll, false);
    }); /*60秒倒计时*/
    var wait = 60;

    function time_d(t) {
        if (wait == 0) {
            $(t).removeAttr("disabled").html("获取验证码");
            wait = 60;
        } else {
            $(t).attr("disabled", "disabled").html(wait + '秒后重新发送')
                .addClass('disable');
            wait--;
            setTimeout(function () {
                time_d(t);
            }, 1000);
        }
    } /*游客信息检测*/

    function tourist_check() {
        var tourist_list = $(".j_kehu_open"), type = 1;
        for (var j = 0; j < tourist_list.length; j++) {
            var tr = tourist_list.eq(j);
            if (!tr.data('full')) {
                alert('请填写<b style="color:#FFF000">游客' + (j + 1)
                    + '</b>的信息');
                type = 0;
                break;
            }
        }
        ;
        return type ? true : false;
    }; /*异步核对验证码*/

    function mobiletel_code_check() {
        var ajax_url = '/order/checkCode', code = $('input[name="code"]')
            .val(), mobiletel = $('input[name="mobiletel"]').val();
        if (mobiletel == '') {
            alert('请输入手机号码');
            return false;
        } else if (!checkMobile(mobiletel)) {
            alert('请输入正确的手机号码');
            return false;
        } else if (code == '' || code.length != 6) {
            alert('请输入6位验证码');
            return false;
        }
        $('#save').addClass('not');
        $.ajax({
            url: ajax_url,
            type: 'post',
            data: {
                mobiletel: mobiletel,
                code: code,
                inajax: 1
            },
            dataType: 'json',
            success: function (data) { /*console.log(data);*/
                if (data == '1') {
                    alert('手机验证完毕');
                    document.form_1.submit();
                } else {
                    $('#save').removeClass('not');
                    if (data == '-1') {
                        alert('手机号码错误');
                        return false;
                    } else if (data == '-2') {
                        alert('验证码错误');
                        return false;
                    } else {
                        alert('意外错误');
                        return false;
                    }
                }
            },
            error: function () {
                $('#save').removeClass('not');
                alert('意外错误');
                return false
            }
        });
    }

    $(function () { /*表单提交*/
        $('#save')
            .click(
                function (e) {
                    e.stopPropagation();
                    if ($('#save').hasClass('not'))
                        return false;
                    var uid = parseInt($("#uid").val()); /*检测游客填写的身份信息*/
                    if (!tourist_check()) {
                        return false;
                    }
                    var true_name = $('input[name="truename"]')
                        .val(), mobiletel = $(
                        'input[name="mobiletel"]').val();
                    if (true_name == '') {
                        alert('联系人为必须填写项');
                        return false;
                    } else if (true_name.length < 2) {
                        alert('联系人过短，请重新输入');
                        return false;
                    } else if (true_name.length > 10) {
                        alert('联系人长度仅限10个字符，请重新输入');
                        return false;
                    } else if (mobiletel == '') {
                        alert('手机号码为必须填写项');
                        return false;
                    } else if (mobiletel.length != 11
                        || !mobiletel_regexp.test(mobiletel)) {
                        alert('手机号码不正确，请重新输入');
                        return false;
                    }
                    if (!$('.booking_notes i').hasClass('on')) {
                        alert('请阅读并同意此产品的预订须知');
                        return false;
                    }
                    if (uid == 0) {
                        mobiletel_code_check();
                    } else {
                        $('#save').addClass('not');
                        document.form_1.submit();
                    }
                }); /*发送手机验证码*/
        $(".mobile_code")
            .click(
                function () {
                    var th = $(this), tel = $("#n_mobiletel").val(), r_url = '/account/getcode?inajax=1&mobiletel='
                        + tel + '&idtype=4';
                    if (tel == '') {
                        alert('请先输入手机号码');
                        return false;
                    }
                    if (tel.length != 11
                        || !mobiletel_regexp.test(tel)) {
                        alert('手机号码不正确，请您重新输入');
                        return false
                    }
                    if (th.hasClass('not')) {
                        return false;
                    }
                    th.addClass('not');
                    setTimeout(function () {
                        th.removeClass('not');
                    }, 60000);
                    $.get(r_url, function (data) {
                        if (data == '1') {
                            alert('短信已发送，请查看');
                        } else if (data == '-1') {
                            alert('获取失败，手机号码不能为空');
                        } else if (data == '-2') {
                            alert('获取失败，手机号码错误');
                        } else if (data == '-3') {
                            alert('获取失败，该手机已被注册');
                        } else if (data == '-4') {
                            alert('您的操作太频繁，请稍候再试');
                        } else if (data == '-8') {
                            alert('同一ip一天最多10条短信');
                        } else if (data == '-5') {
                            alert('同一手机一个月最多5条短信');
                        } else if (data == '-6') {
                            alert('获取失败，获取验证时间间隔60秒');
                        } else {
                            alert('获取失败');
                        }
                    });
                }); /*改变证件类型事件*/
        $('#j_kehu_list').on(
            'change',
            '.tourist_box .certificate_type',
            function () {

                placeholder = mark + '号码（必填）';
                cur.closest('dl').next('dl').find('dt').html(mark)
                    .siblings('dd').find('input[type="text"]')
                    .attr('placeholder', placeholder);
            });
    });

    function guoqing_yh() {

    }

    /**
     * 默认调用
     */
    !function () {
        var $target = $('#J_Address');

        $target.citySelect();

        $target.on('click', function (event) {
            event.stopPropagation();
            $target.citySelect('open');
        });

        $target.on('done.ydui.cityselect', function (ret) {
            $(this).val(ret.provance + ' ' + ret.city + ' ' + ret.area);
        });
    }();
    /**
     * 设置默认值
     */
</script>
<script type="text/javascript">
    function dotselect() {
        var address = $("#address").text();

        console.log(address)
        var data = {
            "dotCity": address
        }
        console.log(data)
        $.post(getContextPath() + "/qtCustomer/dot/dotselect.do", data, function (msg) {
            /* let test = document.getElementById("test"); */
            /* console.log(test); */
            if (msg === "") {
                var item = "<p  style='text-align: center; margin-top: 50%; font-size: 20px;'>此城市无网点</p>";
                $("#liebiao").html(item)
            } else {
                /* $("#dotxuanzhe").show();
                $.post(getContextPath()+"/qtCustomer/dot/dotselectName.do",data,function(msg){

                }) */
                var selectOption = "<option value='0'>选择网点名</option>";
                $("#dotxuanzhe").show();
                $.each(msg, function (i, val) {
                    selectOption += "<option value=" + val.dotName + ">"
                        + val.dotName + "</option>"
                });
                $('#dotName').html(selectOption);

                var item;
                $("#liebiao").html("")
                $.each(msg, function (i, val) {
                    /* test.innerHTML += val.dotCity; */
                    item = "<div class='tab-item' style='text-align: left; margin-top: 2%;margin-bottom:2%; font-size: 18px; margin-left:5%'><div class='aui-well-item-bd'><b>" + val.dotName + "</b> " + val.dotPhone + "<p>" + val.dotAddress + "</p></div></div><hr style='height: 5px; border: none; border-top: 5px solid #F0F8FF;'></div>"
                    $("#liebiao").append(item)
                });
            }
        })
    }

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
<script type="text/javascript">
    function wdNamexuanzhe() {
        var a = $('#dotName option:selected').val();
        var data = {
            "dotName": a
        }
        if (a !== "0") {
            $("#liebiao").hide();
            $("#liebiao2").show();
            $.post(getContextPath() + "/qtCustomer/dot/dotNameSelect.do", data, function (msg) {
                var i;
                i = "<div class='tab-item' style='text-align: left; margin-top: 2%;margin-bottom:2%; font-size: 18px; margin-left:5%'><div class='aui-well-item-bd'><b>" + msg.dotName + "</b> " + msg.dotPhone + "<p>" + msg.dotAddress + "</p></div></div><hr style='height: 5px; border: none; border-top: 5px solid #F0F8FF;'></div>"
                $("#liebiao2").html(i)
            })
        }else {
            $("#liebiao").show();
        }

    }
</script>
</body>
</html>

