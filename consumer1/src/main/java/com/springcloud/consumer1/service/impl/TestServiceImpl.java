package com.springcloud.consumer1.service.impl;

import com.springcloud.consumer1.feign.TestFeign;
import com.springcloud.consumer1.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author taotao
 */
@Service
public class TestServiceImpl implements ITestService {

    @Autowired
    private TestFeign testFeign;

    @Override
    public String getTestInfo(String name){
        return testFeign.getTestInfo(name);
    }

    @Override
    public String getTestName(String name){
        return testFeign.getTestName(name);
    }

}
