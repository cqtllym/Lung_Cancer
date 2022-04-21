package com.lym.lung_cancer_server.controller;

import com.lym.lung_cancer_server.api.CommonResult;
import com.lym.lung_cancer_server.entity.Patient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetMsgController {
    @RequestMapping(value= "/patient", method = RequestMethod.POST)
    public CommonResult getlist(@RequestBody Patient p) {
        return CommonResult.success("链接成功");
    }
}


