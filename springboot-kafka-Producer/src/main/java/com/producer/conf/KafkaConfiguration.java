package com.producer.conf;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.producer.entity.KafkaLogger;

@Configuration
public class KafkaConfiguration {

	private String server = "192.168.150.142:9092";

	@Bean
	ProducerFactory<String, KafkaLogger> producerFactory() {
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, server);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());
		configProps.put(JsonDeserializer.TRUSTED_PACKAGES, "*"); 
		return new DefaultKafkaProducerFactory<>(configProps);
	}

	@Bean
    KafkaTemplate<String, KafkaLogger> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}
}
