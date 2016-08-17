package com.iflytek.yousheng;

import com.iflytek.yousheng.synthesis.svc.api.ISynthesisSvc;
import com.iflytek.yousheng.synthesis.svc.api.model.SynthInfo;
import com.iflytek.yousheng.synthesis.svc.api.model.req.WorksSynthAddReq;
import com.iflytek.yousheng.synthesis.svc.api.model.req.WorksSynthQryReq;
import com.iflytek.yousheng.synthesis.svc.api.model.resp.WorksSynthAddResp;
import com.iflytek.yousheng.synthesis.svc.api.model.resp.WorksSynthQryResp;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liquan on 16/8/4.
 */
public class SynthesisTest {
    @Resource
    private ISynthesisSvc synthesisSvc;

    public void addSynthesisTask(){
        WorksSynthAddReq req = new WorksSynthAddReq();
        req.setChannelNo(1234);
        req.setIsSampleWorks(1);
        req.setWorksType(1);
        List<SynthInfo> synthInfos = new ArrayList<SynthInfo>();

        SynthInfo synthInfo = new SynthInfo();
//        synthInfo.setSpeakingText("[dd30000]");
        synthInfo.setSpeakingText(" If you're creating controls with no the control itself.");
        synthInfo.setSpeakerNo(30020);
        synthInfo.setBgmusicNo(1001);
//        synthInfo.setSpeakingRate(500);
//        synthInfo.setSpeakingVolumn(500);

        String a = "记者从兰州城关交警大队了解到，据抽血检测显示，";
        SynthInfo synthInfo2 = new SynthInfo();
        synthInfo2.setSpeakingText("手上举，摆出“V”字型经典剪刀手的姿势。8日，记者从兰州城关交警大队了解到，据抽血检测显示，该名驾驶员蒋某血中乙醇含量为为245mg/100ml时，确定属醉酒驾驶。");
        synthInfo2.setSpeakerNo(10055);
        synthInfo2.setBgmusicNo(100000);
        synthInfo2.setSpeakingRate(100);
        synthInfo2.setSpeakingVolumn(500);

        synthInfos.add(synthInfo);
        //synthInfos.add(synthInfo2);
        req.setSynthInfos(synthInfos);

        WorksSynthAddResp resp = synthesisSvc.synthesisTempWorks(req);
        System.out.println(resp.toString());

        WorksSynthQryReq qryReq = new WorksSynthQryReq();
        qryReq.setChannelNo(1234);
        qryReq.setTempWorksId(resp.getTempWorksId());

        try {
            int i = 0;
            while (true) {
                WorksSynthQryResp qryResp = synthesisSvc.qrySynthesisTempWorks(qryReq);
                System.out.println(++i + "->"+ qryResp.toString());

                if (StringUtils.isNotBlank(qryResp.getTempWorksUrl()))
                    break;
                else
                    Thread.sleep(1000);
            }
        }catch (Throwable e){
            e.printStackTrace();
        }

    }
}

