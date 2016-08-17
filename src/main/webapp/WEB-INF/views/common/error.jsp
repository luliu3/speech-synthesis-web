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
    <c:if test="${not empty msg}">
        <h2 class="text-danger text-center">${msg}</h2>
    </c:if>
    <c:if test="${empty msg}">
        <h2 class="text-danger text-center">系统异常，请稍后再试！</h2>
    </c:if>
</div>
</body>
</html>