package com.lym.lung_cancer_server.controller;

import com.lym.lung_cancer_server.api.CommonResult;
import com.lym.lung_cancer_server.entity.DiagnosisItem;
import com.lym.lung_cancer_server.service.Diagnosis;
import com.lym.lung_cancer_server.service.Interpretable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class DiagnosisController {
    @RequestMapping(value = "/diagnosis", method = RequestMethod.POST)
    public CommonResult diagnosis(@RequestBody DiagnosisItem diagnosis) throws IOException, InterruptedException {
        if(diagnosis.getKind1() == 1 || diagnosis.getKind2() == 1){
            Diagnosis d = new Diagnosis(diagnosis.getDataPackage());
        }
        if(diagnosis.getKind1() == 1){
            Interpretable i = new Interpretable(diagnosis.getDataPackage());
        }
        return CommonResult.success("");
    }
}
