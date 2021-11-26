package com.demo.catalogservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Data
@Configuration
@ConfigurationProperties(prefix = "services")
public class RestTempCallConfig {
    private String inventoryService;
    private String orderService;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

