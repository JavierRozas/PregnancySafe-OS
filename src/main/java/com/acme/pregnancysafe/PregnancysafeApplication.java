package com.acme.pregnancysafe;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PregnancysafeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PregnancysafeApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {return new ModelMapper(); }
}