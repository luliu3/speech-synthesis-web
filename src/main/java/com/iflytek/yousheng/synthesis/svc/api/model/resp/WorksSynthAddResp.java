package com.iflytek.yousheng.synthesis.svc.api.model.resp;

import java.io.Serializable;

/**
 * @author luliu3 on 2016/8/16.
 */
public class WorksSynthAddResp extends BaseResp implements Serializable {
    private String tempWorksId;

    public String getTempWorksId() {
        return tempWorksId;
    }

    public void setTempWorksId(String tempWorksId) {
        this.tempWorksId = tempWorksId;
    }

    @Override
    public String toString() {
        return "WorksSynthAddResp{" + super.toString() + " " +
                "tempWorksId='" + tempWorksId + '\'' +
                '}';
    }
}
