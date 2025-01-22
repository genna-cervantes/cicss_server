package com.example.cicss.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeBlock {

    @JsonProperty("startTime")
    private String startTime;
    @JsonProperty("endTime")
    private String endTime;

    public TimeBlock() {
    }

    public TimeBlock(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
