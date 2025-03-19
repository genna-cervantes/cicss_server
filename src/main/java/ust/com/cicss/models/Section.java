package ust.com.cicss.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Section implements Serializable {

    @JsonProperty("section")
    private String section;
    @JsonProperty("specialization")
    private String specialization;

    public Section(String section, String specialization){
        this.section = section;
        this.specialization = specialization;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}