package com.springcloud.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author taotao
 */
@RestController
public class ConfigClientController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/get/port")
    public String getPort(){
        String info = port;
        return info;
    }
}
