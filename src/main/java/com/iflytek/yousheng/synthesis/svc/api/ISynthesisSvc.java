package com.iflytek.yousheng.synthesis.svc.api;

import com.iflytek.yousheng.synthesis.svc.api.model.req.WorksSynthAddReq;
import com.iflytek.yousheng.synthesis.svc.api.model.req.WorksSynthQryReq;
import com.iflytek.yousheng.synthesis.svc.api.model.resp.WorksSynthAddResp;
import com.iflytek.yousheng.synthesis.svc.api.model.resp.WorksSynthQryResp;

/**
 * @author luliu3 on 2016/8/16.
 */
public interface ISynthesisSvc {
    /**
     * 添加合成临时作品
     * 1.支持背景音混音
     * 2.音频前尾添加防伪内容
     * 3.音频前部 尾部 需要有N秒的背景音逐渐淡出,才播放合成内容
     * 4.支持大内容合成(分段合成+合并+背景音连贯),并返回当前实时的进度
     * 5.能后台自己上传到指定的服务器上
     */
    WorksSynthAddResp synthesisTempWorks(WorksSynthAddReq req);

    /**
     * 查询合成的临时作品
     *
     * @param req
     * @return
     */
    WorksSynthQryResp qrySynthesisTempWorks(WorksSynthQryReq req);
}
