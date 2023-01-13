package com.cicm.zonesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.cicm.zonesservice.repository")
public class ZonesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZonesServiceApplication.class, args);
    }

}
