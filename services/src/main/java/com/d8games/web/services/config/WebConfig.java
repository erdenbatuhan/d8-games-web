package com.d8games.web.services.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@SuppressWarnings("unused")
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/services/controller/**")
                .allowedOrigins("http://localhost:8080", "http://142.93.173.131")
                .allowedMethods("GET", "PUT", "POST");
    }
}