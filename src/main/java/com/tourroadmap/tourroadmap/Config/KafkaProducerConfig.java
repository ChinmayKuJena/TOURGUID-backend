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
public class KafkaProducerConfig {
    public static final org.slf4j.Logger log = LoggerFactory.getLogger(KafkaProducerConfig.class);

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;
    @Value("${spring.kafka.producer.key-serializer}")
    private String keySerializer;
    @Value("${spring.kafka.producer.value-serializer}")
    private String valueSerializer;
    @Value("${kafka.topic-name1}")
    private String topicName1;

    public static String BootstrapServers;
    public static String KeySerializer;
    public static String ValueSerializer;
    public static String TopicName;

    @PostConstruct
    public void init() {

        try {
            BootstrapServers = this.bootstrapServers;
            KeySerializer = this.keySerializer;
            ValueSerializer = this.valueSerializer;
            TopicName = topicName1;
        } catch (Exception e) {
            log.error("error", e);

        }
    }

}
