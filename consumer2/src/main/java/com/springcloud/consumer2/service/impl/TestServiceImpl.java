package com.springcloud.consumer2.service.impl;

import com.springcloud.consumer2.feign.TestFeign;
import com.springcloud.consumer2.service.ITestService;
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

}
