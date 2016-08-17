package com.iflytek.yousheng.synthesis.svc.api.model.resp;

import java.io.Serializable;

/**
 * @author luliu3 on 2016/8/16.
 */
public class WorksSynthQryResp extends BaseResp implements Serializable {
    private String tempWorksUrl;
    private String tempWorksText;
    private int synthPercent;

    public String getTempWorksUrl() {
        return tempWorksUrl;
    }

    public void setTempWorksUrl(String tempWorksUrl) {
        this.tempWorksUrl = tempWorksUrl;
    }

    public String getTempWorksText() {
        return tempWorksText;
    }

    public void setTempWorksText(String tempWorksText) {
        this.tempWorksText = tempWorksText;
    }

    public int getSynthPercent() {
        return synthPercent;
    }

    public void setSynthPercent(int synthPercent) {
        this.synthPercent = synthPercent;
    }

    @Override
    public String toString() {
        return "WorksSynthQryResp{" + super.toString() + " "+
                "tempWorksUrl='" + tempWorksUrl + '\'' +
                ", tempWorksText='" + tempWorksText + '\'' +
                ", synthPercent=" + synthPercent +
                '}';
    }
}