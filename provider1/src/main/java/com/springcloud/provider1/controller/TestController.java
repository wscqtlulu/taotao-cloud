package com.springcloud.provider1.controller;

import com.springcloud.provider1.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author taotao
 */
@RestController
public class TestController {
    @Autowired
    ITestService testService;

    @GetMapping("/test/info")
    public String getTestInfo(String name){
        System.out.println("getTestInfo api " + System.currentTimeMillis());
        return name + " account info";
    }

    @GetMapping("/test/person")
    public String getTestPerson(){
        System.out.println("getTestPerson api " + System.currentTimeMillis());
        return testService.getTestPerson();
    }
}
