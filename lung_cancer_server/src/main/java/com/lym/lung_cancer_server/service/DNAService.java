package com.lym.lung_cancer_server.service;

import java.io.*;

public class DNAService {
    public DNAService(String fileAddress)throws IOException, InterruptedException{
        testPython(fileAddress);
    }

    public void testPython(String filePath)throws IOException, InterruptedException{
        String exe = "python";
        String command = "E:\\github-本地\\第六学期\\web数据管理\\lung_cancer_data_processing\\springboot_python\\DNA.py";
        String cmdArr[] = new String[] {exe, command, filePath};
        Process process = Runtime.getRuntime().exec(cmdArr);
        InputStream is = process.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        process.waitFor();
    }
}
