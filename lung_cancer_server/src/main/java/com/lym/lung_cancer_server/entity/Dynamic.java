package com.lym.lung_cancer_server.entity;

import java.util.List;

public class Dynamic {
    private String learing_rate;
    private String individual_factor;
    private String batch_size;
    private String latent_space_dim;
    private String epoch;
    private String test_size;
    private String miRNA_econder;
    private String miRNA_dignosis;
    private String miRNA_generator;
    private String miRNA_adversarial;
    private String dna_methylation_econder;
    private String dna_methylation_dignosis;
    private String dna_methylation_generator;
    private String dna_methylation_adversarial;
    private String snp_econder;
    private String snp_dignosis;
    private String snp_generator;
    private String snp_adversarial;
    private String wsi_econder;
    private String wsi_dignosis;
    private String wsi_generator;
    private String wsi_adversarial;


    public String getLearing_rate(){
        return this.learing_rate;
    }
    public void setLearing_rate(String learing_rate){
        this.learing_rate = learing_rate;
    }

    public String getIndividual_factor(){
        return this.individual_factor;
    }
    public void setIndividual_factor(String individual_factor){
        this.individual_factor = individual_factor;
    }

    public String getBatch_size(){
        return this.batch_size;
    }
    public void setBatch_size(String batch_size){
        this.batch_size = batch_size;
    }

    public String getLatent_space_dim(){
       return this.latent_space_dim;
    }
    public void setLatent_space_dim(String latent_space_dim){
        this.latent_space_dim = latent_space_dim;
    }

    public String getEpoch(){
        return this.epoch;
    }
    public void setEpoch(String epoch){
        this.epoch = epoch;
    }

    public String getTest_size(){
        return this.test_size;
    }
    public void setTest_size(String test_size){
        this.test_size = test_size;
    }


    public String getMiRNA_econder(){
        return this.miRNA_econder;
    }
    public void setMiRNA_econder(String miRNA_econder){
        this.miRNA_econder = miRNA_econder;
    }

    public String getMiRNA_dignosis(){
        return this.miRNA_dignosis;
    }
    public void setMiRNA_dignosis(String miRNA_dignosis){
        this.miRNA_dignosis = miRNA_dignosis;
    }

    public String getMiRNA_generator(){
        return this.miRNA_generator;
    }
    public void setMiRNA_generator(String miRNA_generator){
        this.miRNA_generator = miRNA_generator;
    }

    public String getMiRNA_adversarial(){
        return this.miRNA_adversarial;
    }
    public void setMiRNA_adversarial(String miRNA_adversarial){
        this.miRNA_adversarial = miRNA_adversarial;
    }

    public String getDna_methylation_econder(){
        return this.dna_methylation_econder;
    }
    public void setDna_methylation_econder(String dna_methylation_econder){
        this.dna_methylation_econder = dna_methylation_econder;
    }

    public String getDna_methylation_dignosisr(){
        return this.dna_methylation_dignosis;
    }
    public void setDna_methylation_dignosis(String dna_methylation_dignosis){
        this.dna_methylation_dignosis = dna_methylation_dignosis;
    }

    public String getDna_methylation_generator(){
        return this.dna_methylation_generator;
    }
    public void setDna_methylation_generator(String dna_methylation_generator){
        this.dna_methylation_generator = dna_methylation_generator;
    }

    public String getDna_methylation_adversarial(){
        return this.dna_methylation_adversarial;
    }
    public void setDna_methylation_adversarial(String dna_methylation_adversarial){
        this.dna_methylation_adversarial = dna_methylation_adversarial;
    }

    public String getsnp_econder(){
        return this.snp_econder;
    }
    public void setsnp_econder(String snp_econder){
        this.snp_econder = snp_econder;
    }

    public String getsnp_dignosis(){
        return this.snp_dignosis;
    }
    public void setsnp_dignosis(String snp_dignosis){
        this.snp_dignosis = snp_dignosis;
    }

    public String getsnp_generator(){
        return this.snp_generator;
    }
    public void setsnp_generator(String snp_generator){
        this.snp_generator = snp_generator;
    }

    public String getsnp_adversarial(){
        return this.snp_adversarial;
    }
    public void setsnp_adversarial(String snp_adversarial){
        this.snp_adversarial = snp_adversarial;
    }

    public String getwsi_econder(){
        return this.wsi_econder;
    }
    public void setwsi_econder(String wsi_econder){
        this.wsi_econder = wsi_econder;
    }

    public String getwsi_dignosis(){
        return this.wsi_dignosis;
    }
    public void setwsi_dignosis(String wsi_dignosis){
        this.wsi_dignosis = wsi_dignosis;
    }

    public String getwsi_generator(){
        return this.wsi_generator;
    }
    public void setwsi_generator(String wsi_generator){
        this.wsi_generator = wsi_generator;
    }

    public String getwsi_adversarial(){
        return this.wsi_adversarial;
    }
    public void setwsi_adversarial(String wsi_adversarial){
        this.wsi_adversarial = wsi_adversarial;
    }
}
