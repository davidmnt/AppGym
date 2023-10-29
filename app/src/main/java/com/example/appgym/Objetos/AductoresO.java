package com.example.appgym.Objetos;

public class AductoresO {
    private String Aductores;

    public AductoresO(String aductores) {
        Aductores = aductores;
    }

    public AductoresO(){
    }

    public String getAductores() {
        return Aductores;
    }

    public void setAductores(String aductores) {
        Aductores = aductores;
    }

    @Override
    public String toString() {
        return "AductoresO{" +
                "Aductores='" + Aductores + '\'' +
                '}';
    }
}
