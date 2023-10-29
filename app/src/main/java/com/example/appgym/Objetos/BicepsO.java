package com.example.appgym.Objetos;

public class BicepsO {
    private String CurlAlternoPie;
    private String CurlInvertido;

    public BicepsO() {
    }

    public BicepsO(String curlAlternoPie) {
        this.CurlAlternoPie = curlAlternoPie;
        CurlInvertido = "";
    }

    public BicepsO(String curlAlternoPie, String curlInvertido) {
        this.CurlAlternoPie = curlAlternoPie;
        this.CurlInvertido = curlInvertido;
    }

    public String getCurlAlternoPie() {
        return CurlAlternoPie;
    }

    public void setCurlAlternoPie(String curlAlternoPie) {
        CurlAlternoPie = curlAlternoPie;
    }

    public String getCurlInvertido() {
        return CurlInvertido;
    }

    public void setCurlInvertido(String curlInvertido) {
        CurlInvertido = curlInvertido;
    }

    @Override
    public String toString() {
        return "BicepsO{" +
                "CurlAlternoPie='" + CurlAlternoPie + '\'' +
                ", CurlInvertido='" + CurlInvertido + '\'' +
                '}';
    }
}
