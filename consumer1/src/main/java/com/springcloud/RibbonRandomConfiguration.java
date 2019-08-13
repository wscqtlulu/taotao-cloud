package com.springcloud;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 此类不能在@ComponetScan的扫描范围之内，如果被扫描上，则所有ribbon客户端都用此负载均衡规则，如果没被扫描，可以指定某个ribbon使用此规则
 */
@Configuration
public class RibbonRandomConfiguration {
    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
