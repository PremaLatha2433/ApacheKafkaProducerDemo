package com.apache.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApacheKafkaDemoApplication {
    public static void main(String[] args) {

        SpringApplication.run(ApacheKafkaDemoApplication.class, args);
        System.out.println("Hello, World!");
    }
}