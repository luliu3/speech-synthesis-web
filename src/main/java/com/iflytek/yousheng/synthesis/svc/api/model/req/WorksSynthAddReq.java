package com.iflytek.yousheng.synthesis.svc.api.model.req;

import com.iflytek.yousheng.synthesis.svc.api.model.SynthInfo;

import java.io.Serializable;
import java.util.List;

/**
 * @author luliu3 on 2016/8/16.
 */
public class WorksSynthAddReq extends BaseReq implements Serializable {
    private int worksType;
    private int isSampleWorks;

    private List<SynthInfo> synthInfos;

    public int getIsSampleWorks() {
        return isSampleWorks;
    }

    public void setIsSampleWorks(int isSampleWorks) {
        this.isSampleWorks = isSampleWorks;
    }

    public int getWorksType() {
        return worksType;
    }

    public void setWorksType(int worksType) {
        this.worksType = worksType;
    }

    public List<SynthInfo> getSynthInfos() {
        return synthInfos;
    }

    public void setSynthInfos(List<SynthInfo> synthInfos) {
        this.synthInfos = synthInfos;
    }

    @Override
    public String toString() {
        return "WorksSynthAddReq{" + super.toString() + " " +
                "synthInfos.size=" + (synthInfos == null ? 0 :synthInfos.size()) +
                '}';
    }
}
