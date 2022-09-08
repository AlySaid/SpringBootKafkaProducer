package com.producer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.producer.entity.KafkaLogger;

public interface LoggerRepo extends JpaRepository<KafkaLogger, Long>{

}
