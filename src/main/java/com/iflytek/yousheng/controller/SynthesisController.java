package com.iflytek.yousheng.controller;

import com.iflytek.yousheng.model.SynthesisRequestEntity;
import com.iflytek.yousheng.synthesis.svc.api.ISynthesisSvc;
import com.iflytek.yousheng.synthesis.svc.api.model.SynthInfo;
import com.iflytek.yousheng.synthesis.svc.api.model.req.WorksSynthAddReq;
import com.iflytek.yousheng.synthesis.svc.api.model.req.WorksSynthQryReq;
import com.iflytek.yousheng.synthesis.svc.api.model.resp.WorksSynthAddResp;
import com.iflytek.yousheng.synthesis.svc.api.model.resp.WorksSynthQryResp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author luliu3 on 2016/8/16.
 */
@Controller
public class SynthesisController {

    @Resource
    private ISynthesisSvc synthesisSvc;

    // 合成回复
    private WorksSynthAddResp resp;
    // 日志

    @RequestMapping(value = "synthesis")
    public ModelAndView synthesisView() {

        ModelAndView view = new ModelAndView();
        view.setViewName("synthesis/synthesis");
        return view;
    }

    @RequestMapping(value = "do_synthesis", method = RequestMethod.POST)
    public ResponseEntity doSynthesis(@RequestBody SynthesisRequestEntity requestEntity) {
        // 构造合成模型
        SynthInfo synthInfo = new SynthInfo();

        synthInfo.setSpeakingText(requestEntity.getContent());
        synthInfo.setSpeakerNo(requestEntity.getSpeakerNo());
        synthInfo.setBgmusicNo(requestEntity.getBgmNo());

        /*synthInfo.setSpeakerNo(10055);
        synthInfo.setBgmusicNo(100000);*/

        synthInfo.setSpeakingRate(100);
        synthInfo.setSpeakingVolumn(500);


        // 添加到待合成列表
        List<SynthInfo> synthInfos = new ArrayList<SynthInfo>();
        synthInfos.add(synthInfo);

        // 构造请求
        WorksSynthAddReq req = new WorksSynthAddReq();
        req.setChannelNo(1234);
        req.setIsSampleWorks(1);
        req.setWorksType(1);
        req.setSynthInfos(synthInfos);

        // 构造回复
        resp = synthesisSvc.synthesisTempWorks(req);
        return new ResponseEntity<WorksSynthAddResp>(resp, HttpStatus.OK);
    }

    @RequestMapping(value = "qry_progress")
    public ResponseEntity queryProgress() {

        // 构造查询
        WorksSynthQryReq qryReq = new WorksSynthQryReq();
        qryReq.setChannelNo(1234);
        qryReq.setTempWorksId(resp.getTempWorksId());

        // 构造查询回复
        WorksSynthQryResp qryResp = synthesisSvc.qrySynthesisTempWorks(qryReq);

        return new ResponseEntity<WorksSynthQryResp>(qryResp, HttpStatus.OK);
    }

}
