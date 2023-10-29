package com.example.appgym.Objetos;

public class TrapecioO {
    private String EncogimientoPesado;
    public TrapecioO(){

    }

    public TrapecioO(String encogimientoPesado) {
        EncogimientoPesado = encogimientoPesado;
    }

    public String getEncogimientoPesado() {
        return EncogimientoPesado;
    }

    public void setEncogimientoPesado(String encogimientoPesado) {
        EncogimientoPesado = encogimientoPesado;
    }

    @Override
    public String toString() {
        return "TrapecioO{" +
                "EncogimientoPesado='" + EncogimientoPesado + '\'' +
                '}';
    }
}
