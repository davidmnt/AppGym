package com.example.appgym.Objetos;

public class PiernaO {
    private String ExtensionCuádriceps;
    private String Prensa;
    private String PrensaUnaPierna;
     public PiernaO(){
     }

    public PiernaO(String extensionCuádriceps) {
        this.ExtensionCuádriceps = extensionCuádriceps;
        Prensa = "";
        PrensaUnaPierna = "";
    }

    public PiernaO(String extensionCuádriceps, String prensa) {
        this.ExtensionCuádriceps = extensionCuádriceps;
        this.Prensa = prensa;
        PrensaUnaPierna = "";
    }

    public PiernaO(String extensionCuádriceps, String prensa, String prensaUnaPierna) {
        this.ExtensionCuádriceps = extensionCuádriceps;
        this.Prensa = prensa;
        this.PrensaUnaPierna = prensaUnaPierna;
    }

    public String getExtensionCuádriceps() {
        return ExtensionCuádriceps;
    }

    public void setExtensionCuádriceps(String extensionCuádriceps) {
        ExtensionCuádriceps = extensionCuádriceps;
    }

    public String getPrensa() {
        return Prensa;
    }

    public void setPrensa(String prensa) {
        Prensa = prensa;
    }

    public String getPrensaUnaPierna() {
        return PrensaUnaPierna;
    }

    public void setPrensaUnaPierna(String prensaUnaPierna) {
        PrensaUnaPierna = prensaUnaPierna;
    }

    @Override
    public String toString() {
        return "PiernaO{" +
                "ExtensionCuádriceps='" + ExtensionCuádriceps + '\'' +
                ", Prensa='" + Prensa + '\'' +
                ", PrensaUnaPierna='" + PrensaUnaPierna + '\'' +
                '}';
    }
}
