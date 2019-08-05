package com.springcloud.consumer1.controller;

import com.springcloud.consumer1.feign.TestFeign;
import com.springcloud.consumer1.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author taotao
 */
@RestController
public class InfoController {
    @Autowired
    private ITestService testService;
    @Autowired
    private TestFeign testFeign;

    @GetMapping("/test/name")
    public String getTestInfo(String name){
        return testService.getTestInfo(name);
    }

    @GetMapping("/test/info")
    public String getTestInfoFeign(String name){
        return testFeign.getTestInfo(name);
    }
}
