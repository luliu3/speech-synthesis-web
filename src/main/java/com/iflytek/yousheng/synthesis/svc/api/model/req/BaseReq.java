package com.iflytek.yousheng.synthesis.svc.api.model.req;

import java.io.Serializable;

/**
 * @author luliu3 on 2016/8/16.
 */
@SuppressWarnings("serial")
public class BaseReq implements Serializable {
    /**
     * 渠道编号(6位数值)
     */
    private Integer channelNo;

    public BaseReq() {
    }

    public BaseReq(Integer channelNo) {
        this.channelNo = channelNo;
    }

    public Integer getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(Integer channelNo) {
        this.channelNo = channelNo;
    }

    @Override
    public String toString() {
        return String.format("channelNo:%s", channelNo);
    }
}
