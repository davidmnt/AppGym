package com.example.appgym;

import java.io.Serializable;

public class PechoO implements Serializable {
    private String pressPlanoMaquina;
    private String pressInclinado;
    private String contractora;
    private String flexiones;

    public PechoO() {
    }
    public PechoO(String pressPlanoMaquina) {
        this.pressPlanoMaquina = pressPlanoMaquina;
        pressInclinado = "";
        contractora = "";
        flexiones = "";

    }
    public PechoO(String pressPlanoMaquina, String pressInclinado) {
        this.pressPlanoMaquina = pressPlanoMaquina;
        this.pressInclinado = pressInclinado;
        contractora = "";
        flexiones = "";

    }
    public PechoO(String pressPlanoMaquina, String pressInclinado, String contractora) {
        this.pressPlanoMaquina = pressPlanoMaquina;
        this.pressInclinado = pressInclinado;
        this.contractora = contractora;
        flexiones = "";

    }

    public PechoO(String pressPlanoMaquina, String pressInclinado, String contractora, String flexiones) {
        this.pressPlanoMaquina = pressPlanoMaquina;
        this.pressInclinado = pressInclinado;
        this.contractora = contractora;
        this.flexiones = flexiones;
    }



    public String getPressPlanoMaquina() {
        return pressPlanoMaquina;
    }

    public void setPressPlanoMaquina(String pressPlanoMaquina) {
        this.pressPlanoMaquina = pressPlanoMaquina;
    }

    public String getPressInclinado() {
        return pressInclinado;
    }

    public void setPressInclinado(String pressInclinado) {
        this.pressInclinado = pressInclinado;
    }

    public String getContractora() {
        return contractora;
    }

    public void setContractora(String contractora) {
        this.contractora = contractora;
    }

    public String getFlexiones() {
        return flexiones;
    }

    public void setFlexiones(String flexiones) {
        this.flexiones = flexiones;
    }

    @Override
    public String toString() {
        return "PechoO{" +
                "pressPlanoMaquina='" + pressPlanoMaquina + '\'' +
                ", pressInclinado='" + pressInclinado + '\'' +
                ", contractora='" + contractora + '\'' +
                ", flexiones='" + flexiones + '\'' +
                '}';
    }
}
