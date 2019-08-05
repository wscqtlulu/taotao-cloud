package com.springcloud.zuul1;

import com.springcloud.zuul1.filter.PreRequestLogFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @author taotao
 */
@SpringBootApplication
@EnableZuulProxy
public class Zuul1Application {

    @Bean
    public PreRequestLogFilter preRequestLogFilter(){
        return new PreRequestLogFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(Zuul1Application.class, args);
    }

}
