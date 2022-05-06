package com.lym.lung_cancer_server.controller;

import com.lym.lung_cancer_server.api.CommonResult;
import com.lym.lung_cancer_server.mapper.ResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetDownloadListController {
    @Autowired
    private ResultMapper resultMapper;

    @RequestMapping(value= "/getD", method = RequestMethod.POST)
    public CommonResult getlist() {
        return CommonResult.success(resultMapper.selectResult());
    }
}
