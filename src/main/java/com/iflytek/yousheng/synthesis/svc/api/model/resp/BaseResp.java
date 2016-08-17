package com.iflytek.yousheng.synthesis.svc.api.model.resp;

import java.io.Serializable;

/**
 * @author luliu3 on 2016/8/16.
 */
public class BaseResp implements Serializable {
    private String retCode;
    private String retMsg;

    public void setRetCode(String retCode){
        this.retCode = retCode;
    }

    public String getRetCode(){
        return this.retCode;
    }

    public void setRetMsg(String retMsg){
        this.retMsg = retMsg;
    }

    public String getRetMsg(){
        return this.retMsg;
    }



    @Override
    public String toString(){
        return String.format("retCode:%s,retMsg:%s", retCode, retMsg);
    }
}

