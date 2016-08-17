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
    <style type="text/css">
        .musicControl a {
            display: inline-block;
            width: 3em;
            height: 3em;
            overflow: hidden;
            background: url("${base_url}/images/pause.png") no-repeat;
            background-size: cover;
        }

        .musicControl a.stop {

            background: url('${base_url}/images/play.png') no-repeat;
            background-size: cover;
        }
    </style>
</head>
<body>

<div class="container">
    <h1 class="text-center">配音阁-合成工具</h1>

    <div class="">
        <form class="form-inline">
            <div class="form-group">
                <label for="speakerNo">主播</label>
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
                <label for="bgmNo">背景音编号</label>
                <input type="number" class="form-control" id="bgmNo" placeholder="100000"/>
            </div>
        </form>
        <br/>

        <form>
            <div class="form-group">
                <label for="content">合成文本</label>
                <textarea class="form-control" rows="10" onkeyup="word_count(450, 'content', 'word-count')"
                          id="content"></textarea>
            </div>
            <div class="media">
                <div class="media-body">
                    <button type="button" class="btn btn-default" id="synthesis-btn">合成</button>
                </div>
                <div class="media-right">
                    <span class="text text-right" id="word-count"></span>
                </div>
            </div>
            <div class="alert alert-danger" style="display: none" id="warning"></div>
        </form>
    </div>
    <br/>

    <div class="progress" style="display: none" id="progress-parent">
        <div class="progress-bar progress-bar-info progress-bar-striped" role="progressbar" aria-valuenow="0"
             aria-valuemin="0" aria-valuemax="100" style="width: 0;" id="progress">
            0%
        </div>
    </div>

    <div class="media" style="display: none" id="audition">
        <div class="media-body">
            <h4 class="media-heading" id="ret-url"></h4>
        </div>
        <div class="media-right" id="audio"></div>
    </div>

</div>


<script src="${base_url}/jquery-1.11.1/jquery-1.11.1.js"></script>
<script src="${base_url}/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="${base_url}/json2/json2.js"></script>
<script src="${base_url}/my-js/helper.js"></script>

<script type="text/javascript">
    // 点击合成
    $('#synthesis-btn').click(function () {

        var span_warning = $('#warning');
        span_warning.hide();
        $('#audition').hide();
        $('#progress-parent').hide();
        $(this).text("合成中...");
        $(this).attr("disabled", "disabled");

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
            span_warning.text('主播不能为空');
            span_warning.show();
            $(this).removeAttr("disabled");
            input_speakerNo.focus();
            return;
        }
        if (isBlank(bgmNo)) {
            $(this).text("合成");
            span_warning.text('背景音不能为空');
            span_warning.show();
            $(this).removeAttr("disabled");
            input_bgmNo.focus();
            return;
        }
        if (isBlank(content)) {
            $(this).text("合成");
            span_warning.text('文本不能为空');
            span_warning.show();
            $(this).removeAttr("disabled");
            input_content.focus();
            return;
        }
        if (content.length > 450) {
            $(this).text("合成");
            span_warning.text('合成文本长度不能超过450个字符');
            span_warning.show();
            $(this).removeAttr("disabled");
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
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url: synthesis_url,
            type: 'POST',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (return_data) {
                check_progress(return_data, '${base_url}');
            }
        });
    });

</script>
</body>
</html>
