<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/16
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
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
    <h1 class="text-center">配音阁-合成工具</h1>

    <div class="">
        <form class="form-inline">
            <div class="form-group">
                <label>主播</label>
                <select class="form-control" id="speakerNo">
                    <option value="" selected>选择主播</option>
                    <option value="50004">[男] 小洋</option>
                    <option value="30004">[男] 小峰</option>
                    <option value="50006">[男] 小康</option>
                    <option value="51040">[男] 小彬</option>
                    <option value="30003">[女] 小燕</option>
                    <option value="50012">[女] 嘉嘉</option>
                    <option value="50011">[女] 小林</option>
                    <option value="51111">[童] 小爱</option>
                    <option value="30007">[童] 楠楠</option>
                    <option value="30011">[东北] 晓倩</option>
                    <option value="30014">[四川] 小蓉</option>
                    <option value="30015">[粤语] 小梅</option>
                    <option value="30024">[湖南] 小强</option>
                    <option value="30025">[河南] 小坤</option>
                    <option value="30017">[EN] John</option>
                    <option value="30020">[EN] 凯瑟琳</option>
                </select>

            </div>
            <div class="form-group">
                <label>背景音编号</label>
                <input type="number" class="form-control" id="bgmNo" placeholder="100000"/>
            </div>
        </form>
        <br/>

        <form>
            <div class="form-group">
                <label>合成文本</label>
                <textarea class="form-control" rows="5" id="content"></textarea>
            </div>
            <button type="button" class="btn btn-default" id="synthesis-btn">合成</button>
        </form>
    </div>
    <br/>

    <div class="progress" style="display: none" id="progress-parent">
        <div class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"
             style="width: 0;" id="progress">
            <span class="sr-only" id="progress-text">0</span>
        </div>
    </div>
    <div class="alert alert-info" style="display: none" id="ret-url"></div>
</div>


<script src="${base_url}/jquery-1.11.1/jquery-1.11.1.js"></script>
<script src="${base_url}/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="${base_url}/json2/json2.js"></script>

<script type="text/javascript">

    $('#synthesis-btn').click(function () {

        $('#progress-parent').hide();
        $('#ret-url').hide();
        $(this).text("合成中...");

        // 获取输入内容
        var input_speakerNo = $('#speakerNo');
        var input_bgmNo = $('#bgmNo');
        var input_content = $('#content');

        var speakerNo = input_speakerNo.val();
        var bgmNo = input_bgmNo.val();
        var content = input_content.val();

        // 检查输入
        if (isBlank(speakerNo)) {
            $(this).text("合成");
            alert('主播不能为空');
            input_speakerNo.focus();
            return;
        }
        if (isBlank(bgmNo)) {
            $(this).text("合成");
            alert('背景音不能为空');
            input_bgmNo.focus();
            return;
        }
        if (isBlank(content)) {
            $(this).text("合成");
            alert('文本不能为空');
            input_content.focus();
            return;
        }

        // 为json准备
        var data = {
            "speakerNo": speakerNo,
            "bgmNo": bgmNo,
            "content": content
        };

        // 合成地址
        var synthesis_url = '${base_url}/do_synthesis';

        // post到合成地址合成
        $.ajax(synthesis_url, {
            'headers': {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'type': 'POST',
            'data': JSON.stringify(data),
            'dataType': 'json',
            'success': check_progress()
        });
    });

    // 隔1s检查一次合成进度
    function check_progress() {
        var chk_progress = setInterval(function () {
            var progress_url = '${base_url}/qry_progress';
            $.getJSON(progress_url, function (ret_data) {
                // 显示进度条
                $('#progress-parent').show();
                var percent = ret_data.percentage;
                var div_progress = $('#progress');
                div_progress.attr("aria-valuenow", percent);
                div_progress.css("width", percent + '%');
                $('#progress-text').text(percent + '%');
                if (true === ret_data.status) {
                    var div_ret_url = $('#ret-url');
                    var ret_url = '<a target="_blank" href="' + ret_data.url + '">' + ret_data.url + '</a>';
                    div_ret_url.html(ret_url);
                    // 显示成品地址
                    div_ret_url.show();
                    clearInterval(chk_progress);
                    $('#synthesis-btn').text("合成");
                }
            });
        }, 1000);
    }

    // 检查输入是否为空
    function isBlank(val) {
        return val.replace(/(^\s*)|(\s*$)/g, "") == '';
    }

</script>

</body>
</html>
