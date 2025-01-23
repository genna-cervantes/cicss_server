package ust.com.cicss.models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Embeddable;

@Embeddable
public class Restrictions {
    @JsonProperty("M")
    private ArrayList<TimeBlock> M;
    @JsonProperty("T")
    private ArrayList<TimeBlock> T;
    @JsonProperty("W")
    private ArrayList<TimeBlock> W;
    @JsonProperty("TH")
    private ArrayList<TimeBlock> TH;
    @JsonProperty("F")
    private ArrayList<TimeBlock> F;
    @JsonProperty("S")
    private ArrayList<TimeBlock> S;

    public Restrictions(){}

    public Restrictions(ArrayList<TimeBlock> M, ArrayList<TimeBlock> T, ArrayList<TimeBlock> W, ArrayList<TimeBlock> TH, ArrayList<TimeBlock> F, ArrayList<TimeBlock> S){
        this.M = M;
        this.T = T;
        this.W = W;
        this.TH = TH;
        this.F = F;
        this.S = S;
    }

    public void setM(ArrayList<TimeBlock> M){
        this.M = M;
    }
    public void setT(ArrayList<TimeBlock> T){
        this.T = T;
    }
    public void setW(ArrayList<TimeBlock> W){
        this.W = W;
    }
    public void setTH(ArrayList<TimeBlock> TH){
        this.TH = TH;
    }
    public void setF(ArrayList<TimeBlock> F){
        this.F = F;
    }
    public void setS(ArrayList<TimeBlock> S){
        this.S = S;
    }

    public ArrayList<TimeBlock> getM(){
        return this.M;
    }
    public ArrayList<TimeBlock> getT(){
        return this.T;
    }
    public ArrayList<TimeBlock> getW(){
        return this.W;
    }
    public ArrayList<TimeBlock> getTH(){
        return this.TH;
    }
    public ArrayList<TimeBlock> getF(){
        return this.F;
    }
    public ArrayList<TimeBlock> getS(){
        return this.S;
    }

}
