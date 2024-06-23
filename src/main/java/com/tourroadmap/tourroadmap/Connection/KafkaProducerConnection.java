// package com.tourroadmap.tourroadmap.Connection;

// import org.apache.kafka.clients.producer.KafkaProducer;
// import org.apache.kafka.clients.producer.Producer;
// import org.apache.kafka.clients.producer.ProducerRecord;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.stereotype.Component;

// import com.tourroadmap.tourroadmap.Config.KafkaProducerConfig;

// import jakarta.annotation.PreDestroy;

// import java.util.*;

// @Component
// @Configuration
// public class KafkaProducerConnection {
// private static final Logger log =
// LoggerFactory.getLogger(KafkaProducerConnection.class);

// private Producer<String, String> producer;

// public KafkaProducerConnection() {
// this.producer = createProducer();

// }

// private Producer<String, String> createProducer() {
// try {
// log.info("!!!!!!!!!! Kafka producer started...");
// Properties props = new Properties();
// props.put("bootstrap.servers", KafkaProducerConfig.BootstrapServers);
// props.put("key.serializer", KafkaProducerConfig.KeySerializer);
// props.put("value.serializer", KafkaProducerConfig.ValueSerializer);
// return new KafkaProducer<>(props);
// } catch (Exception e) {
// log.error("Error creating Kafka producer: " + e.getMessage());
// return null;
// }
// }

// private void ensureProducerIsInitialized() {
// if (producer == null) {
// log.info("######### Reinitializing Kafka producer...");
// producer = createProducer();
// } else {
// log.info("*********** kafka producer ok not null");
// }
// }

// public void sendMessageToTopic(String topic, String message) {
// sendMessage(KafkaProducerConfig.TopicName, message);
// }

// private void sendMessage(String topicName, String message) {
// ensureProducerIsInitialized();
// try {
// log.info("Producing Kafka message to topic '{}': {}", topicName, message);
// producer.send(new ProducerRecord<>(topicName, message));
// } catch (Exception e) {
// log.error("Error producing Kafka message: " + e.getMessage());
// producer = null; // Mark producer as null to trigger reinitialization next
// time
// }
// }

// @PreDestroy
// public void closeProducer() {
// try {
// log.info("Closing Kafka producer...");
// if (producer != null) {
// producer.close();
// producer = null;
// }
// } catch (Exception e) {
// log.error("Error closing Kafka producer: " + e.getMessage());
// }
// }
// }
