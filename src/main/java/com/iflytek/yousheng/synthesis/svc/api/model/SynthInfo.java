package com.iflytek.yousheng.synthesis.svc.api.model;

import java.io.Serializable;

/**
 * @author luliu3 on 2016/8/16.
 */
public class SynthInfo implements Serializable {
    private int speakerNo;

    private String speakingText;

    private int bgmusicNo;

    private int speakingRate;

    private int speakingVolumn;

    public int getSpeakerNo() {
        return speakerNo;
    }

    public void setSpeakerNo(int speakerNo) {
        this.speakerNo = speakerNo;
    }

    public String getSpeakingText() {
        return speakingText;
    }

    public void setSpeakingText(String speakingText) {
        this.speakingText = speakingText;
    }

    public int getBgmusicNo() {
        return bgmusicNo;
    }

    public void setBgmusicNo(int bgmusicNo) {
        this.bgmusicNo = bgmusicNo;
    }

    public int getSpeakingRate() {
        return speakingRate;
    }

    public void setSpeakingRate(int speakingRate) {
        this.speakingRate = speakingRate;
    }

    public int getSpeakingVolumn() {
        return speakingVolumn;
    }

    public void setSpeakingVolumn(int speakingVolumn) {
        this.speakingVolumn = speakingVolumn;
    }
}