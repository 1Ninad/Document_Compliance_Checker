package com.example.spring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ieee.pdfchecker") // FIX: Ensure Spring Boot scans controllers
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
