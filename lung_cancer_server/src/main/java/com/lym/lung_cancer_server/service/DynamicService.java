package com.lym.lung_cancer_server.service;

import com.lym.lung_cancer_server.entity.Dynamic;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DynamicService {

    public DynamicService(String msg)throws IOException, InterruptedException{
        testPython(msg);
    }
//    public String change(Dynamic datePackage){
//        String result = "";
//        String learing_rate = datePackage.getLearing_rate();
//        String individual_factor = datePackage.getIndividual_factor();
//        String batch_size = datePackage.getBatch_size();
//        String latent_space_dim = datePackage.getLatent_space_dim();
//        String epoch = datePackage.getEpoch();
//        String test_size = datePackage.getTest_size();
//        String miRNA_econder = datePackage.getMiRNA_econder();
//        String miRNA_dignosis = datePackage.ge;
//        String miRNA_generator;
//        String miRNA_adversarial;
//        String dna_methylation_econder;
//        String dna_methylation_dignosis;
//        String dna_methylation_generator;
//        String dna_methylation_adversarial;
//        String snp_econder;
//        String snp_dignosis;
//        String snp_generator;
//        String snp_adversarial;
//        String wsi_econder;
//        String wsi_dignosis;
//        String wsi_generator;
//        String wsi_adversarial;
//        return result;
//    }
    public void testPython(String msg)throws IOException, InterruptedException{
        String exe = "python";
        String command = "E:\\github-本地\\第六学期\\web数据管理\\lung_cancer_data_processing\\final\\i_start.py";
        String cmdArr[] = new String[] {exe, command, msg};
        Process process = Runtime.getRuntime().exec(cmdArr);
        InputStream is = process.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        process.waitFor();
    }
}
