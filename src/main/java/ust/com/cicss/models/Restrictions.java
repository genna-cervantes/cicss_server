package ust.com.cicss.models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Restrictions {
    private ArrayList M;
    private ArrayList T;
    private ArrayList W;
    private ArrayList TH;
    private ArrayList F;
    private ArrayList S;

    public Restrictions() {}

    public Restrictions(ArrayList M, ArrayList T, ArrayList W, ArrayList TH, ArrayList F, ArrayList S) {
        this.M = M;
        this.T = T;
        this.W = W;
        this.TH = TH;
        this.F = F;
        this.S = S;
    }

    @JsonProperty("M")
    public ArrayList getM() {
        return M;
    }

    public void setM(ArrayList M) {
        this.M = M;
    }

    @JsonProperty("T")
    public ArrayList getT() {
        return T;
    }

    public void setT(ArrayList T) {
        this.T = T;
    }

    @JsonProperty("W")
    public ArrayList getW() {
        return W;
    }

    public void setW(ArrayList W) {
        this.W = W;
    }

    @JsonProperty("TH")
    public ArrayList getTh() {
        return TH;
    }

    public void setTh(ArrayList TH) {
        this.TH = TH;
    }

    @JsonProperty("F")
    public ArrayList getF() {
        return F;
    }

    public void setF(ArrayList F) {
        this.F = F;
    }

    @JsonProperty("S")
    public ArrayList getS() {
        return S;
    }

    public void setS(ArrayList S) {
        this.S = S;
    }
}
