package com.lym.lung_cancer_server.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.lym.lung_cancer_server.api.CommonResult;
import com.lym.lung_cancer_server.service.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@ResponseBody
public class UploadController {
    @RequestMapping(value= "/upload", method = RequestMethod.POST)
    public CommonResult rnaFile(@RequestParam("name")String name, @RequestParam("files") MultipartFile file) {
        if(file != null){
            String fileName = file.getOriginalFilename();
            String datePackage = name.split("&")[0];
            String kind = name.split("&")[1];
            File mkdir = new File("C:\\Users\\asus\\Desktop\\test\\"+datePackage);
            File kindDir = new File("C:\\Users\\asus\\Desktop\\test\\"+datePackage+"\\"+kind);
            String fileAddress = kindDir.getPath()+"\\"+fileName;
            try{
                if(!mkdir.exists()) {
                    mkdir.mkdirs();
                }
                if(!kindDir.exists()) {
                    kindDir.mkdirs();
                }
                //定义输出流，将文件写入硬盘
                FileOutputStream os = new FileOutputStream(fileAddress);
                InputStream in = file.getInputStream();
                int b = 0;
                while((b=in.read())!=-1){ //读取文件
                    os.write(b);
                }
                os.flush(); //关闭流
                in.close();
                os.close();

            }catch(Exception  e) {
                e.printStackTrace();
                return CommonResult.failed("upload_error");
            }
            try {
                SQLService ss = new SQLService(datePackage);
                if (kind.equals("RNA")) {
                    RNAService rs = new RNAService(fileAddress, datePackage);
                } else if (kind.equals("DNA")) {
                    DNAService ds = new DNAService(fileAddress, datePackage);
                } else if (kind.equals("WSI")) {
                    WSIService ws = new WSIService(fileAddress, datePackage);
                } else if (kind.equals("CNV")) {
                    CNVService cs = new CNVService(fileAddress, datePackage);
                }
                Diagnosis d = new Diagnosis(datePackage);
            }catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return CommonResult.success(kind+"上传成功");
        }else{
            return CommonResult.failed("未收到files");
        }
    }
}
