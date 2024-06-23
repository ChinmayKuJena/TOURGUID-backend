// package com.tourroadmap.tourroadmap.KafkaService;

// import java.sql.ResultSet;
// import java.sql.SQLException;

// import org.springframework.stereotype.Service;

// import com.tourroadmap.tourroadmap.Config.KafkaProducerConfig;
// import com.tourroadmap.tourroadmap.Connection.KafkaProducerConnection;
// import com.tourroadmap.tourroadmap.POJO.ProducerEntity;

// @Service
// public class KafkaProducerService {
//     private final KafkaProducerConnection kafkaProducerConnection;

//     public KafkaProducerService(KafkaProducerConnection kafkaProducerConnection) {
//         this.kafkaProducerConnection = kafkaProducerConnection;
//     }

//     public void placeSearchData(ResultSet rs, String uuid) throws SQLException {

//         ProducerEntity place2 = new ProducerEntity(
//                 rs.getString("placeid"),
//                 rs.getString("stateid"),
//                 rs.getString("placename"),
//                 rs.getString("placedetails"),
//                 rs.getString("state"),
//                 uuid);
//         kafkaProducerConnection.sendMessageToTopic(KafkaProducerConfig.TopicName, place2.toString());
//     }
// }
