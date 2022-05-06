package com.lym.lung_cancer_server.service;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class WSIService {
    public WSIService(String fileAddress, String datePackage)throws IOException, InterruptedException{
        testPython(fileAddress, datePackage);
    }

    public void testPython(String filePath, String datePackage)throws IOException, InterruptedException{
        String exe = "python";
        String command = "E:\\github-本地\\第六学期\\web数据管理\\lung_cancer_data_processing\\springboot_python\\WSI.py";
        String cmdArr[] = new String[] {exe, command, filePath, datePackage};
        Process process = Runtime.getRuntime().exec(cmdArr);
        InputStream is = process.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        process.waitFor();
    }
}
