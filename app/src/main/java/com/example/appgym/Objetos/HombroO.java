package com.example.appgym.Objetos;

public class HombroO {

    private String ElevacionesLatMancuernas;
    private String Pajaro;
    private String PressMaquina;
    private String LateralesSentado;
    private String LateralesPolea;

    public HombroO() {
    }

    public HombroO(String elevacionesLatMancuernas) {
        this.ElevacionesLatMancuernas = elevacionesLatMancuernas;
        Pajaro = "";
        PressMaquina = "";
        LateralesSentado = "";
        LateralesPolea = "";
    }

    public HombroO(String elevacionesLatMancuernas, String pajaro) {
        this.ElevacionesLatMancuernas = elevacionesLatMancuernas;
        this.Pajaro = pajaro;
        PressMaquina = "";
        LateralesSentado = "";
        LateralesPolea = "";
    }

    public HombroO(String elevacionesLatMancuernas, String pajaro, String pressMaquina) {
        this.ElevacionesLatMancuernas = elevacionesLatMancuernas;
        this.Pajaro = pajaro;
        this.PressMaquina = pressMaquina;
        LateralesSentado = "";
        LateralesPolea = "";
    }

    public HombroO(String elevacionesLatMancuernas, String pajaro, String pressMaquina, String lateralesSentado) {
        this.ElevacionesLatMancuernas = elevacionesLatMancuernas;
        this.Pajaro = pajaro;
        this.PressMaquina = pressMaquina;
        this.LateralesSentado = lateralesSentado;
        LateralesPolea = "";
    }

    public HombroO(String elevacionesLatMancuernas, String pajaro, String pressMaquina, String lateralesSentado, String lateralesPolea) {
        this.ElevacionesLatMancuernas = elevacionesLatMancuernas;
        this.Pajaro = pajaro;
        this.PressMaquina = pressMaquina;
        this.LateralesSentado = lateralesSentado;
        this.LateralesPolea = lateralesPolea;
    }

    public String getElevacionesLatMancuernas() {
        return ElevacionesLatMancuernas;
    }

    public void setElevacionesLatMancuernas(String elevacionesLatMancuernas) {
        ElevacionesLatMancuernas = elevacionesLatMancuernas;
    }

    public String getPajaro() {
        return Pajaro;
    }

    public void setPajaro(String pajaro) {
        Pajaro = pajaro;
    }

    public String getPressMaquina() {
        return PressMaquina;
    }

    public void setPressMaquina(String pressMaquina) {
        PressMaquina = pressMaquina;
    }

    public String getLateralesSentado() {
        return LateralesSentado;
    }

    public void setLateralesSentado(String lateralesSentado) {
        LateralesSentado = lateralesSentado;
    }

    public String getLateralesPolea() {
        return LateralesPolea;
    }

    public void setLateralesPolea(String lateralesPolea) {
        LateralesPolea = lateralesPolea;
    }

    @Override
    public String toString() {
        return "HombroO{" +
                "ElevacionesLatMancuernas='" + ElevacionesLatMancuernas + '\'' +
                ", Pajaro='" + Pajaro + '\'' +
                ", PressMaquina='" + PressMaquina + '\'' +
                ", LateralesSentado='" + LateralesSentado + '\'' +
                ", LateralesPolea='" + LateralesPolea + '\'' +
                '}';
    }
}
