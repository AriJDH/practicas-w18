package com.example.codigomorse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.servlet.annotation.MultipartConfig;

@SpringBootApplication
public class CodigomorseApplication {
@MultipartConfig
    public static void main(String[] args) {
        SpringApplication.run(CodigomorseApplication.class, args);
    }

}
