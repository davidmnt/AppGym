package com.example.appgym.Objetos;

public class GemeloO {
    private String GemeloEnPrensa;
    private String GemeloUnaPierna;

    public GemeloO() {
    }

    public GemeloO(String gemeloEnPrensa) {
        this.GemeloEnPrensa = gemeloEnPrensa;
        GemeloUnaPierna = "";
    }

    public GemeloO(String gemeloEnPrensa, String gemeloUnaPierna) {
        this.GemeloEnPrensa = gemeloEnPrensa;
        this.GemeloUnaPierna = gemeloUnaPierna;
    }

    public String getGemeloEnPrensa() {
        return GemeloEnPrensa;
    }

    public void setGemeloEnPrensa(String gemeloEnPrensa) {
        GemeloEnPrensa = gemeloEnPrensa;
    }

    public String getGemeloUnaPierna() {
        return GemeloUnaPierna;
    }

    public void setGemeloUnaPierna(String gemeloUnaPierna) {
        GemeloUnaPierna = gemeloUnaPierna;
    }

    @Override
    public String toString() {
        return "GemeloO{" +
                "GemeloEnPrensa='" + GemeloEnPrensa + '\'' +
                ", GemeloUnaPierna='" + GemeloUnaPierna + '\'' +
                '}';
    }
}
