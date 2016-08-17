package com.iflytek.yousheng.model;

/**
 * @author luliu3 on 2016/8/16.
 */
public class SynthesisRequestEntity {
    private String content;
    private Integer speakerNo;
    private Integer bgmNo;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSpeakerNo() {
        return speakerNo;
    }

    public void setSpeakerNo(Integer speakerNo) {
        this.speakerNo = speakerNo;
    }

    public Integer getBgmNo() {
        return bgmNo;
    }

    public void setBgmNo(Integer bgmNo) {
        this.bgmNo = bgmNo;
    }
}
