package com.example.appgym.Objetos;

public class EspaldaO {
    private String PullOver;
    private String RackPull;
    private String JalonPecho;
    private String RemoBarra;
    private String RemoT;

    public EspaldaO(){
    }

    public EspaldaO(String pullOver) {
        this.PullOver = pullOver;
        RackPull = "";
        JalonPecho = "";
        RemoBarra = "";
        RemoT = "";
    }

    public EspaldaO(String pullOver, String rackPull) {
        this.PullOver = pullOver;
        this.RackPull = rackPull;
        JalonPecho = "";
        RemoBarra = "";
        RemoT = "";
    }

    public EspaldaO(String pullOver, String rackPull, String jalonPecho) {
        this.PullOver = pullOver;
        this.RackPull = rackPull;
        this.JalonPecho = jalonPecho;
        RemoBarra = "";
        RemoT = "";
    }
    public EspaldaO(String pullOver, String rackPull, String jalonPecho, String remoBarra) {
        this.PullOver = pullOver;
        this.RackPull = rackPull;
        this.JalonPecho = jalonPecho;
        this.RemoBarra = remoBarra;
        RemoT = "";
    }

    public EspaldaO(String pullOver, String rackPull, String jalonPecho, String remoBarra, String remoT) {
        this.PullOver = pullOver;
        this.RackPull = rackPull;
        this.JalonPecho = jalonPecho;
        this.RemoBarra = remoBarra;
        this.RemoT = remoT;
    }

    public String getPullOver() {
        return PullOver;
    }

    public void setPullOver(String pullOver) {
        PullOver = pullOver;
    }

    public String getRackPull() {
        return RackPull;
    }

    public void setRackPull(String rackPull) {
        RackPull = rackPull;
    }

    public String getJalonPecho() {
        return JalonPecho;
    }

    public void setJalonPecho(String jalonPecho) {
        JalonPecho = jalonPecho;
    }

    public String getRemoBarra() {
        return RemoBarra;
    }

    public void setRemoBarra(String remoBarra) {
        RemoBarra = remoBarra;
    }

    public String getRemoT() {
        return RemoT;
    }

    public void setRemoT(String remoT) {
        RemoT = remoT;
    }

    @Override
    public String toString() {
        return "EspaldaO{" +
                "PullOver='" + PullOver + '\'' +
                ", RackPull='" + RackPull + '\'' +
                ", JalonPecho='" + JalonPecho + '\'' +
                ", RemoBarra='" + RemoBarra + '\'' +
                ", RemoT='" + RemoT + '\'' +
                '}';
    }
}
