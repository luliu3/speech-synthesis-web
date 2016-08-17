/**
 * Created by Administrator on 2016/8/17.
 */

// 隔1s检查一次合成进度
function check_progress(ret, base_url) {

    var btn_synthesis = $('#synthesis-btn');
    var span_warning = $('#warning');
    var span_audio = $('#audio');

    if (ret.retCode != '000000') {
        span_warning.text(ret.retMsg);
        span_warning.show();
        btn_synthesis.text("合成");
        btn_synthesis.removeAttr("disabled");
        return;
    } else {

        var chk_progress = setInterval(function () {
            var progress_url = base_url + '/qry_progress';

            $.getJSON(progress_url, function (ret_data) {

                if ('000000' === ret_data.retCode) {
                    // 显示进度条
                    $('#progress-parent').show();
                    var div_progress = $('#progress');

                    var percent = ret_data.synthPercent;
                    div_progress.attr("aria-valuenow", percent);
                    div_progress.css("width", percent + '%');
                    div_progress.text(percent + '%');

                    var ret_url = ret_data.tempWorksUrl;

                    if (ret_url != null) {

                        var div_ret_url = $('#ret-url');
                        div_ret_url.html('<a target="_blank" href="' + ret_url + '">' + ret_url + '</a>');


                        // 试听
                        span_audio.html(
                            '<span class="musicControl" class="media-object">' +
                            '<a style="cursor: pointer" class="stop" onclick="play_music(this);">' +
                            '<audio loop="">' +
                            '<source src="' + ret_url + '" type="audio/mpeg">' +
                            '</audio></a></span>'
                        );

                        // 显示试听
                        $('#audition').show();

                        clearInterval(chk_progress);
                        btn_synthesis.text("合成");
                        btn_synthesis.removeAttr("disabled");
                    }
                } else {
                    $('#warning').text(ret_data.retMsg);
                    clearInterval(chk_progress);
                    btn_synthesis.text("合成");
                    btn_synthesis.removeAttr("disabled");
                    return;
                }
            });
        }, 1000);
    }
}

function word_count(maxCount, textarea, span) {
    var count = maxCount - $('#' + textarea).val().length;
    var count_text = count + '/' + maxCount;
    $('#' + span).text(count_text);
}


// 检查输入是否为空
function isBlank(val) {
    return val.replace(/(^\s*)|(\s*$)/g, "") == '';
}

//播放按钮
function play_music(i) {
    var e = $(i);
    if (e.hasClass('on')) {
        e.find('audio').get(0).pause();
        e.attr('class', 'stop');
    } else {
        e.find('audio').get(0).play();
        e.attr('class', 'on');
    }
}