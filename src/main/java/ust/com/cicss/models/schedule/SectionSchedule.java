package ust.com.cicss.models.schedule;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SectionSchedule {
    @JsonProperty("days")
    private Map<String, List<ScheduleEntry>> days;

    public SectionSchedule() {
    }

    public SectionSchedule(Map<String, List<ScheduleEntry>> days) {
        this.days = days;
    }

    public Map<String, List<ScheduleEntry>> getDays() {
        return days;
    }

    public void setDays(Map<String, List<ScheduleEntry>> days) {
        this.days = days;
    }
}
