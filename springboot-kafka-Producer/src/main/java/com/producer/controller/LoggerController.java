package com.producer.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producer.entity.KafkaLogger;
import com.producer.repository.LoggerRepo;

@RestController
public class LoggerController {
	private static final String TOPIC = "t1";
	@Autowired
	LoggerRepo loggerRepo;
//	@Autowired
//	KafkaProducer kafkaProducer;

	@Autowired
	KafkaTemplate<String, KafkaLogger> kafkaTemplate;

	@GetMapping("/addLog")
	public void addLog() {
		KafkaLogger  kafkaLog = new KafkaLogger();
		kafkaLog.setCurrentDateTime(new Date());
		kafkaLog.setRequest("request ");
		kafkaLog.setResponse("response ");
		kafkaTemplate.send(TOPIC, kafkaLog);
	}

	@GetMapping("/logs")
	public List<KafkaLogger> getLogs() {

		return loggerRepo.findAll();

	}

}
