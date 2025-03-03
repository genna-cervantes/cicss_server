
package ust.com.cicss.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeBlock implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("start")
    private String start;
    @JsonProperty("end")
    private String end;

    public TimeBlock() {
    }

    public TimeBlock(String start, String end) {
        this.start = start;
        this.end = end;
    }

    public String getStartTime() {
        return start;
    }

    public void setStartTime(String start) {
        this.start = start;
    }

    public String getEndTime() {
        return end;
    }

    public void setEndTime(String end) {
        this.end = end;
    }
}
