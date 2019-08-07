package com.springcloud.consumer1.feign;

import com.springcloud.consumer1.feign.fallback.TestFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author taotao
 */
@FeignClient(name = "provider1", fallback = TestFeignFallback.class)
public interface TestFeign {

    /**
     * 获取账号信息
     * @param name
     * @return
     */
    @GetMapping("/test/info")
    String getTestInfo(@RequestParam("name") String name);

    @GetMapping("/test/name")
    String getTestName(@RequestParam("name") String name);

}
