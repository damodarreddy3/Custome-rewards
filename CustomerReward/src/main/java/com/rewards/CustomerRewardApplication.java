package com.rewards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.rewards"})
public class CustomerRewardApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerRewardApplication.class, args);
    }
}