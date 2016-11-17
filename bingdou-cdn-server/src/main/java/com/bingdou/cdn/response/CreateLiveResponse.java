package com.bingdou.cdn.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gaoshan on 16-11-14.
 */
public class CreateLiveResponse {

    @SerializedName("push_url")
    private String pushUrl;

    @SerializedName("play_url")
    private String playUrl;

    public String getPushUrl() {
        return pushUrl;
    }

    public void setPushUrl(String pushUrl) {
        this.pushUrl = pushUrl;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }
}
