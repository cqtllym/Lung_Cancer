package com.lym.lung_cancer_server.controller;

import com.lym.lung_cancer_server.api.CommonResult;
import com.lym.lung_cancer_server.entity.Dynamic;
import com.lym.lung_cancer_server.service.DynamicService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class DynamicController {
    @RequestMapping(value = "/dynamic", method = RequestMethod.POST)
    public CommonResult diagnosis(@RequestParam("the_list") String thelist) throws IOException, InterruptedException {
        DynamicService ds = new DynamicService(thelist);
        return CommonResult.success("成功");
    }
}
