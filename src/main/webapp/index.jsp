<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>配音阁-合成工具</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
    <link rel="stylesheet" href="${base_url}/bootstrap-3.3.7-dist/css/bootstrap.css"/>
    <link rel="stylesheet" href="${base_url}/bootstrap-3.3.7-dist/css/bootstrap-theme.css"/>
</head>
<body>

<div class="container">
    <h2 class="text-center">欢迎使用配音阁合成工具</h2>

    <h4 class="text-center">
        <span class="text-warning" id="time">3</span> 秒后跳转到
        <a href="${base_url}/synthesis">合成工具</a>
    </h4>
</div>

<script src="${base_url}/jquery-1.11.1/jquery-1.11.1.js"></script>
<script src="${base_url}/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script type="text/javascript">
    $(function()
    {
        var time = $('#time').text();
        var handleTime = setInterval(function()
        {
            time = time - 1;
            if (time == 0)
            {
                clearInterval(handleTime);
                window.top.location.href = '${base_url}/synthesis';
                return;
            }
            $('#time').text(time);
        }, 1000);
    });
</script>
</body>
</html>