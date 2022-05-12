package com.lym.lung_cancer_server.entity;

public class DiagnosisItem {
    private int kind1;
    private int kind2;
    private String dataPackage;

    public int getKind1() {
        return kind1;
    }

    public void setKind1(int kind1) {
        this.kind1 = kind1;
    }

    public int getKind2() {
        return kind2;
    }

    public void setKind2(int kind2) {
        this.kind2 = kind2;
    }

    public String getDataPackage() { return dataPackage; }

    public void setDataPackage(String dataPackage) {this.dataPackage = dataPackage;}
}
