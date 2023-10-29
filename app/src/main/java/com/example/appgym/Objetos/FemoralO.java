package com.example.appgym.Objetos;

public class FemoralO {
    private String FemoralTumbado;
    public FemoralO() {

    }
    public FemoralO(String femoralTumbado) {
        FemoralTumbado = femoralTumbado;
    }

    public String getFemoralTumbado() {
        return FemoralTumbado;
    }

    public void setFemoralTumbado(String femoralTumbado) {
        FemoralTumbado = femoralTumbado;
    }

    @Override
    public String toString() {
        return "FemoralO{" +
                "FemoralTumbado='" + FemoralTumbado + '\'' +
                '}';
    }
}
