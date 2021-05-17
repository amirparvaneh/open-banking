package com.rest.open.openbanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OpenbankingApplication {

    @Bean
    public RestTemplate getRestTepm(){
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(OpenbankingApplication.class, args);
    }

}
