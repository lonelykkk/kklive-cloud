package com.kklive.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCountInfoDto {
    private Integer fansCount;
    private Integer currentCoinCount;
    private Integer focusCount;

    public Integer getFansCount() {
        return fansCount;
    }

    public void setFansCount(Integer fansCount) {
        this.fansCount = fansCount;
    }

    public Integer getCurrentCoinCount() {
        return currentCoinCount;
    }

    public void setCurrentCoinCount(Integer currentCoinCount) {
        this.currentCoinCount = currentCoinCount;
    }

    public Integer getFocusCount() {
        return focusCount;
    }

    public void setFocusCount(Integer focusCount) {
        this.focusCount = focusCount;
    }
}
