package com.example.appgym.Objetos;

public class TricepsO {
    private String PressFrancesTumbado;
    private String PressFrancesSentado;
    private String TironPoleaEncimaDeLaCabeza;

    public TricepsO(){
    }
    public TricepsO(String pressFrancesTumbado) {
        this.PressFrancesTumbado = pressFrancesTumbado;
        PressFrancesSentado = "";
        TironPoleaEncimaDeLaCabeza = "";
    }
    public TricepsO(String pressFrancesTumbado, String pressFrancesSentado) {
        this.PressFrancesTumbado = pressFrancesTumbado;
        this.PressFrancesSentado = pressFrancesSentado;
        TironPoleaEncimaDeLaCabeza = "";
    }

    public TricepsO(String pressFrancesTumbado, String pressFrancesSentado, String tironPoleaEncimaDeLaCabeza) {
        this.PressFrancesTumbado = pressFrancesTumbado;
        this.PressFrancesSentado = pressFrancesSentado;
        this.TironPoleaEncimaDeLaCabeza = tironPoleaEncimaDeLaCabeza;
    }

    public String getPressFrancesTumbado() {
        return PressFrancesTumbado;
    }

    public void setPressFrancesTumbado(String pressFrancesTumbado) {
        PressFrancesTumbado = pressFrancesTumbado;
    }

    public String getPressFrancesSentado() {
        return PressFrancesSentado;
    }

    public void setPressFrancesSentado(String pressFrancesSentado) {
        PressFrancesSentado = pressFrancesSentado;
    }

    public String getTironPoleaEncimaDeLaCabeza() {
        return TironPoleaEncimaDeLaCabeza;
    }

    public void setTironPoleaEncimaDeLaCabeza(String tironPoleaEncimaDeLaCabeza) {
        TironPoleaEncimaDeLaCabeza = tironPoleaEncimaDeLaCabeza;
    }

    @Override
    public String toString() {
        return "TricepsO{" +
                "PressFrancesTumbado='" + PressFrancesTumbado + '\'' +
                ", PressFrancesSentado='" + PressFrancesSentado + '\'' +
                ", TironPoleaEncimaDeLaCabeza='" + TironPoleaEncimaDeLaCabeza + '\'' +
                '}';
    }
}
