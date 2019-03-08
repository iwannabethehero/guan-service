package com.threeg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan(value = "com.threeg")
@Configuration
public class GuanServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuanServiceApplication.class, args);
    }

}
