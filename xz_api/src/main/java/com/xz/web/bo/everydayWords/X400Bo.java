package com.xz.web.bo.everydayWords;

import java.io.Serializable;

public class X400Bo implements Serializable {

    private Long id;
    private String prevPic;
    private String speech;
    private String currentDate;
    private String nickName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrevPic() {
        return prevPic;
    }

    public void setPrevPic(String prevPic) {
        this.prevPic = prevPic;
    }

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
