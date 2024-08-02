package com.tourroadmap.tourroadmap.Config;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Configuration
@EnableConfigurationProperties
@PropertySource("classpath:application-config.properties")
public class DBConfig {
    public static final org.slf4j.Logger log = LoggerFactory.getLogger(DBConfig.class);

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    public static String DB_URL;
    public static String DB_USERNAME;
    public static String DB_PASSWORD;

    @PostConstruct
    public void init() {
        try {
            DB_URL = this.dbUrl;
            DB_USERNAME = this.dbUsername;
            DB_PASSWORD = this.dbPassword;

            // Proper logging with placeholders
            log.info("Database URL: {}", DB_URL);
            log.info("Database Username: {}", DB_USERNAME);
            log.info("Database Password: {}", DB_PASSWORD);
        } catch (Exception e) {
            log.error("Error initializing DBConfig", e);
        }
    }

}
