package com.iflytek.yousheng.synthesis.svc.api.model.req;

import java.io.Serializable;

/**
 * @author luliu3 on 2016/8/16.
 */
public class WorksSynthQryReq extends BaseReq implements Serializable {
    private String tempWorksId;

    public String getTempWorksId() {
        return tempWorksId;
    }

    public void setTempWorksId(String tempWorksId) {
        this.tempWorksId = tempWorksId;
    }

    @Override
    public String toString() {
        return "WorksSynthQryReq{" + super.toString() + " " +
                "tempWorksId='" + tempWorksId + '\'' +
                '}';
    }
}