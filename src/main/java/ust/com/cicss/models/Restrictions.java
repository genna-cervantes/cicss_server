package ust.com.cicss.models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Embeddable;

//@Embeddable
public class Restrictions {
    @JsonProperty("m")
    private ArrayList<TimeBlock> m;
    @JsonProperty("t")
    private ArrayList<TimeBlock> t;
    @JsonProperty("w")
    private ArrayList<TimeBlock> w;
    @JsonProperty("th")
    private ArrayList<TimeBlock> th;
    @JsonProperty("f")
    private ArrayList<TimeBlock> f;
    @JsonProperty("s")
    private ArrayList<TimeBlock> s;

    public Restrictions(){}

    public Restrictions(ArrayList<TimeBlock> m, ArrayList<TimeBlock> t, ArrayList<TimeBlock> w, ArrayList<TimeBlock> th, ArrayList<TimeBlock> f, ArrayList<TimeBlock> s) {
        this.m = m;
        this.t = t;
        this.w = w;
        this.th = th;
        this.f = f;
        this.s = s;
    }

    public ArrayList<TimeBlock> getM() {
        return m;
    }

    public void setM(ArrayList<TimeBlock> m) {
        this.m = m;
    }

    public ArrayList<TimeBlock> getT() {
        return t;
    }

    public void setT(ArrayList<TimeBlock> t) {
        this.t = t;
    }

    public ArrayList<TimeBlock> getW() {
        return w;
    }

    public void setW(ArrayList<TimeBlock> w) {
        this.w = w;
    }

    public ArrayList<TimeBlock> getTh() {
        return th;
    }

    public void setTh(ArrayList<TimeBlock> th) {
        this.th = th;
    }

    public ArrayList<TimeBlock> getF() {
        return f;
    }

    public void setF(ArrayList<TimeBlock> f) {
        this.f = f;
    }

    public ArrayList<TimeBlock> getS() {
        return s;
    }

    public void setS(ArrayList<TimeBlock> s) {
        this.s = s;
    }
}
