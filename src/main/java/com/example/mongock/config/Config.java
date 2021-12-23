package com.example.mongock.config;

import io.mongock.runner.springboot.MongockSpringboot;
import io.mongock.runner.springboot.base.MongockApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import static io.mongock.driver.mongodb.springdata.v3.SpringDataMongoV3Driver.withDefaultLock;

@Configuration
public class Config {

    @Bean
    public MongockApplicationRunner mongockApplicationRunner(ApplicationContext springContext, MongoTemplate mongoTemplate) {
        return MongockSpringboot.builder()
                .setDriver(withDefaultLock(mongoTemplate))
                .addMigrationScanPackage("com.example.mongock.scripts")
                .setSpringContext(springContext)
                .buildApplicationRunner();
    }

}
