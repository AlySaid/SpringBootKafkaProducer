//package com.producer.kafkaService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import com.producer.entity.KafkaLogger;
//
//@Service
//@Component
//public class KafkaProducer {
//
//	@Autowired
//	private KafkaTemplate<String,KafkaLogger> kafkaTemplate;
//	
//	public void sendMessage(KafkaLogger message) {
//		kafkaTemplate.send("first_topic",message);
//	}
//}
//
