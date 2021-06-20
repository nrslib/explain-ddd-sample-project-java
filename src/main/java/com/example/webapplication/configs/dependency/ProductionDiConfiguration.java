package com.example.webapplication.configs.dependency;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("production")
public class ProductionDiConfiguration {
//    @Bean
//    public BacklogQueryService backlogQueryService() {
//        return new InMemoryBacklogQueryService();
//    }
}
