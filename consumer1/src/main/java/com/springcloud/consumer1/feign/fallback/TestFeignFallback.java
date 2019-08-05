package com.springcloud.consumer1.feign.fallback;

import com.springcloud.consumer1.feign.TestFeign;
import org.springframework.stereotype.Component;

/**
 * @author taotao
 */
@Component
public class TestFeignFallback implements TestFeign {
    @Override
    public String getTestInfo(String name) {
        return "get account info error!!!";
    }
}
