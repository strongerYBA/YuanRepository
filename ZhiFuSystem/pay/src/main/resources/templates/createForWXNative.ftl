<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>二维码测试</title>
</head>
<body>
<p>微信Native支付</p>
<div id="myqrcode"></div>
<div id="orderId" hidden>${orderId}</div>
<div id="returnUrl" hidden>${returnUrl}</div>

<script src="https://cdn.bootcss.com/jquery/1.5.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/jquery.qrcode/1.0/jquery.qrcode.min.js"></script>
<script>
    jQuery('#myqrcode').qrcode({
        text	: "${codeUrl}"
    });
    $(function () {
        //定时器，不停请求后端api。2秒查询一次
        setInterval(function () {
            console.log('开始查询支付状态...')
            $.ajax({
                url:'/pay/queryOrderById',
                data:{
                    'orderId':$("#orderId").text()
                },
                success:function (result) {
                    console.log(result)
                        if(result.platformStatus != null
                        && result.platformStatus ==='SUCCESS'){
                        //跳转的地址。
                        location.href= $("#returnUrl").text();
                    }
                },
                error:function (result) {
                    alert(result)
                }
            })
        },2000)
    });
</script>

</body>

</html>