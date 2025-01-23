package ust.com.cicss.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Restrictions {
    @JsonProperty("M")
    private TimeBlock[] M;
    @JsonProperty("T")
    private TimeBlock[] T;
    @JsonProperty("W")
    private TimeBlock[] W;
    @JsonProperty("TH")
    private TimeBlock[] TH;
    @JsonProperty("F")
    private TimeBlock[] F;
    @JsonProperty("S")
    private TimeBlock[] S;

    public Restrictions(){}

    public Restrictions(TimeBlock[] M, TimeBlock[] T, TimeBlock[] W, TimeBlock[] TH, TimeBlock[] F, TimeBlock[] S){
        this.M = M;
        this.T = T;
        this.W = W;
        this.TH = TH;
        this.F = F;
        this.S = S;
    }

    public void setM(TimeBlock[] M){
        this.M = M;
    }
    public void setT(TimeBlock[] T){
        this.T = T;
    }
    public void setW(TimeBlock[] W){
        this.W = W;
    }
    public void setTH(TimeBlock[] TH){
        this.TH = TH;
    }
    public void setF(TimeBlock[] F){
        this.F = F;
    }
    public void setS(TimeBlock[] S){
        this.S = S;
    }

    public TimeBlock[] getM(){
        return this.M;
    }
    public TimeBlock[] getT(){
        return this.T;
    }
    public TimeBlock[] getW(){
        return this.W;
    }
    public TimeBlock[] getTH(){
        return this.TH;
    }
    public TimeBlock[] getF(){
        return this.F;
    }
    public TimeBlock[] getS(){
        return this.S;
    }

}
