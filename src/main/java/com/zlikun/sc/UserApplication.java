package com.zlikun.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
// @SpringCloudApplication 包含上面两个注解，还包含Hystrix组件，这里暂未使用
// @SpringCloudApplication
// 启用断路器
// http://cloud.spring.io/spring-cloud-static/Finchley.RELEASE/multi/multi__circuit_breaker_hystrix_clients.html
@EnableCircuitBreaker
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
