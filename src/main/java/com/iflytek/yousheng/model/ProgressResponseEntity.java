package com.iflytek.yousheng.model;

/**
 * @author luliu3 on 2016/8/16.
 */
public class ProgressResponseEntity {
    private Boolean status;
    private String description;
    private String url;
    private Integer percentage;

    public ProgressResponseEntity() {
    }

    public ProgressResponseEntity(Boolean status, String description, String url, Integer percentage) {
        this.status = status;
        this.description = description;
        this.url = url;
        this.percentage = percentage;
    }

    public Boolean isStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "ProgressResponseEntity{" +
                "status=" + status +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}