package com.springcloud.consumer1.config;

import com.springcloud.RibbonRandomConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClient(name = "provider1", configuration = RibbonRandomConfiguration.class)
public class ProviderRibbonConfig {
}
