package com.breakingbad;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Application {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
