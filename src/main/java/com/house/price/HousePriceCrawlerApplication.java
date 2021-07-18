package com.house.price;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HousePriceCrawlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HousePriceCrawlerApplication.class, args);
    }

}
