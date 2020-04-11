package com.itmayiedu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableEurekaClient
public class ServiceHiApplication {

    @Value("${server.port}")
    private String port;

    @GetMapping("/hi")
    public String hi(String name) {
        return name + ", hi from " + port;
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceHiApplication.class, args);
    }
}
