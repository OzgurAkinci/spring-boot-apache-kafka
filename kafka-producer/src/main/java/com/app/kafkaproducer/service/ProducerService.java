package com.app.kafkaproducer.service;

import com.app.kafkaproducer.model.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, MessageDto> kafkaTemplate;

    @Value("${spring.kafka.producer.topic}")
    private String topicName;

    public void sendMessage(MessageDto msg) {
        kafkaTemplate.send(topicName, msg);
    }
}