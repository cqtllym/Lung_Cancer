package com.lym.lung_cancer_server.entity;

public class Result {
    private String ID ;
    private String name;
    private String submit;
    private String S_RNA;
    private String S_DNA;
    private String S_WSI;
    private String S_CNV;
    private String RNA;
    private String DNA;
    private String WSI;
    private String CNV;
    private int finish;
    private String result;
    private String confidence;
    private String download;

    public void setID(String ID){this.ID = ID;}
    public void setName(String name){this.name = name;};
    public void setSubmit(String submit){this.submit = submit;};
    public void setS_RNA(String S_RNA){this.S_RNA = S_RNA;};
    public void setS_DNA(String S_DNA){this.S_DNA = S_DNA;};
    public void setS_WSI(String S_WSI){this.S_WSI = S_WSI;};
    public void setS_CNV(String S_CNV){this.S_CNV = S_CNV;};
    public void setRNA(String RNA){this.RNA = RNA;};
    public void setDNA(String DNA){this.DNA = DNA;};
    public void setWSI(String WSI){this.WSI = WSI;};
    public void setCNV(String CNV){this.CNV = CNV;};
    public void setFinish(int finish){this.finish = finish;};
    public void setResult(String result){this.result = result;};
    public void setConfidence(String confidence){this.confidence = confidence;};
    public void setDownload(String download){this.download = download;};

    public Result(){

    }
    public String getID(){ return ID; }
    public String getName(){ return name; }
    public String getSubmit(){ return submit; }
    public String getS_RNA(){ return S_RNA;};
    public String getS_DNA(){ return S_DNA;};
    public String getS_WSI(){ return S_WSI;};
    public String getS_CNV(){ return S_CNV;};
    public String getRNA(){ return RNA;};
    public String getDNA(){ return DNA;};
    public String getWSI(){ return WSI;};
    public String getCNV(){ return CNV;};
    public int getFinish(){ return finish; }
    public String getResult(){ return result; }
    public String getConfidence(){ return confidence; }
    public String getDownload(){ return download; }
}
