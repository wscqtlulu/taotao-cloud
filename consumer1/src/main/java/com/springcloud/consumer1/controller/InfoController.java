package com.springcloud.consumer1.controller;

import com.springcloud.consumer1.feign.TestFeign;
import com.springcloud.consumer1.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author taotao
 */
@RestController
public class InfoController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private TestFeign testFeign;
    @Autowired
    private ITestService testService;

    @GetMapping("/test/rest/info")
    public String getTestRestName(String name){
        //如果restTemplate远程调用的时候使用服务名，则需要在RestTemplate加上@LoadBalanced注解开启负载均衡，如果使用域名：端口号则需要去掉@LoadBalanced
        return restTemplate.getForObject("http://provider1/test/info?name=" + name, String.class);
//        return restTemplate.getForObject("http://localhost:6010/test/info", String.class);
    }

    @GetMapping("/load/balancer/choose")
    public String loadBalancerChoose(String serverName){
        //loadBalancerClient.choose()不能跟restTemplate.getForObject()写在同一个方法内，
        //因为restTemplate实际上是一个Ribbon客户端，本身包含choose行为
        ServiceInstance serviceInstance = loadBalancerClient.choose(serverName);
        if(null == serviceInstance){
            return "not found this server";
        }
        String address = serverName + "-" + serviceInstance.getHost() + ":" + serviceInstance.getPort();
        System.out.println(address);
        return address;
    }

    @GetMapping("/test/info")
    public String getTestInfoFeign(String name){
        return testFeign.getTestInfo(name);
    }

    @GetMapping("/test/name")
    public String getTestName(String name){
        return testService.getTestName(name);
    }


}
