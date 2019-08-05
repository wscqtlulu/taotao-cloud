package com.springcloud.provider1.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.springcloud.provider1.mapper.TestMapper;
import com.springcloud.provider1.pojo.*;
import com.springcloud.provider1.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author taotao
 */
@Service
public class TestServiceImpl implements ITestService {
    @Autowired
    private TestMapper testMapper;

    @Override
    public String getTestPerson(){
        List<Person> people = testMapper.getTestPerson();
        return JSONObject.toJSONString(people);
    }

}
