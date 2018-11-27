package com.d8games.web.services.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/services/controller/**")
                .allowedOrigins(
                        "http://127.0.0.1", "http://localhost",
                        "http://142.93.173.131", "http://d8games.net")
                .allowedMethods("GET", "PUT", "POST");
    }
}